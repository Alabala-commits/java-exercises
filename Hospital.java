package HospitalForAnimal;
/*
 * 	����� ������������ ������� (������ �������� �� ����� - ���������)
 */
public class Hospital {
	
	/*
	 *	������ �������� (������ �������� ������ Client)
	 */
	private final Client[] clients;
	private String emptyNameClient;
	private String emptyNamePet;
	
	/*
	 * 	�����������
	 * 	��������� ����� "�������"(������ �����) ��������� � "�������" ���������
	 */
	public Hospital(final int size) {
		this.clients = new Client[size];
		this.emptyNameClient = new String("��� ����� ������, �� ������ �������� ���� ��� �������");
		this.emptyNamePet = new String("��� ����� ������, �� ������ �������� ���� ��� �������");
		for(int i=0; i < clients.length; ++i) {
			this.clients[i] = new Client(this.emptyNameClient, this.emptyNamePet);
		}
	}
	
	public Client[] getArrClients() {
		return this.clients;
	}
	
	public Client getClient(final int index) {
		return this.clients[index];
	}
	
	public String getEmptyNameClient() {
		return this.emptyNameClient;
	}
	
	public String getEmptyNamePet() {
		return this.emptyNamePet;
	}
	
	/*
	 * 	����� ���������� ������� � ������������ ������� (���������)
	 */
	public void addClient(final Client objClient) {
		this.clients[getIndexClient(emptyNameClient)] = objClient;		
	}
	
	/*
	 * 	����� ���������� ������ �������
	 * 	� ��� ���� ��� ������� ��� �������
	 * 	���� ��� ������� � ����� ������/������ �������, �� ������������� � ���������� ����� ������ �����
	 * 	��������������, ��� ���������� ��� ��� (���������� ������ ��������� ����������)
	 */
	public Client findClient(final String name) {
		return this.clients[getIndexClient(name)];
	}
	
	/*
	 * 	����� ������� ������ ������� ������� � ������� clients �� ����� �������/�������
	 * 	��������������, ��� ���������� ��� ��� (���� ����, �� ���������� ��������� ��������� ����������)
	 */
	public int getIndexClient(final String name) {
		int index = -1;
		for(int i=0; i < this.clients.length; ++i) {
			String str1 = this.clients[i].getNameClient();
			String str2 = this.clients[i].getNamePetClient();
			if(str1.equals(name) || str2.equals(name)) {
				index = i;
			}
		}
		return index;
	}

	/*
	 * 	����� ������ ��� �������
	 * 	� ��� ���� ��� �������				
	 */
	public void swapNameClient(final String newNameClient, final String namePet) {
		findClient(namePet).setNameClient(newNameClient);
	}
	
	/*
	 * 	����� ������ ��� �������
	 * 	� ��� ���� ��� �������
	 */
	public void swapNamePet(final String nameClient, final String newNamePet) {
		findClient(nameClient).setNamePet(newNamePet);
	}
	
	/*
	 * 	����� ������� �������
	 * 	� ��� ���� ��� �������
	 */
	public void deleteClient(final String nameClient) {
		int index = getIndexClient(nameClient);
		String namePet = this.clients[index].getNamePetClient();
		this.clients[index] = new Client(this.emptyNameClient, namePet);
//		return this.clients[index];
	}
	
	/*
	 * 	����� ������� �������
	 * 	� ��� ���� ��� �������
	 */
	public void deletePet(final String namePet) {
		int index = getIndexClient(namePet);
		String nameClient = this.clients[index].getNameClient();
		this.clients[index] = new Client(nameClient, this.emptyNamePet);
//		return this.clients[index];
	}
	
	public boolean volid(String name) {
		int index = getIndexClient(name);
		if(index == -1) {
			System.out.print("�������� ���� ! " + name + " �� ������. ��������� ���� ->");
			return false;
		}
		return true;
	}
	
}
