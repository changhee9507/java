/**
 * 요리사
 * 
 * 요약: 조합을 생성해서 해당 조합의 합의 차이가 최소가 되도록 구하고 출력
 * 메모: 
 * 
 * 	조합
 * 		- 간단하게 조합을 만들때는 (현재 조합애 추가한 갯수인 count, 몇개를 담고 싶은지 판단하는 R, 이전에 선택한 index이 3가지가 함수의 매개변수로 들어가면 된다)
 * 		- 조합을 배열에서 활용하고 싶다면 boolean 형태로 다시 수정해서 쓰는 것이 가능하다
 * 		- nCr에서 n이 짝수 일때, 처음 숫자로 맨처음 숫자를 뽑은 조합과 아닌 조합의 숫자가 같다
 * 			ex) 0, 1, 2, 3 중에서 2개를 뽑는 방법은 0,1 0,2 0,3 과 이 들의 반대인 [2,3] [1,3] [1,2]로 나누어 진다.
 * 
 * @author Changhee Yoon
 * 문제출처: SW Expert Academy
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_4012 {

	static int N;
	static int[][] map;
	static int[] combinations;
	static int min;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TESTCASE; test++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			combinations = new int[N / 2];

			/* 인풋 저장 */
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				//System.out.println(Arrays.toString(map[i]));
			}

			/* N 절반 갯수 만큼 조합을 만든다. */
			combination(0, 0, N / 2);
			
			System.out.printf("#%d %d\n", test, min);

		}

	}

	static void combination(int index, int count, int num) {
		if (count == num) {
			
			
			/* 조합의 결과를 boolean 배열 형식으로 전환 */
			boolean[] combResult = new boolean[N];
			for (int i = 0; i < combinations.length; i++) {
				combResult[combinations[i]] = true;
			}

			int sumTrue = 0;
			int sumFalse = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(combResult[i] == true && combResult[j] == true) {
						sumTrue += map[i][j];  
					}else if(combResult[i] == false && combResult[j] == false) {
						sumFalse += map[i][j];
					}else {
						continue;
					}
				}
			}
			
			int difference = Math.abs(sumTrue - sumFalse);
			
			if(difference < min) {
				min = difference;
			}

			//System.out.println(Arrays.toString(combinations) + "||" + difference);
		} else {
			for (int i = index; i < N; i++) {
				if (count == 0 && i > 0) {
					continue;
				}

				combinations[count] = i;
				combination(i + 1, count + 1, num);

			}
		}
	}

}
