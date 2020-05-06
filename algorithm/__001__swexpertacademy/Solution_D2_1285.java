/**
 * 아름이의 돌 던지기
 * 
 * 메모: map의 활용을 경험할 수 있는 좋은 문제, 어떤 key와 거기에 따른 value 그리고 이들을 정렬할 필요가 있을때 정말 유용할 것으로 보임8
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution_D2_1285 {

	static TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
				
		for(int test=1; test<=TESTCASE; test++) {
			map.clear();
			int N = Integer.parseInt(br.readLine());/* 돌 던지는 사람 수 */
			String[] tmp = br.readLine().split(" ", N); /*음수가 포함된 경우의 구분을 위해서 */
			
			//System.out.println(Arrays.toString(tmp));
			for(int i=0; i<N; i++) {
				int input = Math.abs(Integer.parseInt(tmp[i]));
				if(map.containsKey(input)) { /* 이미 저장되어 있다면 value를 하나 증가시켜서 다시 저장*/
					map.put(input, map.get(input) + 1);
				}else { /* 새로운 키를 가진 값을 저장한다면 value를 1로 설정 */
					map.put(input, 1);
				}
			}
			
			Iterator itr = map.entrySet().iterator(); /* 하나의 entry객체를 가져와서 그 키와 value를 출력 */
			Map.Entry<Integer, Integer> e = (Entry<Integer, Integer>) itr.next();
			System.out.printf("#%d %d %d\n", test, e.getKey(), e.getValue());
		}
		
	}

}
