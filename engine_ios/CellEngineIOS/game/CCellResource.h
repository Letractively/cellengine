//
//  CCellResource.h
//  100_MusicGame
//
//  Created by wazazhang on 11-8-20.
//  Copyright 2011年 __MyCompanyName__. All rights reserved.
//
#ifndef _COM_CELL_GAME_CELL_RESOURCE
#define _COM_CELL_GAME_CELL_RESOURCE

#include "stdio.h"
#include <string>
#include <vector>
#include <map>

#include "CGFXManager.h"
#include "CGameObject.h"
#include "CSprite.h"

namespace com_cell_game
{
	using namespace com_cell;
	using namespace std;
	
	//-------------------------------------------------------------------------------------
	// Set Object
	//-------------------------------------------------------------------------------------

	class SetObject
	{
	public:
		
		int		Index;
		string	Name;
		
		virtual ~SetObject(){}
	};
	
	//-------------------------------------------------------------------------------------	
	
	class ImagesSet : public SetObject
	{
	public:
		
		int				Count;
		vector<int>		ClipsX;
		vector<int>		ClipsY;
		vector<int>		ClipsW;
		vector<int>		ClipsH;
		vector<string>	ClipsKey;
		
	public:
		
		ImagesSet(int index, string name)
		{
			Index = index;
			Name = name;
		}
		
		ImagesSet()
		{
			
		}
	};
	
	//-------------------------------------------------------------------------------------
	
	
	class MapSet : public SetObject
	{
	public:
		
		string 		ImagesName;
		
		int 		XCount;
		int 		YCount;
		int			CellW;
		int			CellH;
		
		/** TImages.Clips*[index] */
		vector<int>				TileID;
		vector<int>				TileTrans;
		/** TileID[index] & TileTrans[index] */
		vector<vector<int> > 	Animates;
		/** TerrainScene2D[y][x] == Animates[index] */
		vector<vector<int> >	TerrainScene2D;
		
		vector<int>				BlocksType;
		vector<int>				BlocksMask;
		vector<int>				BlocksX1;
		vector<int>				BlocksY1;
		vector<int>				BlocksX2;
		vector<int>				BlocksY2;
		vector<int>				BlocksW;
		vector<int>				BlocksH;
		
		/** TerrainBlock2D[y][x] == BlocksType[index] */
		vector<vector<int> >	TerrainBlock2D;
		
	public:
		
		MapSet(int index, string name)
		{
			Index = index;
			Name = name;
		}
		MapSet()
		{
			
		}
		
		inline int getLayerImagesIndex(int x, int y, int layer)
		{
			return TileID[Animates[TerrainScene2D[y][x]][layer]];
		}
		
		inline int getLayerTrans(int x, int y, int layer)
		{
			return TileTrans[Animates[TerrainScene2D[y][x]][layer]];
		}
	};

	//-------------------------------------------------------------------------------------
	
	class SpriteSet : public SetObject
	{
	public:
		
		string ImagesName;
		
		vector<int> PartX;
		vector<int> PartY;
		vector<int> PartTileID;
		vector<char> PartTileTrans;
		vector<vector<int> > Parts;
		
		vector<int> BlocksMask;
		vector<int> BlocksX1;
		vector<int> BlocksY1;
		vector<int> BlocksW;
		vector<int> BlocksH;
		vector<vector<int> > Blocks;
		
		int AnimateCount;
		vector<string> AnimateNames;
		vector<vector<int> > FrameAnimate;
		vector<vector<int> > FrameCDMap;
		vector<vector<int> > FrameCDAtk;
		vector<vector<int> > FrameCDDef;
		vector<vector<int> > FrameCDExt;
		
		
		
	public:
		
		SpriteSet(int index, string name) 
		{
			Index = index;
			Name = name;
		}
		SpriteSet()
		{
			
		}
		
		// images[PartTileID[Parts[FrameAnimate[anim][frame]][subpart]]];
		int getPartImageIndex(int anim, int frame, int subpart) {
			return PartTileID[Parts[FrameAnimate[anim][frame]][subpart]];
		}
		
		char getPartTrans(int anim, int frame, int subpart) {
			return PartTileTrans[Parts[FrameAnimate[anim][frame]][subpart]];
		}
		
		int getPartX(int anim, int frame, int subpart) {
			return PartX[Parts[FrameAnimate[anim][frame]][subpart]];
		}
		
		int getPartY(int anim, int frame, int subpart) {
			return PartY[Parts[FrameAnimate[anim][frame]][subpart]];
		}
		
	};

	//-------------------------------------------------------------------------------------
	
	typedef struct WorldObjectMap
	{
		int Index;
		string UnitName;
		string MapID;
		string ImagesID;
		int X;
		int Y;
		string Data;
		
	} WorldObjectMap;
	
	typedef struct WorldObjectSprite
	{
		int Index;
		string UnitName;
		string SprID;
		string ImagesID;
		int Anim;
		int Frame;
		int X;
		int Y;
		string Data;
		
	} WorldObjectSprite;
	
	typedef struct WorldObjectWaypoint
	{
		int Index;
		int X;
		int Y;
		string Data;
		
		vector<int> Nexts;
		
	} WorldObjectWaypoint;
	
	typedef struct WorldObjectRegion
	{		
		int Index;
		int X;
		int Y;
		int W;
		int H;
		string Data;
		
	} WorldObjectRegion;
	
	
	class WorldSet : SetObject
	{
	public:
		
		int GridXCount;
		int GridYCount;
		int GridW;
		int GridH;
		int Width;
		int Height;
		
		map<int, WorldObjectSprite>		Sprs;
		map<int, WorldObjectMap> 		Maps;
		map<int, WorldObjectWaypoint>	WayPoints;
		map<int, WorldObjectRegion>		Regions;
		
		string						Data;
		vector<vector<int> >		Terrian;
		
		
		WorldSet(int index, string name) 
		{
			Index = index;
			Name = name;
		}
		
		WorldSet() 
		{
		}
		
		int getTerrainCell(int grid_x, int grid_y)
		{
			return Terrian[grid_x][grid_y];
		}
		
	};
	
	
	
	
	//-------------------------------------------------------------------------------------
	// OutputLoader
	//-------------------------------------------------------------------------------------
	
	/**
	 * 如何将编辑器资源解析成单位
	 * @author WAZA
	 */
	class OutputLoader
	{
		friend class CellResource;
		
	public:
		virtual ~OutputLoader(){}
		/***
		 * 是否单独输出每张图
		 * @return
		 */
		virtual bool isTile() = 0;
		
		/**
		 * 是否输出整图
		 * @return
		 */
		virtual bool isGroup() = 0;
		
		/**
		 * 获得导出图片文件类型
		 * @return
		 */
		virtual string getImageExtentions() = 0;
		
		/**解析所有单位纯数据*/
		virtual void  getSetObjects(map<string, ImagesSet>	&images,
									map<string, SpriteSet>	&sprites,
									map<string, MapSet>		&maps,
									map<string, WorldSet>	&worlds) = 0;
		
	protected:
		
		virtual CTiles*	createImagesFromSet(ImagesSet const &img) = 0;
		
		CSpriteMeta*	createSpriteFromSet(SpriteSet const &tsprite, CTiles *tiles);
		
	public:
		
		/**
		 * input "{1234},{5678}"
		 * return [1234][5678]
		 */
		static vector<string> getArray2D(string const &src)
		{
			string text = stringReplace(src, "{", "");
			vector<string> texts = stringSplit(text, "},");
			for (int i=texts.size()-1; i>=0; --i) {
				texts[i] = stringTrim(texts[i]);
			}
			return texts;
		}
		
//		/**
//		 * input 3,123,4,5678
//		 * return [123] [5678]
//		 * @param text
//		 * @return
//		 */
//		static vector<string> getArray1D(string text)
//		{
//			StringReader reader = new StringReader(text);
//			ArrayList<String> list = new ArrayList<String>();
//			try{
//				while(true){
//					String line = TextDeserialize.getString(reader);
//					list.add(line);
//				}
//			}catch (Exception e) {}
//			return list.toArray(new String[list.size()]);
//		}

	};

	
	//-------------------------------------------------------------------------------------
	// Cell Resource
	//-------------------------------------------------------------------------------------
	
	/**
	 * 编辑起的资源文件
	 * @author WAZA
	 */
	class CellResource
	{
	private:
		OutputLoader *output_adapter;
		
		map<string, ImagesSet>			ImgTable;
		map<string, SpriteSet>			SprTable;
		map<string, MapSet>				MapTable;
		map<string, WorldSet>			WorldTable;
//		map<string, TableSet>			TableGroups;
		
		map<string, CTiles*>			res_map_tiles;
		map<string, CSpriteMeta*>		res_map_sprites;
		
	public:
		
		CellResource(OutputLoader *adapter);		
		
		CellResource(const char *filename);	
		
		~CellResource();
		
		//	-------------------------------------------------------------------------------------------------------------------------------
		//	Set Object in <setfile>.properties
		//	-------------------------------------------------------------------------------------------------------------------------------
		
		WorldSet	getSetWorld		(string const &name);		
		SpriteSet	getSetSprite	(string const &name);		
		MapSet		getSetMap		(string const &name);
		ImagesSet	getSetImages	(string const &name);		
		
		//	--------------------------------------------------------------------------------------------------------------------------------------------------
		//	utils
		//	--------------------------------------------------------------------------------------------------------------------------------------------------
		
		CTiles*			getImages		(string const &name);
		
		CSpriteMeta*	getSpriteMeta	(string const &name);
		
		CSprite*		createSprite	(string const &name);
		
	protected:
		
		void init(OutputLoader *adapter);
	};

	
	
	
}; // namespace gametiler


#endif // #define _COM_CELL_GAME_CELL_RESOURCE