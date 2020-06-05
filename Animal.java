package HospitalForAnimal;
/*
 *	Базовый класс для животных
 */
public class Animal implements InterfacePet{
	
//	private final InterfacePet variablePet;
	
	/*
	 *	Имя животного
	 */
	private String name;
	
	/*
	 *	Конструктор
	 */
	public Animal() {}
	
	/*
	 *	Конструктор (принимает имя животного)
	 */
	public Animal(final String paramName) {
		this.name = paramName;
	}
	
	/*
	 *	Сказать что-то (Обязательная реализация интерфейса)
	 */
	@Override
	public void say(String arg) {
//		this.variablePet.say(arg);
		System.out.println(this.name + "say: " + arg);
	}
	
	/*
	 *	Обязательная реализация метода из интерфейса
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/*
	 * 	Метод для изменения имени
	 */
	@Override
	public void setNamePet(String newName) {
		this.name = newName;
	}
	
	/*
	 *	Голодный питомец или нет (метод приватный, потому что
	 *	кошка или собака не может нам сказать голодная она или нет)
	 *	Если нужно получить информацию из метода, то его можно
	 *	использовать внутри нашего класса
	 */
	private boolean isHungry() {
		// добавить алгоритм вычисоения состояния
		return true;
	}
	
}
