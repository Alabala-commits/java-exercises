package HospitalForAnimal;
/*
 * 	Класс клиент 
 */
public class Client {
	
	private String nameClient;
	private InterfacePet petClient;
	
	/*
	 *	Конструктор
	 */
	public Client(String nameClient, InterfacePet pet) {
		this.nameClient = nameClient;
		this.petClient = pet;
	}
	
	/*
	 *	Конструктор
	 */
	public Client(String nameClient, String namePet) {
		this.nameClient = nameClient;
		this.petClient = new Cat(namePet);
	}
	
	/*
	 * 	Метод возвращает имя клиента
	 */
	public String getNameClient() {
		return this.nameClient;
	}
	
	/*
	 * 	Метод возвращает объект питомца клиента
	 */
	public InterfacePet getObjPetClient() {
		return this.petClient;
	}
	
	/*
	 * 	Метод возвращает имя питомца клиента
	 */
	public String getNamePetClient() {
		String str = this.petClient.getName();
		return str;
	}
	
	/*
	 * 	Меняем имя клиента
	 */
	public void setNameClient(String name) {
		this.nameClient = name;
	}
	
	/*
	 * 	Меняем объект питомца
	 */
	public void setObjPet(InterfacePet pet) {
		this.petClient = pet;
	}
	
	/*
	 * 	Меняем имя питомца
	 */											//	То есть берём objCatTomas и вызываем у него метод InterfacePet	
	public void setNamePet( String namePet) {	//	потому что Cat наследует всё от Animal
		this.petClient.setNamePet(namePet);;	//	а в Animal есть всё, что есть в InterfacePet
	}
			
}
