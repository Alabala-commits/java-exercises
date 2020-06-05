package HospitalForAnimal;

public class Dog implements InterfacePet {
	
	private final InterfacePet variablePet;	//	Базовая реализация питомца(интерфейса)
	private String name;	//	Имя животного
	
	public Dog (final InterfacePet param) {
		this.variablePet = param;
	}

	/*
	 *	Обязательная реализация метода из интерфейса
	 */
	@Override
	public void say(String arg) {
		this.variablePet.say(arg);
		System.out.println("!!! Gav, Gav ");
	}
	
	/*
	 *	Обязательная реализация метода из интерфейса
	 */
	@Override
	public String getName() {
		return this.variablePet.getName();
	}
	
	/*
	 * 	Метод для изменения имени
	 * 	Обязательная реализация метода из интерфейса
	 */
	@Override
	public void setNamePet(String newName) {
		this.name = newName;
	}
}
