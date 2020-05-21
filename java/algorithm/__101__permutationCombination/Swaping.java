/** 
 * 순열
 * 
 * 정의
 * 	서로 다른 n개의 원소에서 r개를 중복없이 골라 순서에 상관있게 나열하는 것을 n개에서 r개를 택하는 순열이라고 한다
 * 	(출처 나무위키)
 * 
 * 순열을 구하는 알고리즘
 * 	
 * 	1. swap과 재귀를 이용한 방법(input - 배열)
 * 		[1,2,3]이 있다고 해보자. 이것을 이용해서 구할 수 있는 모든 순열 경우의 수는 (3x2x1)즉 6가지 경우다.
 * 		그러면 주어진 배열에서 (0,0),(0,1),(0,2) 인덱스 쌍으로 swap한 이후 그 각각의 경우에서 (1,1),(1,2)로 swap하고 또다시 재귀로 (2,2)를 스왑하면
 * 		구할 수 있는 모든 경우의 수가 완성된다 (3x2x1) 
 * 		* 그런데 이렇게 짜면 nPr에서 r이 n인 경우, 즉 모든 원소를 배열하는 경우만 구할 수 있다. 
 * 		
 * 조합 
 * 
 * 1. 스택과 재귀를 이용한 방법(input - 배열)
 * 		[1,2,3,4]가 있고 2개를 뽑으려고 한다. 이 상황에서 처음 뽑을 수 있는 경우의 수는 1,2,3 까지만이다.(4를 뽑아버리면 뒤에 뽑을 것이 없다)
 * 		즉 4개중 2개를 뽑는다면 처음 함수에서는 (0-2) 인덱스 까지 선택권이 있고 그 다음은 (? - 3)인덱스 까지 선택권이 있다. 
 * 		이런 원리를 통해서 스택에 PUSH와 POP를 해주면 뽑는 모든 경우의 수를 다 얻을 수 있다.
 * 
 * 정의
 * 	서로 다른 n개의 원소에서 순서에 상관없이 r개를 뽑을 때, 이를 n개에서 r개를 택하는 조합이라고 한다
 * 	(출처 나무위키)
 * 
 * 
 * ..........................................................................................................
 * 활용 팁
 * 
 * 	순열이든 조합이든 기저조건에서 조합이나 순열이 완성된 상태이기 때문에 필요한 기능을 실행하면 된다.
 * 
 * 
 * @author Changhee Yoon
 */

package __101__permutationCombination;

import java.util.Arrays;
import java.util.Stack;

public class Swaping {

	static Stack<Character> combination = new Stack<Character>();

	public static void main(String args[]) throws Exception {

		char[] input = { 'A', 'B', 'C', 'D' };

		permutation(input, 0, input.length - 1);
		System.out.println();

		int r = 2; /* cCr 에서 r은 뽑는 갯수를 의미 */
		combination(input, input.length, 0, r);

	}

	static void swap(char[] str, int x, int y) {
		char temp = str[x];
		str[x] = str[y];
		str[y] = temp;
	}

	/* swap과 재귀를 활용한 순열 */
	static void permutation(char[] input, int startIndex, int endIndex) {
		if (startIndex == endIndex) { /* 기저조건 swap의 시작 지점과 끝지점이 같아져서 더이상 스왑이 일어나지 않는 시점 */
			System.out.println(Arrays.toString(input));
		} else {
			for (int i = startIndex; i <= endIndex; i++) {
				swap(input, startIndex, i);
				permutation(input, startIndex + 1, endIndex);
				swap(input, startIndex, i);
			}
		}
	}

	/* stack과 재귀를 이용한 조합 */
	static void combination(char[] input, int length, int startIndex, int r) { /* 기능적으로 r은 몇개를 뽑아야 하는지를 의미 */

		if (r == 0) { /*기저 조건, r이 0이 되어서 더이상 뽑을 숫자가 없는 상황 */
			System.out.println(combination.toString());
		} else {

			/*
			 * 만약 4C2의 상황이라면 [1,2,3,4]에서 처음에는 1,2,3까지 선택할 수 있다 처음에 4를 선택해버리면 뒤에 뽑을 경우의 수가 없다
			 * 그래서 length - r로 범위가 설정되는 것
			 */
			for (int i = startIndex; i <= length - r; ++i) {
				combination.push(input[i]);
				combination(input, length, i + 1, r - 1); /* 시작 인덱스는 다음으로 넘어가고, 뽑을 수는 하나 줄어든다. */
				combination.pop();
			}
		}
	}

}
