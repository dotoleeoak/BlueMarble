import java.util.ArrayList;

// enum cities {
// 	START, SOOSUNG, BENZENE, BOKJI, 
// 	CHANCE_1, STUDENT, ENGINEER_1, ENGINEER_2, 
// 	LAB, JONGHAP, SANHAK, SEMICONDUCTOR, 
// 	CHANCE_2, PHARMACY, MEDICINE, LIBRARY;
// }

class CityManager {

	class City {
		int ownerID;
		int price;
		int toll;
		String name;

		City(int price, String name) {
			this.ownerID = -1; // -1 means nobody
			this.price = price;
			this.toll = 0;
			this.name = name;
		}
	}

	ArrayList<City> arrayCity;

	CityManager() {
		arrayCity = new ArrayList<City>();
		arrayCity.add(new City(0, "����")); // ����
		arrayCity.add(new City(100, "������")); // ������
		arrayCity.add(new City(120, "��������")); // ����������
		arrayCity.add(new City(150, "����ȸ��")); // ����ȸ��
		arrayCity.add(new City(0, "����")); // ����
		arrayCity.add(new City(200, "�л�ȸ��")); // �л�ȸ��
		arrayCity.add(new City(250, "��1���а�")); // ��1���а�
		arrayCity.add(new City(350, "��2���а�")); // ��2���а�
		arrayCity.add(new City(0, "Lab")); // Lab
		arrayCity.add(new City(400, "���տ�����")); // ���տ�����
		arrayCity.add(new City(500, "�������¼���")); // �������¼���
		arrayCity.add(new City(600, "�ݵ�ü��")); // �ݵ�ü��
		arrayCity.add(new City(0, "����")); // ����
		arrayCity.add(new City(800, "���а�")); // ���а�
		arrayCity.add(new City(1000, "���а�")); // ���а�
		arrayCity.add(new City(1500, "��")); // ��
	}

	public int owner(int idx) {
		return arrayCity.get(idx).ownerID;
	}

	public int getPrice(int idx) {
		return arrayCity.get(idx).price;
	}

	public int getPriceBuilding(int idx) {
		return arrayCity.get(idx).price / 2;
	}

	public int getToll(int idx) {
		return arrayCity.get(idx).toll;
	}

	public String getName(int idx) {
		return arrayCity.get(idx).name;
	}

	public void buyCity(int idx, int ID) {
		City city = arrayCity.get(idx);
		city.ownerID = ID;
		city.toll += city.price;
	}

	public void buyBuilding(int idx, int ID) {
		City city = arrayCity.get(idx);
		city.ownerID = ID;
		city.toll += city.price / 2;
	}
}
