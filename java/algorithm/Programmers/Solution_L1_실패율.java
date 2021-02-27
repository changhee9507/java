/**
 * 실패율
 * 
 * 메모: 코드가 길어지더라도 순서를 명확하게 하고 중요 사항마다 구분해서 계산을 해야 디버깅이 쉽고 코드의 가독성이 높아진다.
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.Arrays;

public class Solution_L1_실패율 {

	public static void main(String[] args) {

		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

		System.out.println(solution(N, stages));
	}

	public static int[] solution(int N, int[] stages) {

		int[] failNum = new int[N + 2];
		Stage[] stageArr = new Stage[N];

		for (int i = 0; i < stages.length; i++) {
			failNum[stages[i]]++;
		}
		// System.out.println(Arrays.toString(failNum));

		for (int i = 1; i <= N; i++) {
			int fail = failNum[i];
			int reachedNum = 0;
			for (int j = i; j < failNum.length; j++) {
				reachedNum += failNum[j];
			}

			double failRate = 0;
			if(reachedNum != 0) { /* 접근한 유저가 없는 경우 0으로 처리해준다. */
				failRate = (double)fail / reachedNum; 
			}
			stageArr[i-1] = new Stage(i, failRate);
		}
		
		Arrays.sort(stageArr); /* comparable을 바탕으로 배열 비교를 실행한다. */
		//System.out.println(Arrays.toString(stageArr));
		
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			answer[i] = stageArr[i].num;
		}
		
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	static class Stage implements Comparable<Stage> { /* 스태이지에 대한 클래스를 만들며 비교가능하도록 comparable<비교 타입>인터페이스를 구현한다. */
		int num;
		double failRate;

		public Stage(int n, double d) {
			this.num = n;
			this.failRate = d;
		}

		@Override
		public String toString() {
			return "Stage [num=" + num + ", failRate=" + failRate + "]";
		}

		
		/* 비교 함수를든 정수를 리턴하는데 보통 이 값이 양수이면 순서를 바꾸도록 구현되어 있기 때문에
		 * 내림차순이라면 왼쪽이 오른쪽보다 클 때 바꿔야 되기 때문에 this - later 의 방식을 취한다. */
		@Override /* 어떤 기준으로 비교할 것인지 여기를 바탕으로 설정할 수 있다.*/
		public int compareTo(Stage arg0) {
			if(arg0.failRate != this.failRate) {
				return Double.compare(arg0.failRate, this.failRate);
			}else {
				return Integer.compare(this.num, arg0.num);
			}
			 
		}
		
		
	}
}