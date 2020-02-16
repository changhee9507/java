/**
 * 실수형
 * 
 * 실수는 값을 저장하는 방식이 지수형식이기 때문에 저장할 수 있는 수의 범위가 대폭 증가한다
 * 하지만 오차가 발생하며 값의 범위보다는 정밀도와 밀접한 관련이 있다.
 * 
 * float - 7자리  (참고 1.234567 = 1234567 * 10^n) 10진수 표현으로 1~7까지 오차없음
 * double - 15자리 
 * 
 * @author Changhee Yoon 
 */
package variable;

public class floatDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float num1 = 7.1234567890_1234567890f;
		float num2 = 8.1234567890_1234567890f;
		double num3 = 7.1234567890_1234567890d;
		
		System.out.printf("Origin value = 7.1234567890_1234567890\n");
		System.out.printf("float num1 = %24f       \n", num1); /* %f는 default로 소수 6자리까지 표현(7자리에서 반올림)*/
		System.out.printf("float num1 = %24.20f  \n", num1);/* 24자리중 20자리 소수까지 표현,(앞에서부터 7자리까지 오차없음)*/
		System.out.printf("float num2 = %24.20f  \n", num2); 
		System.out.printf("double num3 =%24.20f \n", num3);/* 앞에서부터 15자리까지 오차 없음 */
		
		
		System.out.printf("float num1 to int : %X", Float.floatToIntBits(num1)); /* 저장 방식이 사인비트 + 값비트 + 지수비트로 이루어짐 */
	}

}
