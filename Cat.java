package HospitalForAnimal;
/*
 * 	����� ���, ��������� ������ Animal
 * 	����� ������ ������� � ������ �����
 */
public class Cat extends Animal{
	
	/*
	 * 	�����������
	 */
	public Cat() {}
	
	/*
	 * 	����������� (�������� ����������� ������ Anumal)
	 */
	public Cat(final String paramName) {
		super(paramName);	//	��� ����� ������������ ������ Animal (new Cat("Tomas") - Tomas ������ � Animal.name)
	}
	
	/*
	 * 	������� ����
	 */
	public void cathMause() {
		
	}
	
	/*
	 * 	����������� ����� �� ������ Animal
	 */
	@Override
	public void say(String arg) {
		System.out.println(getName() + "say: " + arg + "!!! Miaaaau");
	}

}
