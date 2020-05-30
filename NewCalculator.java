public class NewCalculator {
	/*
	*Класс калькулятор, реализация из командной строки
	*/
		private int result = 0;
		private String nameOperation;
		
	/*
	*	Cложение (addition)
	*/
		public void add(int param, int params) {
			this.nameOperation = "addition \"+\"";
			this.result = param + params;
		}

	/*
	*	Вычитание (subtraction)
	*/
		public void sub(int param, int params) {
			this.nameOperation = "subtraction \"-\"";
			this.result = param - params;
			}

	/*
	*	Умножение (multiplication)
	*/
		public void mult(int param, int params) {
			this.nameOperation = "multiplication \" * \"";
			this.result = param * params;
		}

	/*
	*	Деление(division)
	*/
		public void div(int param, int params) {
			this.nameOperation = "division \" / \"";
			this.result = param / params;
		}

		public String getName() {
			return this.nameOperation;
		}

		public int getResult() {
			return this.result;
		} 

		public void cleanResult() {
			this.result = 0;
		}
}