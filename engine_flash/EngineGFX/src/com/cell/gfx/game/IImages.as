package com.cell.gfx.game
{
	public interface IImages
	{
		function getImage(index:int) : CImage;
		
		function getWidth(index:int) : int;
		
		function getHeight(index:int) : int;
		
		function render(g:IGraphics, index:int, x:int, y:int, w:int, h:int, transform:int) : void ;

	}
}