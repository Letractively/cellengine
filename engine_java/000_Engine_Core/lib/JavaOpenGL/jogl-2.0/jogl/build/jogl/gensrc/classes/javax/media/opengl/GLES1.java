/* !---- DO NOT EDIT: This file autogenerated by com\sun\gluegen\opengl\GLEmitter.java on Sun Jan 24 02:14:34 PST 2010 ----! */

package javax.media.opengl;

import java.nio.*;
import java.util.*;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
import com.sun.opengl.impl.*;
import javax.media.opengl.GLES1;
import javax.media.opengl.GLES2;
import javax.media.opengl.GL2;
import com.sun.opengl.impl.InternalBufferUtil;
import com.sun.gluegen.runtime.*;

 /**
  * <P> 
  * This interface contains all core embedded OpenGL methods of ES 1.x, with x >= 0,
  * inclusive, as well as most of it's extensions defined at the
  * time of this specification.
  * </P>
  */
public interface GLES1 extends GLBase, GL, GL2ES1
{

  /** Part of <code>GL_OES_point_size_array</code> */
  public static final int GL_POINT_SIZE_ARRAY_OES = 0x8B9C;
  /** Part of <code>GL_OES_point_size_array</code> */
  public static final int GL_POINT_SIZE_ARRAY_TYPE_OES = 0x898A;
  /** Part of <code>GL_OES_point_size_array</code> */
  public static final int GL_POINT_SIZE_ARRAY_STRIDE_OES = 0x898B;
  /** Part of <code>GL_OES_point_size_array</code> */
  public static final int GL_POINT_SIZE_ARRAY_POINTER_OES = 0x898C;
  /** Part of <code>GL_OES_point_size_array</code> */
  public static final int GL_POINT_SIZE_ARRAY_BUFFER_BINDING_OES = 0x8B9F;
  /** Part of <code>GL_OES_compressed_ETC1_RGB8_texture</code> */
  public static final int GL_ETC1_RGB8_OES = 0x8D64;
  /** Part of <code>GL_OES_draw_texture</code> */
  public static final int GL_TEXTURE_CROP_RECT_OES = 0x8B9D;
  /** Part of <code>GL_OES_matrix_get</code> */
  public static final int GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES = 0x898D;
  /** Part of <code>GL_OES_matrix_get</code> */
  public static final int GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES = 0x898E;
  /** Part of <code>GL_OES_matrix_get</code> */
  public static final int GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES = 0x898F;
  /** Part of <code>GL_OES_matrix_palette</code> */
  public static final int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 0x8B9E;
  /** Part of <code>GL_OES_vertex_half_float</code> */
  public static final int GL_HALF_FLOAT_OES = 0x8D61;

  /** Entry point to C language function: <code> void {@native glAlphaFuncx}(GLenum func, GLclampx ref); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glAlphaFuncx(int func, int ref);

  /** Entry point to C language function: <code> void {@native glClearColorx}(GLclampx red, GLclampx green, GLclampx blue, GLclampx alpha); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glClearColorx(int red, int green, int blue, int alpha);

  /** Entry point to C language function: <code> void {@native glClearDepthx}(GLclampx depth); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glClearDepthx(int depth);

  /** Entry point to C language function: <code> void {@native glClipPlanef}(GLenum plane, const GLfloat *  equation); </code> <br>Part of <code>GL_VERSION_ES_CM</code>   */
  public void glClipPlanef(int plane, java.nio.FloatBuffer equation);

  /** Entry point to C language function: <code> void {@native glClipPlanef}(GLenum plane, const GLfloat *  equation); </code> <br>Part of <code>GL_VERSION_ES_CM</code>   */
  public void glClipPlanef(int plane, float[] equation, int equation_offset);

  /** Entry point to C language function: <code> void {@native glClipPlanex}(GLenum plane, const GLfixed *  equation); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glClipPlanex(int plane, java.nio.IntBuffer equation);

  /** Entry point to C language function: <code> void {@native glClipPlanex}(GLenum plane, const GLfixed *  equation); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glClipPlanex(int plane, int[] equation, int equation_offset);

  /** Entry point to C language function: <code> void {@native glColor4x}(GLfixed red, GLfixed green, GLfixed blue, GLfixed alpha); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glColor4x(int red, int green, int blue, int alpha);

  /** Entry point to C language function: <code> void {@native glDepthRangex}(GLclampx zNear, GLclampx zFar); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glDepthRangex(int zNear, int zFar);

  /** Entry point to C language function: <code> void {@native glDrawTexfOES}(GLfloat x, GLfloat y, GLfloat z, GLfloat width, GLfloat height); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexfOES(float x, float y, float z, float width, float height);

  /** Entry point to C language function: <code> void {@native glDrawTexfvOES}(const GLfloat *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexfvOES(java.nio.FloatBuffer coords);

  /** Entry point to C language function: <code> void {@native glDrawTexfvOES}(const GLfloat *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexfvOES(float[] coords, int coords_offset);

  /** Entry point to C language function: <code> void {@native glDrawTexiOES}(GLint x, GLint y, GLint z, GLint width, GLint height); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexiOES(int x, int y, int z, int width, int height);

  /** Entry point to C language function: <code> void {@native glDrawTexivOES}(const GLint *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexivOES(java.nio.IntBuffer coords);

  /** Entry point to C language function: <code> void {@native glDrawTexivOES}(const GLint *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexivOES(int[] coords, int coords_offset);

  /** Entry point to C language function: <code> void {@native glDrawTexsOES}(GLshort x, GLshort y, GLshort z, GLshort width, GLshort height); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexsOES(short x, short y, short z, short width, short height);

  /** Entry point to C language function: <code> void {@native glDrawTexsvOES}(const GLshort *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexsvOES(java.nio.ShortBuffer coords);

  /** Entry point to C language function: <code> void {@native glDrawTexsvOES}(const GLshort *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexsvOES(short[] coords, int coords_offset);

  /** Entry point to C language function: <code> void {@native glDrawTexxOES}(GLfixed x, GLfixed y, GLfixed z, GLfixed width, GLfixed height); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexxOES(int x, int y, int z, int width, int height);

  /** Entry point to C language function: <code> void {@native glDrawTexxvOES}(const GLfixed *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexxvOES(java.nio.IntBuffer coords);

  /** Entry point to C language function: <code> void {@native glDrawTexxvOES}(const GLfixed *  coords); </code> <br>Part of <code>GL_OES_draw_texture</code>   */
  public void glDrawTexxvOES(int[] coords, int coords_offset);

  /** Entry point to C language function: <code> void {@native glEGLImageTargetRenderbufferStorageOES}(GLenum target, GLeglImageOES image); </code> <br>Part of <code>GL_OES_EGL_image</code>   */
  public void glEGLImageTargetRenderbufferStorageOES(int target, java.nio.Buffer image);

  /** Entry point to C language function: <code> void {@native glEGLImageTargetTexture2DOES}(GLenum target, GLeglImageOES image); </code> <br>Part of <code>GL_OES_EGL_image</code>   */
  public void glEGLImageTargetTexture2DOES(int target, java.nio.Buffer image);

  /** Entry point to C language function: <code> void {@native glFogx}(GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glFogx(int pname, int param);

  /** Entry point to C language function: <code> void {@native glFogxv}(GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glFogxv(int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glFogxv}(GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glFogxv(int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glFrustumx}(GLfixed left, GLfixed right, GLfixed bottom, GLfixed top, GLfixed zNear, GLfixed zFar); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glFrustumx(int left, int right, int bottom, int top, int zNear, int zFar);

  /** Entry point to C language function: <code> void {@native glGetClipPlanef}(GLenum pname, GLfloat *  eqn); </code> <br>Part of <code>GL_VERSION_ES_CM</code>   */
  public void glGetClipPlanef(int pname, java.nio.FloatBuffer eqn);

  /** Entry point to C language function: <code> void {@native glGetClipPlanef}(GLenum pname, GLfloat *  eqn); </code> <br>Part of <code>GL_VERSION_ES_CM</code>   */
  public void glGetClipPlanef(int pname, float[] eqn, int eqn_offset);

  /** Entry point to C language function: <code> void {@native glGetClipPlanex}(GLenum pname, GLfixed *  eqn); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetClipPlanex(int pname, java.nio.IntBuffer eqn);

  /** Entry point to C language function: <code> void {@native glGetClipPlanex}(GLenum pname, GLfixed *  eqn); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetClipPlanex(int pname, int[] eqn, int eqn_offset);

  /** Entry point to C language function: <code> void {@native glGetFixedv}(GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetFixedv(int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glGetFixedv}(GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetFixedv(int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glGetLightxv}(GLenum light, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetLightxv(int light, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glGetLightxv}(GLenum light, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetLightxv(int light, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glGetMaterialxv}(GLenum face, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetMaterialxv(int face, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glGetMaterialxv}(GLenum face, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetMaterialxv(int face, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glGetTexEnvxv}(GLenum tenv, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetTexEnvxv(int tenv, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glGetTexEnvxv}(GLenum tenv, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetTexEnvxv(int tenv, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glGetTexGenxvOES}(GLenum coord, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_OES_texture_cube_map</code>   */
  public void glGetTexGenxv(int coord, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glGetTexGenxvOES}(GLenum coord, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_OES_texture_cube_map</code>   */
  public void glGetTexGenxv(int coord, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glGetTexParameterxv}(GLenum target, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetTexParameterxv(int target, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glGetTexParameterxv}(GLenum target, GLenum pname, GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glGetTexParameterxv(int target, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glLightModelx}(GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLightModelx(int pname, int param);

  /** Entry point to C language function: <code> void {@native glLightModelxv}(GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLightModelxv(int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glLightModelxv}(GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLightModelxv(int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glLightx}(GLenum light, GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLightx(int light, int pname, int param);

  /** Entry point to C language function: <code> void {@native glLightxv}(GLenum light, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLightxv(int light, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glLightxv}(GLenum light, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLightxv(int light, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glLineWidthx}(GLfixed width); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLineWidthx(int width);

  /** Entry point to C language function: <code> void {@native glLoadMatrixx}(const GLfixed *  m); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLoadMatrixx(java.nio.IntBuffer m);

  /** Entry point to C language function: <code> void {@native glLoadMatrixx}(const GLfixed *  m); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glLoadMatrixx(int[] m, int m_offset);

  /** Entry point to C language function: <code> void {@native glLoadPaletteFromModelViewMatrixOES}(void); </code> <br>Part of <code>GL_OES_matrix_palette</code>   */
  public void glLoadPaletteFromModelViewMatrixOES();

  /** Entry point to C language function: <code> void {@native glMaterialx}(GLenum face, GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glMaterialx(int face, int pname, int param);

  /** Entry point to C language function: <code> void {@native glMaterialxv}(GLenum face, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glMaterialxv(int face, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glMaterialxv}(GLenum face, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glMaterialxv(int face, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glMultMatrixx}(const GLfixed *  m); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glMultMatrixx(java.nio.IntBuffer m);

  /** Entry point to C language function: <code> void {@native glMultMatrixx}(const GLfixed *  m); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glMultMatrixx(int[] m, int m_offset);

  /** Entry point to C language function: <code> void {@native glMultiTexCoord4x}(GLenum target, GLfixed s, GLfixed t, GLfixed r, GLfixed q); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glMultiTexCoord4x(int target, int s, int t, int r, int q);

  /** Entry point to C language function: <code> void {@native glNormal3x}(GLfixed nx, GLfixed ny, GLfixed nz); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glNormal3x(int nx, int ny, int nz);

  /** Entry point to C language function: <code> void {@native glOrthox}(GLfixed left, GLfixed right, GLfixed bottom, GLfixed top, GLfixed zNear, GLfixed zFar); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glOrthox(int left, int right, int bottom, int top, int zNear, int zFar);

  /** Entry point to C language function: <code> void {@native glPointParameterx}(GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glPointParameterx(int pname, int param);

  /** Entry point to C language function: <code> void {@native glPointParameterxv}(GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glPointParameterxv(int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glPointParameterxv}(GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glPointParameterxv(int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glPointSizePointerOES}(GLenum type, GLsizei stride, const GLvoid *  pointer); </code> <br>Part of <code>GL_OES_point_size_array</code>   */
  public void glPointSizePointerOES(int type, int stride, java.nio.Buffer pointer);

  /** Entry point to C language function: <code> void {@native glPointSizex}(GLfixed size); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glPointSizex(int size);

  /** Entry point to C language function: <code> void {@native glPolygonOffsetx}(GLfixed factor, GLfixed units); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glPolygonOffsetx(int factor, int units);

  /** Entry point to C language function: <code> GLbitfield {@native glQueryMatrixxOES}(GLfixed *  mantissa, GLint *  exponent); </code> <br>Part of <code>GL_OES_query_matrix</code>   */
  public int glQueryMatrixxOES(java.nio.IntBuffer mantissa, java.nio.IntBuffer exponent);

  /** Entry point to C language function: <code> GLbitfield {@native glQueryMatrixxOES}(GLfixed *  mantissa, GLint *  exponent); </code> <br>Part of <code>GL_OES_query_matrix</code>   */
  public int glQueryMatrixxOES(int[] mantissa, int mantissa_offset, int[] exponent, int exponent_offset);

  /** Entry point to C language function: <code> void {@native glRotatex}(GLfixed angle, GLfixed x, GLfixed y, GLfixed z); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glRotatex(int angle, int x, int y, int z);

  /** Entry point to C language function: <code> void {@native glSampleCoveragex}(GLclampx value, GLboolean invert); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glSampleCoveragex(int value, boolean invert);

  /** Entry point to C language function: <code> void {@native glScalex}(GLfixed x, GLfixed y, GLfixed z); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glScalex(int x, int y, int z);

  /** Entry point to C language function: <code> void {@native glTexEnvx}(GLenum target, GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTexEnvx(int target, int pname, int param);

  /** Entry point to C language function: <code> void {@native glTexEnvxv}(GLenum target, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTexEnvxv(int target, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glTexEnvxv}(GLenum target, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTexEnvxv(int target, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glTexGenxOES}(GLenum coord, GLenum pname, GLfixed param); </code> <br>Part of <code>GL_OES_texture_cube_map</code>   */
  public void glTexGenx(int coord, int pname, int param);

  /** Entry point to C language function: <code> void {@native glTexGenxvOES}(GLenum coord, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_OES_texture_cube_map</code>   */
  public void glTexGenxv(int coord, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glTexGenxvOES}(GLenum coord, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_OES_texture_cube_map</code>   */
  public void glTexGenxv(int coord, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glTexParameterx}(GLenum target, GLenum pname, GLfixed param); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTexParameterx(int target, int pname, int param);

  /** Entry point to C language function: <code> void {@native glTexParameterxv}(GLenum target, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTexParameterxv(int target, int pname, java.nio.IntBuffer params);

  /** Entry point to C language function: <code> void {@native glTexParameterxv}(GLenum target, GLenum pname, const GLfixed *  params); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTexParameterxv(int target, int pname, int[] params, int params_offset);

  /** Entry point to C language function: <code> void {@native glTranslatex}(GLfixed x, GLfixed y, GLfixed z); </code> <br>Part of <code>GL_VERSION_ES_CL_CM</code>   */
  public void glTranslatex(int x, int y, int z);


} // end of class GLES1
