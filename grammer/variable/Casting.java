/**
 * 더 범위가 큰 쪽으로 형변환을 하면 정보 손실이 없지만
 * 범위가 작은 쪽으로 형변환을 할 때 표현범위를 벗어나면 차이가 발생할 수 있다.
 * 
 * 형 변환을 할때 양수는 앞에 0을 채우고
 * 음수는 1을 채워서 부호를 유지한다
 * 
 * 
 * @author Changhee Yoon
 * 
 */

package variable;

public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 77.777777d;
		int i = (int)d; /* 형변환 */
		
		System.out.println("정수로 형변환 : " + i);
		System.out.println("기존의 실수 : " + d);
		System.out.println("------------------------------------------");
		
		/* 타입의 범위보다 작은 수의 형변환 - 손실 없음*/
		byte b = (byte)i;
		System.out.printf("(int -> byte) i = %d -> b = %d %n", i, b); 
		
		
		/* 타입의 범위보다 큰 수의 형변환 - 손실 있음*/
		i = 777777;
		b = (byte)i;
		System.out.printf("(int -> byte) i = %d -> b = %d %n", i, b); 
		System.out.println("------------------------------------------");
		
		
		/* 더 큰 범위로의 형변환 - 손실 없음*/
		b = 10;
		i = (int)b;
		System.out.printf("(byte -> int) b = %d -> i = %d %n", b, i); 

		/* 음수의 형 변환 */
		b = -2;
		i = (int)b;
		System.out.printf("(byte -> int) b = %d -> i = %d %n", b, i);
		System.out.println("------------------------------------------");
		
		/* 음수의 저장 방식  */
		System.out.println("i="+Integer.toBinaryString(i));
		
	}

}
