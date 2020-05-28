import java.util.Scanner;

public class InteractRunner {	// Класс для запуска калькулятора. Поддерживает ввод пользователя
	
	public static void main(String[] arg) {
		Scanner reader = new Scanner(System.in);
		try {
			NewCalculator calc = new NewCalculator();
			String exit = "no";
			while(!exit.equals("yes")) {
				System.out.println("Enter first argument : ");
				String first = reader.next();
				System.out.println("Enter second argument : ");
				String second = reader.next();
				calc.add(Integer.valueOf(first), Integer.valueOf(second));
				System.out.println("Result of addition \"+\" : " + calc.getResult());
				calc.cleanResult();
				System.out.println("EXIT ?");
				System.out.println("Enter :  yes / no ");
				exit = reader.next();
			}
		} finally {
			reader.close();
		}
	}
}