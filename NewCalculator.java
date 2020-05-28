public class NewCalculator {

	private int result;
	
	public void add(int ... params) {		// Суммируем каждый переданный аргумент
		for(Integer param : params) {
			this.result += param;
		}
	}

	public int getResult() {
		return this.result;
	} 

	public void cleanResult() {
		this.result = 0;
	}
}