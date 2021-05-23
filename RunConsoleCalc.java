
public class RunConsoleCalc {

	public static void main(String[] args) {
		
		ParserForConsoleCalc parser = new ParserForConsoleCalc();
		ConsoleCalc calc = new ConsoleCalc();
		calcOperation(parser, calc);
		
		if(parser.isRomanNumerals()) {
			System.out.println(parser.convertResult(calc.getResult()));
		}else {
			System.out.println(calc.getResult());
		}
	}
	
	private static void calcOperation(ParserForConsoleCalc parser, ConsoleCalc calc) {
		
		int first = parser.getFirst();
		int second = parser.getSsecond();
		
		if(parser.getOperation() == "+") {
			calc.addition(first, second);
		}
		if(parser.getOperation() == "-") {
			calc.subtraction(first, second);
		}
		if(parser.getOperation() == "*") {
			calc.multiplication(first, second);
		}
		if(parser.getOperation() == "/") {
			calc.division(first, second);
		}
	}

}
