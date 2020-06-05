package HospitalForAnimal;
/*
 * 	класс ветеринарная клиника (звучит дибильно по этому - госпиталь)
 */
public class Hospital {
	
	/*
	 *	Список клиентов (массив объектов класса Client)
	 */
	private final Client[] clients;
	private String emptyNameClient;
	private String emptyNamePet;
	
	/*
	 * 	Конструктор
	 * 	Заполняем сразу "пустыми"(только имена) клиентами с "пустыми" питомцами
	 */
	public Hospital(final int size) {
		this.clients = new Client[size];
		this.emptyNameClient = new String("Это место пустое, вы можете добавить сюда имя клиента");
		this.emptyNamePet = new String("Это место пустое, вы можете добавить сюда имя питомца");
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
	 * 	Метод добавления клиента в ветеринарную клинику (госпиталь)
	 */
	public void addClient(final Client objClient) {
		this.clients[getIndexClient(emptyNameClient)] = objClient;		
	}
	
	/*
	 * 	Метод возвращает объект клиента
	 * 	У нас есть имя клиента или питомца
	 * 	Если нет клиента с таким именем/именем питомца, то предупреждаем и возвращаеи новый пустой обект
	 * 	Предполагается, что одинаковых имён нет (возвращает первое имеющееся совпадение)
	 */
	public Client findClient(final String name) {
		return this.clients[getIndexClient(name)];
	}
	
	/*
	 * 	Метод находит индекс объекта клиента в массиве clients по имени клиента/питомца
	 * 	Предполагается, что одинаковых имён нет (если есть, то возвращает последнее имеющееся совпадение)
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
	 * 	Метод меняет имя клиента
	 * 	У нас есть имя питомца				
	 */
	public void swapNameClient(final String newNameClient, final String namePet) {
		findClient(namePet).setNameClient(newNameClient);
	}
	
	/*
	 * 	Метод меняет имя питомца
	 * 	У нас есть имя клиента
	 */
	public void swapNamePet(final String nameClient, final String newNamePet) {
		findClient(nameClient).setNamePet(newNamePet);
	}
	
	/*
	 * 	Метод удаляет клиента
	 * 	У нас есть имя клиента
	 */
	public void deleteClient(final String nameClient) {
		int index = getIndexClient(nameClient);
		String namePet = this.clients[index].getNamePetClient();
		this.clients[index] = new Client(this.emptyNameClient, namePet);
//		return this.clients[index];
	}
	
	/*
	 * 	Метод удаляет питомца
	 * 	У нас есть имя питомца
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
			System.out.print("Неверный ввод ! " + name + " не найден. Повторите ввод ->");
			return false;
		}
		return true;
	}
	
}
