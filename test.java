public class test {

	public static void main(String[] arg) {
		System.out.println("Test... ");
		int x = Integer.valueOf(arg[0]);
		int y = Integer.valueOf(arg[1]);
		int result = x + y;
		System.out.println("Result of addition = " + result);
		result = x - y;
		System.out.println("Result of subtraction = " + result);
		result = x * y;
		System.out.println("Result of multiplication = " + result);
		result = x / y;
		System.out.println("Result of division = " + result);
		for(int i=0; i < y; ++i) result *= x; 
		System.out.println("Result of raising " + x + " to the power of "+ y + " = " + result) ;
	}

}