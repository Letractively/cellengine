
#include "GameUtil.h"



bool CdRect(
			int sx1, int sy1, int sx2, int sy2, 
			int dx1, int dy1, int dx2, int dy2) {
				if (sx2 < dx1)		return false;
				if (sx1 > dx2)		return false;
				if (sy2 < dy1)		return false;
				if (sy1 > dy2)		return false;
				return true;
}

bool CdRectPoint(
				 int sx1, int sy1, int sx2, int sy2, 
				 int dx, int dy) {
					 if (sx2 < dx)		return false;
					 if (sx1 > dx)		return false;
					 if (sy2 < dy)		return false;
					 if (sy1 > dy)		return false;
					 return true;
}

bool CdRect2(
			 int sx, int sy, int sw, int sh, 
			 int dx, int dy, int dw, int dh) {
				 if (sx + sw - 1 < dx)		return false;
				 if (sx > dx + dw - 1)		return false;
				 if (sy + sh - 1 < dy)		return false;
				 if (sy > dy + dh - 1)		return false;
				 return true;
}

bool CdRectPoint2(
				  int sx, int sy, int sw, int sh, 
				  int dx, int dy) {
					  if (sx + sw - 1 < dx)	return false;
					  if (sx > dx)			return false;
					  if (sy + sh - 1 < dy)	return false;
					  if (sy > dy)			return false;
					  return true;
}
