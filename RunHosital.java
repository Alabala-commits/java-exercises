package HospitalForAnimal;

import java.util.Scanner;

public class RunHosital {
	
	static Scanner reader = new Scanner(System.in);
	private static Hospital objHospital;

	public static void main(String[] args) {
		
		int index = start();
		if(index != 0) {
			createObjHospital();
			while(index != 0) {
				index = menuAction();
				if(index == 1) {
					findClientByNamePet();
				}
				if(index == 2) {
					findPetByNameClient();
				}
				if(index == 3) {
					replaceClientByNamePet();
				}
				if(index == 4) {
					replacePetByNameClient();
				}
				if(index == 5) {
					deleteClient();
				}
				if(index == 6) {
					deletePet();
				}
			}
		}
		reader.close();
	}
	
	/*
	 * 	�����
	 */
	public static int start() {
		System.out.println("������������ �������");
		System.out.println("��� ������ ������ ���������� �������� ������ ������ �������");
		System.out.println("������� " + "\t" + "1" + "\t" + " ��� ���������� �������/��");
		System.out.println("������� " + "\t" + "0" + "\t" + " ��� ���������� ������");
		System.out.print("��� ���� -> ");
		int menuItemStart = 1;	//	���������� ������� ���� �� ������ ������
		return enterIntForMenu(menuItemStart);
	}
	
	/*
	 * 	������ ��� ������ ������ ����
	 * 	���� ������������ � �������� �� ������������� int
	 */
	public static int enterIntForMenu(int menuItem) {
		int index;
		do {
			while(!reader.hasNextInt()) {
				System.out.print("Error simbol ! It's not number, try again -> ");
				reader.next();
			}
			index = reader.nextInt();
			if(index < 0) {
				System.out.print("����� �� ������ ���� �������������, try again -> ");
			}
			if(index > menuItem) {
				System.out.print("��� ������ ������ ����, try again -> ");
			}
		} while(index < 0 || index > menuItem);
		reader.nextLine();
		return index;
	}
	
	/*
	 * 	������ ����� ������������ � �������� �� ������������� int
	 */
	public static int enterInt() {
		int param;
		do {
			System.out.print("����� ������ ���� ������ ���� -> ");
			while(!reader.hasNextInt()) {
				System.out.print("Error simbol ! It's not number, try again -> ");
				reader.next();
			}
			param = reader.nextInt();
		} while(param <= 0);
		reader.nextLine();
		return param;
	}
	
	/*
	 * 	������ ����� ������������ � �������� �� String
	 */
	public static String enterStr() {
		String str;
		if(reader.hasNextLine()) {
			str= reader.nextLine();
		}
		else {
			System.out.print("Error simbol ! Try again -> ");
			reader.next();
			str = enterStr();		//	��������
		}
		return str;
	}
	
	/*
	 * 	������ ����� ������������ � �������� �������
	 */
	public static String enterVolidName() {
		String name = reader.nextLine();
		if(objHospital.volid(name) == false) {
			name = enterVolidName();
		}
		return name;	
	}

	/*
	 * 	����� ����� ������, ���� ����������
	 * 	������ ������� ������ Hospital
	 */
	public static void createObjHospital() {
		System.out.println("������� ���������� �������� ������� ����� ���������");
		objHospital = new Hospital(enterInt());
		for(int i=0; i < objHospital.getArrClients().length; ++i) {
			createObjClient();
		}
	}
	
	/*
	 * 	���� ��������
	 */
	public static int menuAction() {
		System.out.println("�������� ��������:");
		System.out.println("������� " + "\t" + "1" + "\t" + " ��� ������ ������� �� ����� �������");
		System.out.println("������� " + "\t" + "2" + "\t" + " ��� ������ ������� �� ����� �������");
		System.out.println("������� " + "\t" + "3" + "\t" + " ��� ��������� ����� ������� �������");
		System.out.println("������� " + "\t" + "4" + "\t" + " ��� ��������� ����� �������");
		System.out.println("������� " + "\t" + "5" + "\t" + " ��� �������� �������");
		System.out.println("������� " + "\t" + "6" + "\t" + " ��� �������� �������");
		System.out.println("������� " + "\t" + "0" + "\t" + " ��� ������");
		System.out.print("��� ���� -> ");
		int menuItemAction = 6;	//	���������� ������� ���� �� ������ ������
		return enterIntForMenu(menuItemAction);
	}
	

	/*
	 * 	������ ���� ������ - �������
	 */
	public static void createObjClient() {
		System.out.print("������� ��� �������(����) -> ");
		String namePet = reader.nextLine();							//	������� ����������� ������ ������� (���, ������...)
		Cat objCat = new Cat(namePet);								//	������ ������ ������ Cat
			
		System.out.print("������� ��� ������� ������� " + namePet + " -> ");
		String nameClient = reader.nextLine();
		Client objClient = new Client(nameClient, objCat);			//	������ ������ ������ Client
		objHospital.addClient(objClient);							//	��������� ������� � ��������� (������ "�������")
		System.out.println("������ " + nameClient + " � �������� " + namePet + " ��������");
		System.out.println("");
	}
	
	/*
	 * 	���� ������� �� ����� �������
	 */
	public static void findClientByNamePet() {
		System.out.println("���� ������� �� ����� �������");
		System.out.print("������� ��� �������(����) -> ");
		String namePet = enterVolidName();
		String nameFoundClient = objHospital.findClient(namePet).getNameClient();
		System.out.println("������� " + nameFoundClient + " ������ ������� " + namePet);
		System.out.println("");
	}
	
	/*
	 * 	���� ������� �� ����� �������
	 */
	public static void findPetByNameClient() {
		System.out.println("���� �������(����) �� ����� �������");
		System.out.print("������� ��� ������� -> ");
		String nameClient = enterVolidName();
		String nameFoundPet = objHospital.findClient(nameClient).getNamePetClient();
		System.out.println("� ������� " + nameClient + " ���� �������(���) " + nameFoundPet);
		System.out.println("");
	}
	
	/*
	 * 	������ ��� ������� � �������
	 */
	public static void replaceClientByNamePet() {
		System.out.println("������ ��� ������� � �������(����)");
		System.out.print("������� ��� �������(����) -> ");
		String namePet = enterVolidName();
		System.out.print("������� ��� ������ ������� -> ");
		String nameClient = reader.nextLine();
		objHospital.findClient(namePet).setNameClient(nameClient);
		System.out.println("������ �������(���) " + namePet + " � ������� �� ����� " + nameClient);
		System.out.println("");
	}
	
	/*
	 * 	������ ��� �������, ��� ����� ��� �������
	 */
	public static void replacePetByNameClient() {
		System.out.println("������ ��� ��������(����)");
		System.out.print("������� ��� ������� �������(����) -> ");
		String nameClient = enterVolidName();
		System.out.print("������� ����� ��� �������(����) -> ");
		String newNamePet = reader.nextLine();
		objHospital.findClient(nameClient).setNamePet(newNamePet);
		System.out.println("������ � ������� " + nameClient + " �������(���) �� ����� " + newNamePet);
		System.out.println("");
	}
	
	/*
	 * 	������� �������
	 */
	public static void deleteClient() {
		System.out.println("������� �������");
		System.out.println("�������� ! ��� �������� ����� ������� ��������� ��� �������, ���� �� ���");
		System.out.print("������� ��� ������� �������� ����� �������-> ");
		String nameClient = enterVolidName();
		objHospital.deleteClient(nameClient);
	}
	
	/*
	 * 	������� �������
	 */
	public static void deletePet() {
		System.out.println("������� �������");
		System.out.println("�������� ! ��� �������� ����� ������� ��������� ��� ������, ���� �� ���");
		System.out.print("������� ��� ������� �������� ����� �������-> ");
		String namePet = enterVolidName();
		objHospital.deletePet(namePet);
	}
	
}
