
/*
Work of each team member
Park Jaesung() : calculate the value of point.
Choi Jaemin(2019314992) : Modified class structure to properly use this in Game class
Seo Kangmin(2019310155) : Designed Class structure(Utilizing PointManager), assigned Coordinate Value to array
*/
import java.awt.Point;

class PointManager {
	Point[][] buildingPoint;
	Point[][] playerPoint;
	Point[] flagPoint;
	int[] coordVal = { 666, 531, 535, 511, 445, 459, 368, 408, 283, 343, 324, 264, 403, 212, 483, 161, 604, 108, 732,
			135, 816, 186, 895, 235, 980, 299, 943, 378, 860, 430, 744, 482, 624, 548, 516, 499, 428, 447, 351, 397,
			251, 326, 343, 252, 420, 202, 502, 151, 634, 87, 749, 146, 833, 198, 913, 247, 1007, 318, 927, 390, 843,
			442, 758, 493, 625, 505, 498, 488, 412, 436, 334, 387, 307, 318, 361, 244, 437, 193, 519, 144, 633, 126,
			766, 160, 850, 210, 930, 261, 952, 318, 912, 400, 825, 453, 741, 505, 590, 528, 479, 476, 395, 425, 316,
			373, 283, 301, 377, 235, 454, 181, 536, 134, 662, 105, 783, 173, 867, 219, 947, 273, 980, 335, 895, 413,
			808, 462, 724, 516 };
	int[] coordVal2 = { 0, 0, 0, 0, 595, 436, 561, 413, 516, 387, 482, 366, 433, 335, 397, 316, 0, 0, 0, 0, 408, 286,
			437, 267, 488, 238, 515, 221, 566, 190, 590, 174, 0, 0, 0, 0, 654, 169, 686, 189, 737, 221, 769, 236, 816,
			269, 847, 286, 0, 0, 0, 0, 845, 312, 818, 331, 774, 357, 740, 376, 694, 406, 660, 430 };
	int[] coorVal3 = { 0, 0, 427, 545, 361, 493, 260, 442, 0, 0, 227, 181, 363, 125, 448, 71, 0, 0, 778, 64, 859, 114,
			950, 184, 0, 0, 980, 451, 899, 502, 809, 554 };

	PointManager() {
		playerPoint = new Point[4][16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
				playerPoint[i][j] = new Point(coordVal[i * 32 + j * 2], coordVal[i * 32 + j * 2 + 1]);
			}
		}
		buildingPoint = new Point[16][2];
		for (int i = 0; i < 16; i++) {
			buildingPoint[i][0] = new Point(coordVal2[i * 4], coordVal2[i * 4 + 1]);
			buildingPoint[i][1] = new Point(coordVal2[i * 4 + 2], coordVal2[i * 4 + 3]);
		}
		flagPoint = new Point[16];
		for (int i = 0; i < 16; i++) {
			flagPoint[i] = new Point(coorVal3[i * 2], coorVal3[i * 2 + 1]);
		}
	}

	Point getPlayerPoint(int playerNum, int position) {
		return playerPoint[playerNum][position];
	}

	Point getBuildingPoint(int _position, int buildingSort) {
		return buildingPoint[_position][buildingSort];
	}

	Point getflagPoint(int _position) {
		return flagPoint[_position];
	}
}
