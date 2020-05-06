/**
 * Arrays.copyOf는 새로운 객체에 원소의 값을 복사하기 때문에
 * 원소가 primitive 타입이면 서로 독립
 * 원소가 reference 타입이면(이차원배열) 서로 연결
 */

package __15__lang.arrays;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {1,2,3,4,5};
		int[] test2 = Arrays.copyOf(test1, test1.length);
		test2[0] = 7;
		
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
		
		int[][] test3 = {{1,2},{3,4}};
		int[][] test4 = Arrays.copyOf(test3, test3.length);
		test4[0] = new int[]{7,8};
		for (int[] i :test3) {
			System.out.println(Arrays.toString(i));
		}
		for (int[] i :test4) {
			System.out.println(Arrays.toString(i));
		}
	}

}
