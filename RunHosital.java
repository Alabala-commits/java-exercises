package HospitalForAnimal;

import java.util.Scanner;

public class RunHosital {
	
	static Scanner reader = new Scanner(System.in);
	private static Hospital objHospital;

	public static void main(String[] args) {
		
		int index = start();
		if(index != 0) {
			createObjHospital();
			while(index != 0) {
				index = menuAction();
				if(index == 1) {
					findClientByNamePet();
				}
				if(index == 2) {
					findPetByNameClient();
				}
				if(index == 3) {
					replaceClientByNamePet();
				}
				if(index == 4) {
					replacePetByNameClient();
				}
				if(index == 5) {
					deleteClient();
				}
				if(index == 6) {
					deletePet();
				}
			}
		}
		reader.close();
	}
	
	/*
	 * 	Старт
	 */
	public static int start() {
		System.out.println("Ветеринарная клиника");
		System.out.println("Для начала работы необходимо добавить хотябы одного клиента");
		System.out.println("Введите " + "\t" + "1" + "\t" + " для добавления клиента/ов");
		System.out.println("Введите " + "\t" + "0" + "\t" + " для завершения работы");
		System.out.print("Ваш ввод -> ");
		int menuItemStart = 1;	//	Количество пунктов иеню не считая выхода
		return enterIntForMenu(menuItemStart);
	}
	
	/*
	 * 	Чтение для выбора пункта меню
	 * 	ввод пользователя и проверка на положительный int
	 */
	public static int enterIntForMenu(int menuItem) {
		int index;
		do {
			while(!reader.hasNextInt()) {
				System.out.print("Error simbol ! It's not number, try again -> ");
				reader.next();
			}
			index = reader.nextInt();
			if(index < 0) {
				System.out.print("Число не должно быть отрицательным, try again -> ");
			}
			if(index > menuItem) {
				System.out.print("Нет такого пункта меню, try again -> ");
			}
		} while(index < 0 || index > menuItem);
		reader.nextLine();
		return index;
	}
	
	/*
	 * 	Чтение ввода пользователя и проверка на положительный int
	 */
	public static int enterInt() {
		int param;
		do {
			System.out.print("Число должно быть больше ноля -> ");
			while(!reader.hasNextInt()) {
				System.out.print("Error simbol ! It's not number, try again -> ");
				reader.next();
			}
			param = reader.nextInt();
		} while(param <= 0);
		reader.nextLine();
		return param;
	}
	
	/*
	 * 	Чтение ввода пользователя и проверка на String
	 */
	public static String enterStr() {
		String str;
		if(reader.hasNextLine()) {
			str= reader.nextLine();
		}
		else {
			System.out.print("Error simbol ! Try again -> ");
			reader.next();
			str = enterStr();		//	Рекурсия
		}
		return str;
	}
	
	/*
	 * 	Чтение ввода пользователя и проверка наличия
	 */
	public static String enterVolidName() {
		String name = reader.nextLine();
		if(objHospital.volid(name) == false) {
			name = enterVolidName();
		}
		return name;	
	}

	/*
	 * 	Сразу после старта, если продолжаем
	 * 	Создаём объекты класса Hospital
	 */
	public static void createObjHospital() {
		System.out.println("Введите количество клиентов которое будет добавлено");
		objHospital = new Hospital(enterInt());
		for(int i=0; i < objHospital.getArrClients().length; ++i) {
			createObjClient();
		}
	}
	
	/*
	 * 	Меню действий
	 */
	public static int menuAction() {
		System.out.println("Выберите действие:");
		System.out.println("Введите " + "\t" + "1" + "\t" + " для поиска клиента по имени питомца");
		System.out.println("Введите " + "\t" + "2" + "\t" + " для поиска питомца по имени клиента");
		System.out.println("Введите " + "\t" + "3" + "\t" + " для изменения имени хозяина питомца");
		System.out.println("Введите " + "\t" + "4" + "\t" + " для изменения имени питомца");
		System.out.println("Введите " + "\t" + "5" + "\t" + " для удаления клиента");
		System.out.println("Введите " + "\t" + "6" + "\t" + " для удаления питомца");
		System.out.println("Введите " + "\t" + "0" + "\t" + " для выхода");
		System.out.print("Ваш ввод -> ");
		int menuItemAction = 6;	//	Количество пунктов иеню не считая выхода
		return enterIntForMenu(menuItemAction);
	}
	

	/*
	 * 	Создаём пару клиент - питомец
	 */
	public static void createObjClient() {
		System.out.print("Введите имя питомца(кота) -> ");
		String namePet = reader.nextLine();							//	Сделать возможность выбора питомца (кот, собака...)
		Cat objCat = new Cat(namePet);								//	Создаём объект класса Cat
			
		System.out.print("Введите имя хозяина питомца " + namePet + " -> ");
		String nameClient = reader.nextLine();
		Client objClient = new Client(nameClient, objCat);			//	Создаём объект класса Client
		objHospital.addClient(objClient);							//	Добавляем клиента в госпиталь (вместо "пустого")
		System.out.println("Клиент " + nameClient + " с питомцем " + namePet + " добавлен");
		System.out.println("");
	}
	
	/*
	 * 	Ищем клиента по имени питомца
	 */
	public static void findClientByNamePet() {
		System.out.println("Ищем клиента по имени питомца");
		System.out.print("Введите имя питомца(кота) -> ");
		String namePet = enterVolidName();
		String nameFoundClient = objHospital.findClient(namePet).getNameClient();
		System.out.println("Нашёлся " + nameFoundClient + " хозяин питомца " + namePet);
		System.out.println("");
	}
	
	/*
	 * 	Ищем питомца по имени клиента
	 */
	public static void findPetByNameClient() {
		System.out.println("Ищем питомца(кота) по имени клиента");
		System.out.print("Введите имя клиента -> ");
		String nameClient = enterVolidName();
		String nameFoundPet = objHospital.findClient(nameClient).getNamePetClient();
		System.out.println("У клиента " + nameClient + " есть питомец(кот) " + nameFoundPet);
		System.out.println("");
	}
	
	/*
	 * 	Меняем имя хозяина у питомца
	 */
	public static void replaceClientByNamePet() {
		System.out.println("Меняем имя хозяина у питомца(кота)");
		System.out.print("Введите имя питомца(кота) -> ");
		String namePet = enterVolidName();
		System.out.print("Введите имя нового хозяина -> ");
		String nameClient = reader.nextLine();
		objHospital.findClient(namePet).setNameClient(nameClient);
		System.out.println("Теперь питомец(кот) " + namePet + " у хозяина по имени " + nameClient);
		System.out.println("");
	}
	
	/*
	 * 	Меняем имя питомца, нам нужно имя хозяина
	 */
	public static void replacePetByNameClient() {
		System.out.println("Меняем имя питомеца(кота)");
		System.out.print("Введите имя хозяина питомца(кота) -> ");
		String nameClient = enterVolidName();
		System.out.print("Введите новое имя питомца(кота) -> ");
		String newNamePet = reader.nextLine();
		objHospital.findClient(nameClient).setNamePet(newNamePet);
		System.out.println("Теперь у клиента " + nameClient + " питомец(кот) по имени " + newNamePet);
		System.out.println("");
	}
	
	/*
	 * 	Удаляем клиента
	 */
	public static void deleteClient() {
		System.out.println("Удаляем клиента");
		System.out.println("Внимание ! При удалении имени клиента останется его питомец, если он был");
		System.out.print("Введите имя клиента которого нужно удалить-> ");
		String nameClient = enterVolidName();
		objHospital.deleteClient(nameClient);
	}
	
	/*
	 * 	Удаляем питомца
	 */
	public static void deletePet() {
		System.out.println("Удаляем питомца");
		System.out.println("Внимание ! При удалении имени питомца останется его хозяин, если он был");
		System.out.print("Введите имя питомца которого нужно удалить-> ");
		String namePet = enterVolidName();
		objHospital.deletePet(namePet);
	}
	
}
