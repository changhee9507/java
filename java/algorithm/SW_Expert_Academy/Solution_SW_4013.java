/**
 * 특이한 자석
 * 
 * 요약:
 * 
 * 메모: toCharArray는 공백도 포함하기 때문에 그냥 split을 이용하는 것이 좋다
 * 
 * 		static class를 안에 만들어서 광범위하게 변수나 배열들을 사용할 수 있다.
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SW_4013 {

	static int K; /* 회전수 */
	static Cog[] cogs = new Cog[4];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp;
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			result = 0;
			K = Integer.parseInt(br.readLine());
			/* 바퀴정보 저장 */
			for(int i=0; i<4; i++) {
				tmp = br.readLine().split(" ");
				char[] sawtooth = new char[8];
				for(int j=0; j<8; j++) {
					if(tmp[j].equals("1")) {
						sawtooth[j] = 'S';
					}else {
						sawtooth[j] = 'N';
					}
				}
				
				cogs[i] = new Cog(i,sawtooth);
				//System.out.println(cogs[i]);
			}
			
			/*회전*/
			for(int i=0; i<K; i++) {
				tmp = br.readLine().split(" ");
				int cogNum = Integer.parseInt(tmp[0]) - 1;
				int direction = Integer.parseInt(tmp[1]);
				//System.out.println("cogNum, direction " + cogNum + " " + direction);
				cogs[cogNum].rotation(direction, -999);
				
			}
			
			/*점수 계산*/
			for(int i=0; i<4; i++) {
				//System.out.println(cogs[i]);
				if(cogs[i].sawtooth[0] == 'S') {
					result += Math.pow(2, i);
				}
			}
			/*출력*/
			System.out.printf("#%d %d\n", test, result);
		}
		
	}
	
	static class Cog{ /* 톱니바퀴 */
		int num;
		char[] sawtooth = new char[8]; /* 톱니*/
		
		public Cog(int num, char[] sawtooth) {
			this.num = num;
			this.sawtooth = sawtooth;
		}
		
		void rotation(int direction, int preCog) {
			if(direction == 1) { /* 시계방향 */
				/*왼쪽 자석 확인 & 회전 */
				if(num-1 >= 0 && preCog != num-1) { /**/
					if(this.sawtooth[6] != cogs[num-1].sawtooth[2]) {
						cogs[num-1].rotation(-1, this.num);
					}
				}
				/*오른쪽 자석 확인 & 회전*/
				if(num+1 < 4 && preCog != num+1) { /**/
					if(this.sawtooth[2] != cogs[num+1].sawtooth[6]) {
						cogs[num+1].rotation(-1, this.num);
					}
				}
				
				/* 자신 회전 */
				char tmp = sawtooth[7];
				for(int i=7; i>0; i--) {
					sawtooth[i] = sawtooth[i-1];
				}
				sawtooth[0] = tmp;
				
				//System.out.println(num+ " " + direction+ " " +this);
			}else { /* 반시계방향 */
				/*왼쪽 자석 확인 & 회전 */
				if(num-1 >= 0 && preCog != num-1) { /**/
					if(this.sawtooth[6] != cogs[num-1].sawtooth[2]) {
						cogs[num-1].rotation(1, this.num);
					}
				}
				/*오른쪽 자석 확인 & 회전*/
				if(num+1 < 4 && preCog != num+1) { /**/
					if(this.sawtooth[2] != cogs[num+1].sawtooth[6]) {
						cogs[num+1].rotation(1, this.num);
					}
				}
				/* 자신 회전 */
				char tmp = sawtooth[0];
				for(int i=0; i<7; i++) {
					sawtooth[i] = sawtooth[i+1];
				}
				sawtooth[7] = tmp;
				//System.out.println(num+ " " + direction+ " " +this);
			}
			
		}

		@Override
		public String toString() {
			return "Cog [num=" + num + "]" + Arrays.toString(sawtooth);
		}
		
		
	}
	
}



