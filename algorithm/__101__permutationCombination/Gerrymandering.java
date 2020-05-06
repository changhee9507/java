/**
 * 
 * 백준 17471 게리멘더링;
 * 
 * 
 */

package __101__permutationCombination;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Gerrymandering {

	/* 스태틱은 위에서 정의해두고 사용전에 초기화 되도록 사용하는 것이 좋을 것 같다 */
	
	static int regionNum;
	static Stack<boolean[]> combinations = new Stack<boolean[]>();
	static boolean[] used;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		regionNum = scan.nextInt();
		Region[] regions = new Region[regionNum];
		used = new boolean[regionNum];
		
		/* 지역마다 인구 저장 */
		for (int i = 0; i < regionNum; i++) {
			int population = scan.nextInt();
			regions[i] = new Region(population);
		}

		/* 연결정보 저장 */
		for (int i = 0; i < regionNum; i++) {
			int connectionNum = scan.nextInt();

			for (int j = 0; j < connectionNum; j++) {
				regions[i].connectedRegion.push(scan.nextInt());
			}
		}

		/* 입력이 잘 되었는지 확인 */
		for (int i = 0; i < regionNum; i++) {
			System.out.println("region " + i + " " + regions[i].population);
			while (!regions[i].connectedRegion.isEmpty()) {
				System.out.println(regions[i].connectedRegion.pop());
			}
		}

		/* 조합 생성 */
		for (int i = 1; i <= (regionNum/2); i++) {
			genComb(0, i);
		}
		
		/* 조합 확인 */
		/*while(!combinations.isEmpty()) {
			System.out.println(Arrays.toString(combinations.pop()));
		}*/

		/* 연결 만들기 */
		/* 불린 배열하나 만들어서 */
		while(!combinations.isEmpty()) {
			boolean[] check = combinations.pop();
			
		}
		
		
		
		/* 인구 차이 계산 */

		/* 최소값 갱신 */

	}
	
	/* 함수를 사용할 때 처럼 메인에서 클래스를 사용하려면 static이 필수적이다 */
	static public class Region {

		int population = 0;
		Stack<Integer> connectedRegion = new Stack<Integer>();

		public Region(int population) {
			this.population = population;

		}
	}

	

	static public void genComb(int count, int selectionNum) {
		if (count == selectionNum) {
			
			/*System.out.println("push" + Arrays.toString(used));*/
			combinations.push(Arrays.copyOf(used, used.length));
		}

		for (int i = 0+count; i < regionNum; i++) {
			if (used[i] == true) {
				continue;
			}
			
			used[i] = true;
			genComb(count + 1, selectionNum);
			used[i] = false;
		}
	}
}
