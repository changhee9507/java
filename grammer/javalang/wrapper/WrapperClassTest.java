package javalang.wrapper;

public class WrapperClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 777;
		Integer i = new Integer(num1);
		Integer i2 = num1;
		
		int num2 = i.intValue();
		int num3 = i;
		
		
		int num4 = 123567;
		String s = String.valueOf(num4);
		
		System.out.println(s);
	}

}
