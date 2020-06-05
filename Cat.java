package HospitalForAnimal;
/*
 * 	Класс Кот, наследник класса Animal
 * 	будет умееть мяукать и ловить мышей
 */
public class Cat extends Animal{
	
	/*
	 * 	Конструктор
	 */
	public Cat() {}
	
	/*
	 * 	Конструктор (вызывает конструктор класса Anumal)
	 */
	public Cat(final String paramName) {
		super(paramName);	//	Это вызов конструктора класса Animal (new Cat("Tomas") - Tomas попадёт в Animal.name)
	}
	
	/*
	 * 	Поймать мышь
	 */
	public void cathMause() {
		
	}
	
	/*
	 * 	Наследуемый метод от класса Animal
	 */
	@Override
	public void say(String arg) {
		System.out.println(getName() + "say: " + arg + "!!! Miaaaau");
	}

}
