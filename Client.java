package HospitalForAnimal;
/*
 * 	����� ������ 
 */
public class Client {
	
	private String nameClient;
	private InterfacePet petClient;
	
	/*
	 *	�����������
	 */
	public Client(String nameClient, InterfacePet pet) {
		this.nameClient = nameClient;
		this.petClient = pet;
	}
	
	/*
	 *	�����������
	 */
	public Client(String nameClient, String namePet) {
		this.nameClient = nameClient;
		this.petClient = new Cat(namePet);
	}
	
	/*
	 * 	����� ���������� ��� �������
	 */
	public String getNameClient() {
		return this.nameClient;
	}
	
	/*
	 * 	����� ���������� ������ ������� �������
	 */
	public InterfacePet getObjPetClient() {
		return this.petClient;
	}
	
	/*
	 * 	����� ���������� ��� ������� �������
	 */
	public String getNamePetClient() {
		String str = this.petClient.getName();
		return str;
	}
	
	/*
	 * 	������ ��� �������
	 */
	public void setNameClient(String name) {
		this.nameClient = name;
	}
	
	/*
	 * 	������ ������ �������
	 */
	public void setObjPet(InterfacePet pet) {
		this.petClient = pet;
	}
	
	/*
	 * 	������ ��� �������
	 */											//	�� ���� ���� objCatTomas � �������� � ���� ����� InterfacePet	
	public void setNamePet( String namePet) {	//	������ ��� Cat ��������� �� �� Animal
		this.petClient.setNamePet(namePet);;	//	� � Animal ���� ��, ��� ���� � InterfacePet
	}
			
}
