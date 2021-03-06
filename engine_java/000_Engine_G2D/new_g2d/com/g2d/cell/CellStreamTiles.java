package com.g2d.cell;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cell.gameedit.StreamTiles;
import com.cell.gameedit.object.ImagesSet;
import com.cell.gfx.IPalette;
import com.g2d.Engine;
import com.g2d.Image;

public class CellStreamTiles extends StreamTiles
{
	public CellStreamTiles(ImagesSet img, CellSetResource res) {
		super(img, res);
	}

	/***
	 * 是否单独输出每张图
	 * @return
	 */
	public boolean isTile() {
		return set.getOutput().isTile();
	}
	
	/**
	 * 是否输出整图
	 * @return
	 */
	public boolean isGroup() {
		return set.getOutput().isGroup();
	}
	
	/**
	 * 获得导出图片文件类型
	 * @return
	 */
	public String getImageExtentions() {
		return set.getOutput().getImageExtentions();
	}
	
	@Override
	protected void initImages() throws Throwable
	{
		String image_extentions = getImageExtentions();
		// 导出图片格式为整图
		if (isGroup()) {
//			System.out.println("initImages group : " + img.getName());
			byte[] idata = set.getOutput().loadRes(
					img.getName() + "." + image_extentions, null);
			Image src = Engine.getEngine().createImage(new ByteArrayInputStream(idata));
			IPalette palette = this.getPalette();
			if (palette != null) {
				src.setPalette(palette);
			}
			for (int i = 0; i < images.length; i++) {
				if (img.getClipW(i) > 0 && img.getClipH(i) > 0) {
					images[i] = src.subImage(
							img.getClipX(i), 
							img.getClipY(i), 
							img.getClipW(i), 
							img.getClipH(i));
				}
			}
		}
		// 导出图片格式为碎图
		else if (isTile()) {
//			System.out.println("initImages tiles : " + img.getName());
			IPalette palette = this.getPalette();
			for (int i = 0; i < images.length; i++) {
				if (img.getClipW(i) > 0 && img.getClipH(i) > 0) {
					byte[] idata = set.getOutput().loadRes(
							img.getName() + "/" + i + "." + image_extentions, null);
					images[i] = Engine.getEngine().createImage(new ByteArrayInputStream(idata));
					if (palette != null) {
						images[i].setPalette(palette);
					}
				}
			}
		}
	}
}
