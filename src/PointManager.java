import java.awt.Point;

class PointManager {
	Point[][] buildingPoint;
	Point[][] playerPoint;
	int[] coordVal = { 666, 531, 535, 511, 445, 459, 368, 408, 283, 343, 324, 264, 403, 212, 483, 161, 604, 108, 732,
			135, 816, 186, 895, 235, 980, 299, 943, 378, 860, 430, 744, 482, 624, 548, 516, 499, 428, 447, 351, 397,
			251, 326, 343, 252, 420, 202, 502, 151, 634, 87, 749, 146, 833, 198, 913, 247, 1007, 318, 927, 390, 843,
			442, 758, 493, 625, 505, 498, 488, 412, 436, 334, 387, 307, 318, 361, 244, 437, 193, 519, 144, 633, 126,
			766, 160, 850, 210, 930, 261, 952, 318, 912, 400, 825, 453, 741, 505, 590, 528, 479, 476, 395, 425, 316,
			373, 283, 301, 377, 235, 454, 181, 536, 134, 662, 105, 783, 173, 867, 219, 947, 273, 980, 335, 895, 413,
			808, 462, 724, 516 };

	PointManager() {
		playerPoint = new Point[4][16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
				playerPoint[i][j] = new Point(coordVal[i * 32 + j * 2], coordVal[i * 32 + j * 2 + 1]);
			}
		}
	}

	Point getPlayerPoint(int playerNum, int position) {
		return playerPoint[playerNum][position];
	}

	Point getBuildingPoint(int buildingNum, int position) {
		return buildingPoint[buildingNum][position];
	}
}