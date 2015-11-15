# 简介 #

CellEngineIOS模块时用OpenGLES和OpenAL开发的2d游戏和声音解决方案。
（本文阅读对象需要了解IOS的OpenGLES项目）
引擎代码svn地址
http://code.google.com/p/cellengine/source/browse/trunk/engine_ios/CellEngineIOS

# 创建IOS项目 #
  1. 创建你的IOS项目<br>选择OpenG LES Application并将CellEngineIOS导入到你的项目里<br>
<ol><li>初始化项目<br>在你的IOS项目的EAGLView里，找到这几个地方。<br>
<pre><code>- (id)initWithCoder:(NSCoder*)coder<br>
{<br>
	// 你的其他的初始化代码 ...<br>
		<br>
	// 初始化CellEngine<br>
	com_cell::ScreenManager::init(new Screens());<br>
	// 这里的Screens时你的屏幕管理类<br>
}<br>
- (void)dealloc <br>
{<br>
	// 清理CellEngine内存<br>
	com_cell::ScreenManager::destory();<br>
<br>
	// 你的其他的清理代码 ...<br>
}<br>
- (void)drawView <br>
{<br>
	// 你的重绘方法<br>
	// Replace the implementation of this method to do your own custom drawing<br>
	[EAGLContext setCurrentContext:context];<br>
	glBindFramebufferOES(GL_FRAMEBUFFER_OES, viewFramebuffer);<br>
    <br>
	// main update<br>
	com_cell::getScreenManager()-&gt;call_Update([self bounds]);<br>
	<br>
	glBindRenderbufferOES(GL_RENDERBUFFER_OES, viewRenderbuffer);<br>
	[context presentRenderbuffer:GL_RENDERBUFFER_OES];<br>
	<br>
	[[NSRunLoop currentRunLoop] runUntilDate: [NSDate distantPast]];<br>
}<br>
- (void)stopAnimation<br>
{<br>
	// 你的动画暂停事件<br>
	com_cell::getScreenManager()-&gt;call_Pause();<br>
}<br>
////////////////////////////////////////////////////////////////////////////////////////////////<br>
// touch events<br>
// 触摸事件和重力感应事件的传播<br>
// pointer pressed<br>
- (void) touchesBegan:(NSSet*)touches withEvent:(UIEvent*)event<br>
{<br>
	/////////////////////////////////////////////////////////////////////////<br>
	// CELL ENGINE EVENT<br>
	// system call<br>
	com_cell::getScreenManager()-&gt;call_PointerPressed(touches, self);<br>
	/////////////////////////////////////////////////////////////////////////<br>
	<br>
}<br>
<br>
// pointer moved<br>
- (void) touchesMoved:(NSSet*)touches withEvent:(UIEvent*)event<br>
{<br>
	<br>
	/////////////////////////////////////////////////////////////////////////<br>
	// CELL ENGINE EVENT<br>
	// system call<br>
	com_cell::getScreenManager()-&gt;call_PointerDragged(touches, self);<br>
	/////////////////////////////////////////////////////////////////////////<br>
	<br>
}<br>
<br>
<br>
<br>
// pointer released<br>
- (void) touchesEnded:(NSSet*)touches withEvent:(UIEvent*)event<br>
{<br>
	/////////////////////////////////////////////////////////////////////////<br>
	// CELL ENGINE EVENT<br>
	// system call<br>
	com_cell::getScreenManager()-&gt;call_PointerReleased(touches, self);<br>
	/////////////////////////////////////////////////////////////////////////<br>
	<br>
}<br>
<br>
////////////////////////////////////////////////////////////////////////////////////////////////<br>
// accelerometer events<br>
// <br>
- (void)accelerometer:(UIAccelerometer*)accelerometer didAccelerate:(UIAcceleration*)acceleration<br>
{<br>
	//Use a basic low-pass filter to only keep the gravity in the accelerometer values<br>
	//printf("acc : x=%f y=%f z=%f\n",acceleration.x,acceleration.y,acceleration.z);<br>
	com_cell::Vector3D vector;<br>
	vector.x = acceleration.x;<br>
	vector.y = acceleration.y;<br>
	vector.z = acceleration.z;<br>
	/////////////////////////////////////////////////////////////////////////<br>
	// CELL ENGINE EVENT<br>
	com_cell::getScreenManager()-&gt;call_Accelerometer(vector);<br>
	/////////////////////////////////////////////////////////////////////////<br>
}<br>
</code></pre></li></ol>



Add your content here.  Format your content with:<br>
<ul><li>Text in <b>bold</b> or <i>italic</i>
</li><li>Headings, paragraphs, and lists<br>
</li><li>Automatic links to other wiki pages