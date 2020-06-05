package HospitalForAnimal;
/*
 *  Этот интерфейс должен описывать поведение питомцев
 */
public interface InterfacePet {
	
	/*
	 *	Сказать что-то
	 */
	void say(String arg);
	
	/*
	 *  Узнать имя питомца
	 */
	String getName();
	
	/*
	 *	Установить имя питомца
	 */
	void setNamePet(String arg);
}