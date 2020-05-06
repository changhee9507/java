package __103__set;

import java.util.Arrays;
import java.util.Scanner;

public class Main_J1863_종교_윤창희 {

	static int[] parents;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int studentNum = scan.nextInt();
		parents = new int[studentNum+1];
		Arrays.fill(parents, -1);
		int pairNum = scan.nextInt();
		int count = 0;
		
		/* 합집합 연산 */
		for(int i=1; i<= pairNum; i++) {
			int student1 = scan.nextInt();
			int student2 = scan.nextInt();
			
			union(student1, student2);
		}
		
		/* 집합 카운트 */
		for(int i=1; i<= studentNum; i++) {
			if(parents[i] < 0) {
				count++;
			}
		}
		
		/* 결과 출력*/
		System.out.println(count);
		
	}
	
	static void union(int ele1, int ele2) { /* 이미 대표자가 같으면 return 아니라면 두번째 원소의 대표자를 연결 */
		int rep1 = getRepresentor(ele1);
		int rep2 = getRepresentor(ele2);
				
		if(rep1 == rep2) return;
		else {
			parents[rep2] = rep1;
		}
	}

	static int getRepresentor(int ele) { /* 대표자를 구하는 동시에 연결을 압축 */
		if (parents[ele] < 0)
			return ele;
		else {
			return parents[ele] = getRepresentor(parents[ele]); /* 연결 압축 */
		}
	}
}
