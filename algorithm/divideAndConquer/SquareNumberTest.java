package divideAndConquer;

public class SquareNumberTest {
	
	public static void main(String[] args) {
		
		int n = exp(2, 10);
		System.out.println(n);
	}
	
	private static int exp(int base, int exponent) {
		
		if(exponent == 0) return 1;
		else if(exponent == 1) return base;
		
		int newExponent = exponent/2;
		int num =  exp(base, newExponent);
		num *= num;
		if(exponent%2 != 0) {
			num *= base;
		}
		
		return num;
	}
	
	
}
