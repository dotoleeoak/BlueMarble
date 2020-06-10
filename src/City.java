import java.util.ArrayList;

class CityManager {
	// enum cities {
	// 	SOOSUNG, BENZENE, BOKJI, STUDENT, 
	// 	ENGINEER_1, ENGINEER_2, JONGHAP, SANHAK, 
	// 	SEMICONDUCTOR, PHARMACY, MEDICINE, LIBRARY;
	// }
	
	class City {
		int ownerID;
		int price;
		int toll;
	
		City(int price) {
			this.ownerID = -1;  // -1 means nobody 
			this.price = price;
			this.toll = 0;
		}
	}

	ArrayList<City> arrayCity;

	CityManager() {
		arrayCity = new ArrayList<City>();
		arrayCity.add(new City(100));  // ������
		arrayCity.add(new City(120));  // ��������
		arrayCity.add(new City(150));  // ����ȸ��
		arrayCity.add(new City(200));  // �л�ȸ��
		arrayCity.add(new City(250));  // ��1���а�
		arrayCity.add(new City(350));  // ��2���а�
		arrayCity.add(new City(400));  // ���տ�����
		arrayCity.add(new City(500));  // �������¼���
		arrayCity.add(new City(600));  // �ݵ�ü��
		arrayCity.add(new City(800));  // ���а�
		arrayCity.add(new City(1000)); // ���а�
		arrayCity.add(new City(1500)); // ��
	}

	public int owner(int i) {
		return arrayCity.get(i).ownerID;
	}

	public int getPrice(int i) {
		return arrayCity.get(i).price;
	}

	public int getPriceBuilding(int i) {
		return arrayCity.get(i).price / 2;
	}

	public void buyCity(int i, int ID) {
		City city = arrayCity.get(i);
		city.ownerID = ID;
		city.toll += city.price;
	}

	public void buyBuilding(int i, int ID) {
		City city = arrayCity.get(i);
		city.ownerID = ID;
		city.toll += city.price / 2;
	}
}

