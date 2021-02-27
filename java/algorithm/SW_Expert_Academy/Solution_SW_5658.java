/**
 * 보물상자 비밀번호
 * 
 * 메모: Stringbuilder의  초기화
 * 		TreeSet의 접근 및 특성 (중복을 없애면서 자동적으로 오름차순)
 * 		LinkedList의 다양한 함수 활용 (add, remove는 first와 Last가 있어서 매우 편리하다) 
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Solution_SW_5658 {
	
	static int N; /* 주어지는 숫자의 갯수 상자의 한변에 있기 때문에 4의 배수가 된다.*/
	static int K; /* k번째 숫자 */
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine());
		
		/* 계산 시작 */
		for(int test=1; test<=TC; test++) {
			/* k,M 인풋 저장 */
			String[] tmp = br.readLine().split(" ");
			
			N = Integer.parseInt(tmp[0]);
			K = Integer.parseInt(tmp[1]);
			
			/* 주어지는 16진수 숫자는 이동을 위해서 LinkedList에 저장 */
			LinkedList<Character> input = new LinkedList<Character>();
			
			String inputStr = br.readLine().trim();
			for(int i=0; i<inputStr.length(); i++) {
				input.addLast(inputStr.charAt(i));
			}
			
			/* 중복을 없애는 동시에 정렬하기 위해서 TreeSet에 숫자를 저장*/
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			/* 한 16진수의 길이 */
			int numLength = N / 4;		
			for(int i=0; i<numLength; i++) { /* 회전하는 수는 한변의 숫자길이만큼 이루어진다. */
				//System.out.println(input.toString());
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<4; j++) { /* 숫자 조각은 항상 4개(4각형 상자라는 가정때문 )*/
					for(int k=0; k<numLength; k++) { /* 숫자의 길이 만큼 합친다음 set에 추가시킨다.*/
						sb.append(input.get(j*numLength + k));
					}
					set.add(Integer.parseInt(sb.toString(), 16));
					sb.setLength(0); /* StringBuilder의 초기화는 길이를 0으로 만드는 것 */
				}
				
				input.addFirst(input.removeLast()); /* 시계방향 회전을 의미한다. 뒤에서 뺀다음 처음에 추가시켜준다. */
			}
			
			//System.out.println(set.toString());
			/* set에서는 바로 꺼내서 쓸 수 없기 대문에 iter를 만들어서 next로 접근한다.*/
			Iterator<Integer> iter = set.iterator();
			
			/* 오름차순이기 때문에 내림차순의 K번째라면 변환하는 과정이 필요해서 i범위가 복잡해져있다. */
			for(int i=1; i<set.size() - K + 1; i++) {
				iter.next();
			}
			
			
			/* 출력 */
			System.out.printf("#%d %d\n",test, iter.next());
			
		}
		
		
	}
	
}
