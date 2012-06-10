#ifndef _MF_ENGINE
#define _MF_ENGINE


//////////////////////////////////////////////////////////////////////////
// CORE
//////////////////////////////////////////////////////////////////////////

#include "MFMath.h"				// ʵ����ѧ����
#include "MFType.h"				// �������Ͷ���
#include "MFUtil.h"				// ʹ���ַ��������顢�ַ�ת������
#include "MFXMLParser.h"		// ����XML������

#include "MFGraphics2D.h"		// 2Dͼ����ʾ�࣬��װ�˻��Ƽ���ͼ�κͲ��ʵķ�����
								// Ҳ���Դ���RenderToTexture

#include "MFNode.h"

//////////////////////////////////////////////////////////////////////////
// GAME
//////////////////////////////////////////////////////////////////////////
#include "MFGameObject.h"		// ���������Ϸ��λ����ײ��
#include "MFCellResourceXML.h"	// ���ڽ���xml��ʽ�ı༭����Դ
#include "MFCellResource.h"		// �༭����Դ����
#include "MFCellSprite.h"		// �༭���ľ�����ʾ
#include "MFCellMap.h"			// �༭���ĵ�ͼ��ʾ	
#include "MFCellWorld.h"		// �༭���ĳ�����ʾ

//////////////////////////////////////////////////////////////////////////
// UI
//////////////////////////////////////////////////////////////////////////

#include "MFUIBase.h"			// ����UI֧��
#include "MFUIText.h"			// �ı�UI֧��
//#include "MFUIEdit.h"			// UI�༭��֧��

//////////////////////////////////////////////////////////////////////////

namespace mf
{
// 	class Engine
// 	{
// 	public:
// 
// 		inline static void init() 
// 		{
// 			Graphics2D::setScreenGraphics(new Graphics2D());
// 		}
// 
// 		inline static void destory() 
// 		{
// 			delete Graphics2D::getScreenGraphics();
// 		}
// 	};
};


#endif // _MF_ENGINE