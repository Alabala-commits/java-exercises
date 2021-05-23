import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParserForConsoleCalc {
	
	private HashMap<String, Integer> digits = null;
	private HashMap<String, Integer> resultDigits = null;
	
	private String[] operationSymbols = null;
	
	private String imput = null;
	private String operation = null;
	
	private int first = 0;
	private int ssecond = 0;
	
	private boolean isRomanNumerals = false;
	
	//-----------------------------------------------------------------------
	
	public ParserForConsoleCalc(){
		
		setDigits(initDigits());
		Scanner scan = new Scanner(System.in);
		setImput(scan.nextLine());
		scan.close();
		setOperationSymbols(initOperationSymbols());
		validate(digits);
	}
	
	//-----------------------------------------------------------------------
	
	public String convertResult(final int result) {
		
		setResultDigits(initResultDigits());
		String resultString = null;
		
		if(result <= 10) {
			resultString = keySearch(digits, result);
		}
		
		if(result > 10) {
			if(result == 100) {
				resultString = keySearch(resultDigits, result);
			}else {
				resultString = Integer.toString(result);
				char[] charArray = resultString.toCharArray();
				int value = Character.getNumericValue(charArray[0]);
				resultString = keySearch(resultDigits, value);
				
				value = Character.getNumericValue(charArray[1]);
				if(value != 0) {
					resultString = resultString + keySearch(digits, value);
				}
			}
		}
		return resultString;
	}
	
	public void validate(final HashMap<String, Integer> digits) {
		
		String[] array = imput.split("\\s");
		
		if(array.length != 3) {
		    throw new NumberFormatException("Invalid input format");
		}
		
		if(digits.containsKey(array[0]) && digits.containsKey(array[2])){
			first = digits.get(array[0]);
			ssecond = digits.get(array[2]);
			setRomanNumerals(true);
		}else {
			try {
				first = Integer.parseInt(array[0]);
				ssecond = Integer.parseInt(array[2]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Different character formats");
            }
					
			if( ! digits.containsValue(first) && ! digits.containsValue(ssecond)) {
				throw new IllegalArgumentException("Invalid input characters");
			}
		}
		operation = checkOperation(operationSymbols, array[1]);
	}
	
	private String checkOperation(final String[] operationSymbols, final String str) {
		
		for(String oper : operationSymbols) {
			if(oper.equals(str)){
				return oper;
			}
		}
		throw new IllegalArgumentException("Invalid input operation");
	}
	
	private HashMap<String, Integer> initDigits() {
		
		HashMap<String, Integer> digits = new HashMap<>();
		
		digits.put("I", 1);
		digits.put("II", 2);
		digits.put("III", 3);
		digits.put("IV", 4);
		digits.put("V", 5);
		digits.put("VI", 6);
		digits.put("VII", 7);
		digits.put("VIII", 8);
		digits.put("IX", 9);
		digits.put("X", 10);
		
		return digits;
	}
	
	private HashMap<String, Integer> initResultDigits() {
		
		HashMap<String, Integer> resultDigits = new HashMap<>();
		
		resultDigits.put("X", 1);
		resultDigits.put("XX", 2);
		resultDigits.put("XXX", 3);
		resultDigits.put("XL", 4);
		resultDigits.put("L", 5);
		resultDigits.put("LX", 6);
		resultDigits.put("LXX", 7);
		resultDigits.put("LXXX", 8);
		resultDigits.put("XC", 9);
		resultDigits.put("C", 100);
		
		return resultDigits;
	}
	
	private String[] initOperationSymbols() {
		return new String[] {"+", "-", "*", "/"};
	}
	
	private String keySearch(HashMap<String, Integer> digits, int value) {
		
		String str= null;
		for (Map.Entry<String, Integer> entry : digits.entrySet()) {
			if(entry.getValue().equals(value)) {
				str = entry.getKey();
			}
		}
		return str;
	}
	
	//-----------------------------------------------------------------------
	
	public HashMap<String, Integer> getDigits() {
		return digits;
	}

	public void setDigits(final HashMap<String, Integer> digits) {
		this.digits = digits;
	}
	
	public HashMap<String, Integer> getResultDigits() {
		return resultDigits;
	}

	public void setResultDigits(HashMap<String, Integer> resultDigits) {
		this.resultDigits = resultDigits;
	}
	
	public String[] getOperationSymbols() {
		return operationSymbols;
	}

	public void setOperationSymbols(String[] operationSymbols) {
		this.operationSymbols = operationSymbols;
	}
	
	public String getImput() {
		return imput;
	}

	public void setImput(String imput) {
		this.imput = imput;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSsecond() {
		return ssecond;
	}

	public void setSsecond(int ssecond) {
		this.ssecond = ssecond;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public boolean isRomanNumerals() {
		return isRomanNumerals;
	}

	public void setRomanNumerals(boolean isRomanNumerals) {
		this.isRomanNumerals = isRomanNumerals;
	}

	
}
