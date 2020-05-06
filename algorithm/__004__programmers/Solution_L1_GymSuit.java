/**
 * 체육복
 * 
 * 메모: 자주 예외 케이스를 생각하지 못하고 문제가 발생하는 알고리즘을 생각하는 것 같다.
 * 
 * 		1. 우선 여벌이 있으면서 도난 당한 학생들은 자기것을 쓸 것이기 때문에 상황이 다른다
 * 		   	따라서 우선적으로 자신의 체육복을 써야 되기 때문에 이를 먼저 처리한다.
 * 
 * 		2. 문제 조건을 전부 읽어야 된다. 예외 상황이나 알고리즘이 완전히 달라질 수 있다.
 * 
 * 		3. 
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution_L1_GymSuit {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reverse = { 1, 3, 5 };

		System.out.println(solution(n, lost, reverse));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		
		int lostNum = lost.length; /* 잃은 사람 수*/
		HashSet<Integer> set = new HashSet<>(); /* */

		/* reseve번호를 set에 저장 */
		for (int i = 0; i < reserve.length; i++) {
			set.add(reserve[i]);
		}

		/* 여벌옷을 가지고 있으면서 도난을 당한 특수한 경우를 미리 처리해 준다. 
		 * 기본 아이디어는 도난 당한 번호를 하나씩 접근하면서 여벌 옷이 있는 번호인지 확인하고 처리한다.
		 * */
		boolean[] checked = new boolean[lost.length];
		Arrays.sort(lost);
		for (int i = 0; i < lost.length; i++) {
			if (set.contains(lost[i])) {
				set.remove(lost[i]);
				lostNum--;
				checked[i] = true;
			}
		}

		
		/*
		 * 도난 당한 동시에 여벌옷이 있는 사람을 제외하고
		 * 도난 당한 사람들은 숫자가 작은 앞에서 부터
		 * 번호 차이가 1이 나는 것이 있는지 set의 contains 함수를 이용해서 확인하고
		 * 있으면 빌린다.
		 * */
		
		for (int i = 0; i < lost.length; i++) {
			if (checked[i]) {
				continue;
			} else if (set.contains(lost[i] - 1)) {
				set.remove(lost[i] - 1);
				lostNum--;
			} else if (set.contains(lost[i] + 1)) {
				set.remove(lost[i] + 1);
				lostNum--;
			}
		}

		System.out.println(lostNum + " " + set.toString());

		
		/* 계산의 결과는 체육복을 빌리지 못한 사람들의 수를 의미하게 되고 따라서 전체 숫자에서 빌리지 못한 수를 빼면 체육복이 있는 사람의 수*/
		return n - lostNum;
	}
}