package HospitalForAnimal;
/*
 *	������� ����� ��� ��������
 */
public class Animal implements InterfacePet{
	
//	private final InterfacePet variablePet;
	
	/*
	 *	��� ���������
	 */
	private String name;
	
	/*
	 *	�����������
	 */
	public Animal() {}
	
	/*
	 *	����������� (��������� ��� ���������)
	 */
	public Animal(final String paramName) {
		this.name = paramName;
	}
	
	/*
	 *	������� ���-�� (������������ ���������� ����������)
	 */
	@Override
	public void say(String arg) {
//		this.variablePet.say(arg);
		System.out.println(this.name + "say: " + arg);
	}
	
	/*
	 *	������������ ���������� ������ �� ����������
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/*
	 * 	����� ��� ��������� �����
	 */
	@Override
	public void setNamePet(String newName) {
		this.name = newName;
	}
	
	/*
	 *	�������� ������� ��� ��� (����� ���������, ������ ���
	 *	����� ��� ������ �� ����� ��� ������� �������� ��� ��� ���)
	 *	���� ����� �������� ���������� �� ������, �� ��� �����
	 *	������������ ������ ������ ������
	 */
	private boolean isHungry() {
		// �������� �������� ���������� ���������
		return true;
	}
	
}
