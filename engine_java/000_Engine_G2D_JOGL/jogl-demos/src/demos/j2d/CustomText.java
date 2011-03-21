/*
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed or intended for use
 * in the design, construction, operation or maintenance of any nuclear
 * facility.
 * 
 * Sun gratefully acknowledges that this software was originally authored
 * and developed by Kenneth Bradley Russell and Christopher John Kline.
 */

package demos.j2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.image.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import com.sun.opengl.util.*;
import com.sun.opengl.util.j2d.*;
import com.sun.opengl.util.texture.*;

import demos.common.*;
import demos.util.*;
import gleem.linalg.*;

/** Illustrates more advanced use of the TextRenderer class; shows how
    to do text filled with a linear Java 2D gradient. */

public class CustomText extends Demo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Custom Text");
    frame.getContentPane().setLayout(new BorderLayout());

    GLCanvas canvas = new GLCanvas();
    final CustomText demo = new CustomText();

    canvas.addGLEventListener(demo);
    frame.getContentPane().add(canvas, BorderLayout.CENTER);
    frame.getContentPane().add(demo.buildGUI(), BorderLayout.NORTH);

    DisplayMode mode =
      GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();

    frame.setSize((int) (0.75f * mode.getWidth()),
                  (int) (0.75f * mode.getHeight()));

    final Animator animator = new Animator(canvas);
    frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          // Run this on another thread than the AWT event queue to
          // make sure the call to Animator.stop() completes before
          // exiting
          new Thread(new Runnable() {
              public void run() {
                animator.stop();
                System.exit(0);
              }
            }).start();
        }
      });
    frame.show();
    animator.start();
  }

  // Put a little physics on the text to make it look nicer
  private static final float INIT_ANG_VEL_MAG = 0.3f;
  private static final float INIT_VEL_MAG = 400.0f;
  private static final int   DEFAULT_DROP_SHADOW_DIST = 20;

  // Information about each piece of text
  private static class TextInfo {
    float angularVelocity;
    Vec2f velocity;

    float angle;
    Vec2f position;

    String text;
  }

  private List/*<TextInfo>*/ textInfo = new ArrayList/*<TextInfo>*/();
  private Time time;
  private Texture backgroundTexture;
  private TextRenderer renderer;
  private Random random = new Random();
  private GLU glu = new GLU();
  private int width;
  private int height;

  private int maxTextWidth;

  private FPSCounter fps;

  public Container buildGUI() {
    // Create gui
    JPanel panel = new JPanel();
    JButton button = new JButton("Less Text");
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          lessText();
        }
      });
    panel.add(button);
    button = new JButton("More Text");
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          moreText();
        }
      });
    panel.add(button);
    return panel;
  }

  public void moreText() {
    int numToAdd = (int) (textInfo.size() * 0.5f);
    if (numToAdd == 0)
      numToAdd = 1;
    for (int i = 0; i < numToAdd; i++) {
      textInfo.add(randomTextInfo());
    }
  }

  public void lessText() {
    if (textInfo.size() == 1)
      return;
    int numToRemove = textInfo.size() / 3;
    if (numToRemove == 0)
      numToRemove = 1;
    for (int i = 0; i < numToRemove; i++) {
      textInfo.remove(textInfo.size() - 1);
    }
  }

  public void init(GLAutoDrawable drawable) {
    // Create the background texture
    BufferedImage bgImage = new BufferedImage(2, 2, BufferedImage.TYPE_BYTE_GRAY);
    Graphics2D g = bgImage.createGraphics();
    g.setColor(new Color(0.3f, 0.3f, 0.3f));
    g.fillRect(0, 0, 2, 2);
    g.setColor(new Color(0.7f, 0.7f, 0.7f));
    g.fillRect(0, 0, 1, 1);
    g.fillRect(1, 1, 1, 1);
    g.dispose();
    backgroundTexture = TextureIO.newTexture(bgImage, false);
    backgroundTexture.bind();
    backgroundTexture.setTexParameteri(GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
    backgroundTexture.setTexParameteri(GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
    backgroundTexture.setTexParameteri(GL.GL_TEXTURE_WRAP_S,     GL.GL_REPEAT);
    backgroundTexture.setTexParameteri(GL.GL_TEXTURE_WRAP_T,     GL.GL_REPEAT);

    // Create the text renderer
    renderer = new TextRenderer(new Font("Serif", Font.PLAIN, 72), true, true,
                                new CustomRenderDelegate(52, 10, Color.BLUE, Color.CYAN));

    // Create the FPS counter
    fps = new FPSCounter(drawable, 36);

    width = drawable.getWidth();
    height = drawable.getWidth();

    // Compute maximum width of text we're going to draw to avoid
    // popping in/out at edges
    maxTextWidth = (int) renderer.getBounds("Java 2D").getWidth();
    maxTextWidth = Math.max(maxTextWidth, (int) renderer.getBounds("OpenGL").getWidth());

    // Create random text
    textInfo.clear();
    for (int i = 0; i < 100; i++) {
      textInfo.add(randomTextInfo());
    }

    time = new SystemTime();
    ((SystemTime) time).rebase();

    // Set up properties; note we don't need the depth buffer in this demo
    GL gl = drawable.getGL();
    gl.glDisable(GL.GL_DEPTH_TEST);
    // Turn off vsync if we can
    gl.setSwapInterval(0);
  }

  public void display(GLAutoDrawable drawable) {
    time.update();

    // Update velocities and positions of all text
    float deltaT = (float) time.deltaT();
    Vec2f tmp = new Vec2f();
    for (Iterator iter = textInfo.iterator(); iter.hasNext(); ) {
      TextInfo info = (TextInfo) iter.next();

      // Randomize things a little bit at run time
      if (random.nextInt(1000) == 0) {
        info.angularVelocity = INIT_ANG_VEL_MAG * (randomAngle() - 180);
        info.velocity = randomVelocityVec2f(INIT_VEL_MAG, INIT_VEL_MAG);
      }

      // Now update angles and positions
      info.angle += info.angularVelocity * deltaT;
      tmp.set(info.velocity);
      tmp.scale(deltaT);
      info.position.add(tmp);

      // Wrap angles and positions
      if (info.angle < 0) {
        info.angle += 360;
      } else if (info.angle > 360) {
        info.angle -= 360;
      }
      // Use maxTextWidth to avoid popping in/out at edges
      // Would be better to do oriented bounding rectangle computation
      if (info.position.x() < -maxTextWidth) {
        info.position.setX(info.position.x() + drawable.getWidth() + 2 * maxTextWidth);
      } else if (info.position.x() > drawable.getWidth() + maxTextWidth) {
        info.position.setX(info.position.x() - drawable.getWidth() - 2 * maxTextWidth);
      }
      if (info.position.y() < -maxTextWidth) {
        info.position.setY(info.position.y() + drawable.getHeight() + 2 * maxTextWidth);
      } else if (info.position.y() > drawable.getHeight() + maxTextWidth) {
        info.position.setY(info.position.y() - drawable.getHeight() - 2 * maxTextWidth);
      }
    }

    GL gl = drawable.getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(0, drawable.getWidth(), 0, drawable.getHeight());
    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();

    // Draw the background texture
    backgroundTexture.enable();
    backgroundTexture.bind();
    TextureCoords coords = backgroundTexture.getImageTexCoords();
    int w = drawable.getWidth();
    int h = drawable.getHeight();
    float fw = w / 100.0f;
    float fh = h / 100.0f;
    gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
    gl.glBegin(GL.GL_QUADS);
    gl.glTexCoord2f(fw * coords.left(), fh * coords.bottom());
    gl.glVertex3f(0, 0, 0);
    gl.glTexCoord2f(fw * coords.right(), fh * coords.bottom());
    gl.glVertex3f(w, 0, 0);
    gl.glTexCoord2f(fw * coords.right(), fh * coords.top());
    gl.glVertex3f(w, h, 0);
    gl.glTexCoord2f(fw * coords.left(), fh * coords.top());
    gl.glVertex3f(0, h, 0);
    gl.glEnd();
    backgroundTexture.disable();

    // Render all text
    renderer.beginRendering(drawable.getWidth(), drawable.getHeight());

    // Note we're doing some slightly fancy stuff to position the text.
    // We tell the text renderer to render the text at the origin, and
    // manipulate the modelview matrix to put the text where we want.

    gl.glMatrixMode(GL.GL_MODELVIEW);

    for (Iterator iter = textInfo.iterator(); iter.hasNext(); ) {
      TextInfo info = (TextInfo) iter.next();
      gl.glLoadIdentity();
      gl.glTranslatef(info.position.x(),
                      info.position.y(),
                      0);
      gl.glRotatef(info.angle, 0, 0, 1);
      renderer.draw(info.text, 0, 0);
      renderer.flush();
    }

    renderer.endRendering();

    // Use the FPS renderer last to render the FPS
    fps.draw();
  }

  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    this.width = width;
    this.height = height;
  }

  public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}

  //----------------------------------------------------------------------
  // Internals only below this point
  //

  private TextInfo randomTextInfo() {
    TextInfo info = new TextInfo();
    info.text = randomString();
    info.angle = randomAngle();
    info.position = randomVec2f(width, height);

    info.angularVelocity = INIT_ANG_VEL_MAG * (randomAngle() - 180);
    info.velocity = randomVelocityVec2f(INIT_VEL_MAG, INIT_VEL_MAG);

    return info;
  }

  private String randomString() {
    switch (random.nextInt(3)) {
      case 0:
        return "OpenGL";
      case 1:
        return "Java 2D";
      default:
        return "Text";
    }
  }

  private float randomAngle() {
    return 360.0f * random.nextFloat();
  }

  private Vec2f randomVec2f(float x, float y) {
    return new Vec2f(x * random.nextFloat(),
                     y * random.nextFloat());
  }

  private Vec2f randomVelocityVec2f(float x, float y) {
    return new Vec2f(x * (random.nextFloat() - 0.5f),
                     y * (random.nextFloat() - 0.5f));
  }

  private static final Color DROP_SHADOW_COLOR = new Color(0, 0, 0, 0.5f);
  class CustomRenderDelegate implements TextRenderer.RenderDelegate {
    private float gradientSize;
    private int dropShadowDepth;
    private Color color1;
    private Color color2;


    CustomRenderDelegate(float gradientSize, int dropShadowDepth, Color color1, Color color2) {
      this.gradientSize = gradientSize;
      this.dropShadowDepth = dropShadowDepth;
      this.color1 = color1;
      this.color2 = color2;
    }

    public boolean intensityOnly() {
      return false;
    }

    public Rectangle2D getBounds(CharSequence str,
                                 Font font,
                                 FontRenderContext frc) {
      return getBounds(str.toString(), font, frc);
    }

    public Rectangle2D getBounds(String str,
                                 Font font,
                                 FontRenderContext frc) {
      return getBounds(font.createGlyphVector(frc, str), frc);
    }

    public Rectangle2D getBounds(GlyphVector gv, FontRenderContext frc) {
      Rectangle2D stringBounds = gv.getPixelBounds(frc, 0, 0);
      return new Rectangle2D.Double(stringBounds.getX(),
                                    stringBounds.getY(),
                                    stringBounds.getWidth() + dropShadowDepth,
                                    stringBounds.getHeight() + dropShadowDepth);
    }
    
    public void drawGlyphVector(Graphics2D graphics, GlyphVector str, int x, int y) {
      graphics.setColor(DROP_SHADOW_COLOR);
      graphics.drawGlyphVector(str, x + dropShadowDepth, y + dropShadowDepth);
      graphics.setColor(Color.WHITE);
      graphics.setPaint(new GradientPaint(x, y, color1,
                                          x, y + gradientSize / 2, color2,
                                          true));
      graphics.drawGlyphVector(str, x, y);
    }

    public void draw(Graphics2D graphics, String str, int x, int y) {
      graphics.setColor(DROP_SHADOW_COLOR);
      graphics.drawString(str, x + dropShadowDepth, y + dropShadowDepth);
      graphics.setColor(Color.WHITE);
      graphics.setPaint(new GradientPaint(x, y, color1,
                                          x, y + gradientSize / 2, color2,
                                          true));
      graphics.drawString(str, x, y);
    }
  }
}
