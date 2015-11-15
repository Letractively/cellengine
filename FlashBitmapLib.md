## 概述 ##

熟悉flash游戏引擎的人都知道，flash游戏开发中主要用2种渲染方式来实现游戏逻辑。

  1. **显示列表**<br>即显示单位为DisplayObject<br>
<ol><li><b>位图</b><br>所有的显示单位都是BitmapData</li></ol>


这里不讨论这2种方式哪个好哪个坏，感兴趣的朋友可以搜索"Flash游戏引擎"。比较有名的有pushbutton engine，flixel，FlashPunk等。<br>
<br>
<h2>位图引擎概念</h2>

就是一种基于BitmapData的图像缓冲技术，由开发者来确定图形渲染中，哪些内容该画如何画。可以理解为画画。我们打开一张纸，然后在画面上填充我们想要的东西。适用于大量的单位绘制，比如说粒子系统，射击类游戏，跑酷类游戏。<br>
<br>
<h2>位图引擎的实现</h2>

<ul><li>世界 <a href='http://code.google.com/p/cellengine/source/browse/trunk/engine_flash/EngineGFX/src/com/cell/gfx/game/world/CWorld.as'>CWorld</a><br>世界就是一个画布，位图缓冲区，所有游戏世界种的精灵都存在于此。</li></ul>

<ul><li>精灵 <a href='http://code.google.com/p/cellengine/source/browse/trunk/engine_flash/EngineGFX/src/com/cell/gfx/game/world/CWorldSprite.as'>CWorldSprite</a><br>世界中的一个显示对象，比如一发子弹，一架飞机等等。</li></ul>

<ul><li>摄像机 <a href='http://code.google.com/p/cellengine/source/browse/trunk/engine_flash/EngineGFX/src/com/cell/gfx/game/world/CWorldCamera.as'>CWorldCamera</a><br>如果一个世界足够大，那么不可能在一个屏幕里显示所有的精灵，因此需要卷动屏幕显示不同位置的精灵，即卷轴。</li></ul>

<pre><code>CWorld是一个Bitmap的继承类，主要负责将最终渲染结果显示到Sprite里面。<br>
在CWorld里有一个数组<br>
private var _sprites : Vector.&lt;CWorldSprite&gt; = new Vector.&lt;CWorldSprite&gt;();<br>
该数组实际上就保存了这个世界里的所有的精灵，精灵最终都以BitmapData的形式绘制到CWorld的缓冲区里面。<br>
对于位图引擎来说，摄像机的作用就是计算所有的精灵应该画到世界缓冲区的什么位置。<br>
<br>
CWorld的这个函数就是最终将所有精灵绘制到世界缓冲区上。<br>
protected function renderSprites(g:IGraphics, sprites:Vector.&lt;CWorldSprite&gt;) : void<br>
{<br>
	var x1:int = getCameraX();<br>
	var y1:int = getCameraY();<br>
	var x2:int = getCameraX() + getCameraWidth();<br>
	var y2:int = getCameraY() + getCameraHeight();<br>
 			<br>
	for each (var spr : CWorldSprite in sprites)<br>
	{<br>
		if(CMath.intersectRect(<br>
			spr.x + spr.getAnimates().w_left, <br>
			spr.y + spr.getAnimates().w_top, <br>
			spr.x + spr.getAnimates().w_right, <br>
			spr.y + spr.getAnimates().w_bottom, <br>
			x1, y1, x2, y2))<br>
		{<br>
			spr.render(g, spr.x - x1, spr.y - y1, spr.getCurrentAnimate(), spr.getCurrentFrame());<br>
		}<br>
	}<br>
}<br>
<br>
CWorldSprite.render，此方法最终会调用到CWorld的bitmapData的copyPixels方法或draw方法。<br>
这里的sourceBitmapData就是包含在精灵里的图片资源BitmapData，将精灵的图片复制或绘制到世界的缓冲区里。<br>
<br>
以上是实现位图引擎的核心思想和逻辑。<br>
</code></pre>


<h2>使画面动起来</h2>
<pre><code>位图引擎需要每帧都对缓冲区重绘更新，所以EnterFrame事件可以满足这个需求。<br>
在主Sprite里，添加EnterFrame的事件监听。将cworld创建出来后添加到Sprite容器里。<br>
在你的EnterFrame事件里写<br>
public function update(e:Event) : void <br>
{<br>
	//更新世界中所有精灵的逻辑（比如移动，播放动画帧等等。）<br>
	cworld.update();<br>
	//重绘世界所有精灵<br>
	cworld.render();<br>
}<br>
游戏逻辑需要和渲染逻辑分开以适应比如说暂停时的一些功能。<br>
此时，一个游戏主循环框架就出来了，你只需要管理cworld里所有的精灵的状态来控制游戏逻辑。<br>
</code></pre>