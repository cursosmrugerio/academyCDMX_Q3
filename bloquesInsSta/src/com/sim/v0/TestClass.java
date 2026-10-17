package com.sim.v0;

public class TestClass {
	
	static class Delimiter {
		char value = '|'; //-    //#

		Delimiter() {
			this('-');
		}

		Delimiter(char ch) {
			this.value = ch;
		}

		static {
			System.out.print('.');
		}

		{
			System.out.print(value);
		}

		public String toString() {
			return String.valueOf(value);
		}

	}
	


	public static void main(String[] args) {
		Delimiter d1 = new Delimiter(); //       .|
		
		//Delimiter d11 = new Delimiter(); //|
		
		Delimiter d2 = new Delimiter('#');//      |                
		System.out.println(d1 + "" + d2); //      -#
	}
	

}