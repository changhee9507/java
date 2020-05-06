package __004__programmers.line;

import java.util.Arrays;

public class Problem2 {

	static int[] combResult = new int[2];
	static int max = Integer.MIN_VALUE;
	static String staticAnswer_sheet;
	static String[] staticSheets;

	public static void main(String[] args) {

		String answer_sheet = "24551";
		String[] sheets = { "24553", "24553", "24553", "24553" };
		System.out.println(solution(answer_sheet, sheets));
	}

	static public int solution(String answer_sheet, String[] sheets) {
		staticAnswer_sheet = answer_sheet;
		staticSheets = sheets;

		comb(sheets.length, 2, 0, 0); /* 응시자 중에서 2명의 조합을 index 배열로 얻는다 */

		return max;
	}

	public static void comb(int N, int R, int start, int cnt) {
		if (cnt == R) {
			//System.out.println(Arrays.toString(combResult));
			int cheatingValue = getValue(combResult);

			if(cheatingValue > max ) {
				max = cheatingValue;
			}
		} else {

			for (int i = start; i < N; i++) {
				combResult[cnt] = i;
				comb(N, R, i + 1, cnt + 1);
			}
		}
	}

	public static int getValue(int[] input) {
		int totalCheating = 0; /* 총 의심 문항 수 */
		int maxContinue = Integer.MIN_VALUE; /* 가장 긴 의심문항 수 */
		int cnt = 0;
	

		for (int i = 0; i < staticAnswer_sheet.length(); i++) {

			/* 두 응시자의 답이 같으면 check */
			if (staticSheets[input[0]].charAt(i) == staticSheets[input[1]].charAt(i)) {

				if (staticAnswer_sheet.charAt(i) == staticSheets[input[1]].charAt(i)) {/* 해당 문항이 정답이면 의심문항 x*/
					/* 의심문항이 끝어진 경우 - 1.가장 긴 의심문항 수 확인, 2. cnt 갱신 */
					
					if(cnt > maxContinue) {
						maxContinue = cnt; 
					}
					
					cnt = 0;
				} else { /* 해당 문항이 오답인 경우*/
					//System.out.println("cnt up" + staticAnswer_sheet.charAt(i) + " " +staticSheets[input[1]].charAt(i));
					cnt++;
					totalCheating++;
					
					/* 마지막이면 끝어진 경우의 처리를 해준다*/
					if(i == staticAnswer_sheet.length() - 1) {
						if(cnt > maxContinue) {
							maxContinue = cnt; 
						}
						
						cnt = 0;
					}
				}
			} else {
				/* 의심문항이 끝어진 경우 - 1.가장 긴 의심문항 수 확인, 2. cnt 갱신 */
				
				if(cnt > maxContinue) {
					maxContinue = cnt; 
				}
				
				cnt = 0;
			}
		}
		
		System.out.println(totalCheating + " " + maxContinue);
	
		/* 부정행위 가능성 지수는 총 의심 문항수 + 가장 긴 연속된 의심 문항 수의 제곱 */
		return totalCheating + (maxContinue) * (maxContinue);

	}
}
