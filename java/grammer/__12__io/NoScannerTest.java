package __12__io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NoScannerTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); /* 스페이스바 공백을 포함해서 엔터 이전까지 받아들인다. */  
		System.out.println("|" + input + "|");
        System.out.println("Length is " + input.length());
        
        String[] inputArr = input.split(" "); /* 함께 같이 쓰이는 split은 구분자 역활을 하는 '문자열'을 삭제하고 다른 문자를 String의 형태로 저장한다. */
        System.out.println(Arrays.toString(inputArr));
        
        StringTokenizer st = new StringTokenizer(input); /* 기본적으로 스페이스바를 기준으로 나누어서 토근을 가지고 있고 옵션을 넣어줄 수 있다 */
        while(st.hasMoreTokens()) {/* 남은 토큰(문자열)이 있는지 확인 */
        	System.out.println(st.nextToken()); /* 토큰은 문자열 */
        }
        
	}

}
