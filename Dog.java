package HospitalForAnimal;

public class Dog implements InterfacePet {
	
	private final InterfacePet variablePet;	//	������� ���������� �������(����������)
	private String name;	//	��� ���������
	
	public Dog (final InterfacePet param) {
		this.variablePet = param;
	}

	/*
	 *	������������ ���������� ������ �� ����������
	 */
	@Override
	public void say(String arg) {
		this.variablePet.say(arg);
		System.out.println("!!! Gav, Gav ");
	}
	
	/*
	 *	������������ ���������� ������ �� ����������
	 */
	@Override
	public String getName() {
		return this.variablePet.getName();
	}
	
	/*
	 * 	����� ��� ��������� �����
	 * 	������������ ���������� ������ �� ����������
	 */
	@Override
	public void setNamePet(String newName) {
		this.name = newName;
	}
}
