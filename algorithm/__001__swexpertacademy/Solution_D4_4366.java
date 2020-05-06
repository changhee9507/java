/**
 * 정식이의 은행업무
 * 
 * 메모: for에 char을 이용할 수 있다.
 * 
 * 		char의 저장 및 수정에는 StringBuilder이 좋다. append및 set 등이 거의 linkedLink의 성능을 가진다.
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_D4_4366 {

	static int answer;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TC; test++) {
			
			StringBuilder binary = new StringBuilder();
			binary.append(br.readLine().trim());
			StringBuilder ternary = new StringBuilder(); 
			ternary.append(br.readLine().trim());
			
			HashSet<Integer> set = new HashSet<>();
			
			for(int i=0; i<binary.length(); i++) {
				if(binary.charAt(i) == '0') {
					binary.setCharAt(i, '1');
					set.add(Integer.parseInt(binary.toString(), 2));
					binary.setCharAt(i, '0');
				}else {
					binary.setCharAt(i, '0');
					set.add(Integer.parseInt(binary.toString(), 2));
					binary.setCharAt(i, '1');
				}
			}
			
			for(int i=0; i<ternary.length(); i++) {
				char preChar = ternary.charAt(i);
				for(char j= '0'; j< '3'; j++) {
					if(preChar == j) {
						continue;
					}else {
						ternary.setCharAt(i, j);
						//System.out.println(ternary.toString());
						if(set.contains(Integer.parseInt(ternary.toString(), 3))) {
							answer = Integer.parseInt(ternary.toString(), 3);
						}
						ternary.setCharAt(i, preChar);
						
					}	
				}
			}
			
			System.out.printf("#%d %d\n", test, answer);
		}
	}

}
