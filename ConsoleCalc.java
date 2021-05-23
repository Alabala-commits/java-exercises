import java.util.HashMap;

public class ConsoleCalc {

	private int result = 0;
	
	//--------------------------------------------------------

	
	//--------------------------------------------------------
	
	public void addition(int first, int second) {
		
		setResult(first + second);
	}
	
	public void subtraction(int first, int second) {
		
		setResult(first - second);
	}
	
	public void multiplication(int first, int second) {
		
		setResult(first * second);
	}
	
	public void division(int first, int second) {
		
		setResult(first / second);
	}
	
	//--------------------------------------------------------
	
	public int getResult() {
		return result;
	}
	
	public void setResult(final int result) {
		this.result = result;
	}
}
