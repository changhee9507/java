/**
 * 비트마스킹으로 만드는 부분 집합 
 */

package Set;

public class SubSet {

	static int[] numbers;
	static int totalCount;
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbers = new int[] {1,2,3,4};
		N = numbers.length;
		subset(N);
		System.out.println(totalCount);
		
	}
	
	private static void subset(int n) {
		totalCount = 1<<n;
		
		for(int i = 0; i < totalCount; i++) {
			for(int j = 0; j<N; j++) {
				if((i &  i << j) != 0) {
					System.out.print(numbers[j] + " ");
				};
			}
			System.out.println();
		}
	}

}
