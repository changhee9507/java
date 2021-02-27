/**
 * 대각선 출력하기
 * 
 * 요약 : 주어진 모양을 출력 (대각선만 다른 문자로)
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

public class Solution_D1_2027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==j) System.out.print('#');
				else System.out.print("+");
			}
			System.out.println();
		}
	}

}
