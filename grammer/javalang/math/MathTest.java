package javalang.math;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(-20));		/* 절댓값 리턴*/
		System.out.println(Math.max(10, 20));	/* 큰 수 리턴 */
		System.out.println(Math.min(10, 4));	/* 작은 수 리턴 */
		
		System.out.println(Math.round(13.74));	/* 반올림, int or long 리턴 */
		System.out.println(Math.round(13.21));	/* " */
		System.out.println(Math.ceil(13.23));	/* 올림, double리턴 */
		System.out.println(Math.floor(13.76));	/* 내림, double리턴 */
		
		
		/* random */
		System.out.println("\nGenerate Random Numbers!");
		
		for(int i=0; i<10; i++) {
			double d = Math.random();
			System.out.println( d + " : " + (d*10 + 1) + " : " + (int) (d*10 + 1));
		}
		
		System.out.println();
		
		Random r = new Random();
		for(int i=0; i<10; i++) {
			System.out.println(r.nextInt(10) + 1); /* +1하는 것은 1-10의 범위를 맞추기 위함 */
		}
		
	}

}
