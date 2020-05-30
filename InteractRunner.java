import java.util.Scanner;

public class InteractRunner {
	/*
	* Класс для запуска калькулятора NewCalculator.java
	* Поддерживает ввод пользователем целочисленных значений int,
	* выбор арифметической операции "+" "-" "*" "/",
	* возможность использования полученного результата
	*/
	static Scanner reader = new Scanner(System.in);
	static NewCalculator calc = new NewCalculator();
	static String exit = "n";
	
	public static void main(String[] args) {		
		try {
			while(!exit.equals("y")) {
				int firstNumber;
				if(calc.getResult() == 0) {
					System.out.print("Enter 1-st parametr -> ");
					firstNumber = getParams();
				} else 
					firstNumber = processingResult();
 				System.out.print("Enter 2-st parametr -> ");
				int secondNumber = getParams();
				selectOper(firstNumber, secondNumber);
				System.out.println("Result of " + calc.getName() + " = " + calc.getResult());				
				exit = getExit();
			}
		} finally {
			reader.close();
		}
	}

	/*
	* 		Получение параметров
	*/
	public static int getParams() {
		int param = 0;	
		
		if(reader.hasNextInt())
			param = reader.nextInt();
		else {
			System.out.print("Error simbol ! Try again -> ");
			reader.next();
			param = getParams();		//	Рекурсия
		}
		return param;
	}
	
	/*
	* 		Выбор арифметичкой операции
	*/
	public static void selectOper(int fist, int second) {
		System.out.println("Select an arithmetic operation");
		System.out.print("enter \" + \" , \" - \" , \" * \" , \" /\" -> ");
		char operation;
		if(reader.hasNext()) {												//  Эта штука не работает
			operation = reader.next().charAt(0);							//	Не обрабатывает неверный ввод
			if(operation == '+') calc.add(fist, second);
			if(operation == '-') calc.sub(fist, second);
			if(operation == '*') calc.mult(fist, second);
			if(operation == '/') calc.div(fist, second);
		} else {
			System.out.print("Error simbol ! Try again -> ");
			reader.next();
			selectOper(fist, second);
		}
	}
	
	/*
	* 		Обработка результата
	*/
	public static int processingResult() {
		System.out.println("");
		System.out.println("Result of " + calc.getName() + " = " + calc.getResult());
		System.out.println("Use this paranetr ?");
		String processRes = changeUser();
		int proRes;
		
		if(processRes.equals("y")) {
			proRes = calc.getResult();
			System.out.println("1-st parametr = " + proRes);
		} else {
			calc.cleanResult();
			System.out.print("Enter 1-st parametr -> ");
			proRes = getParams();
		}
		return proRes;
	}
	
	/*
	* 		Обработка выбора пользователя
	*/
	public static String changeUser() {
		System.out.print("enter yes or no : y / n -> ");
		String answer = "n";
		char answ = 'n';
		
		if(reader.hasNext()) 									//  Эта штука не работает
			answ = reader.next().charAt(0);						//	Не обрабатывает неверный ввод
		else {
			System.out.print("Error simbol ! Try again -> ");
			reader.next();
			answer = changeUser();								//	Рекурсия
		}
		answer = Character.toString(answ);
		return answer;
	}
	
	/*
	* 		Обработка выхода
	*/
	public static String getExit() {
		System.out.println("");
		System.out.println("EXIT ?");
		String answer = changeUser();
		return answer;
	}
	
}