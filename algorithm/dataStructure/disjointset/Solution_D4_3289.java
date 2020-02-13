package dataStructure.disjointset;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_3289 {
	
	static int[] parents;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		final int TESTNUM = scan.nextInt();
		
		for(int testCase = 1; testCase<= TESTNUM; testCase++) {
			parents = new int[scan.nextInt()+1];
			Arrays.fill(parents, -1);
			
			int opNum = scan.nextInt();
			
			
			for(int j = 1; j <= opNum; j++) {
				int op = scan.nextInt();
				int firstElement = scan.nextInt();
				int secondElement = scan.nextInt();
				
				if(op == 0) {
					union(firstElement, secondElement);
				}
				
				if(op == 1) {
					check(firstElement, secondElement);
				}
				
			}
			
			System.out.printf("#%d %s\n",testCase, result.toString());
		}
		
	}
	
	private static void check(int ele1, int ele2) {
		int parent1=0;
		int parent2=0;
		
		while(parents[ele1] < 0) {
			ele1 = parents[ele1];
			if(ele1 <0 ) {
				break;
			}
		}
		
		while(parents[ele2] < 0) {
			ele2 = parents[ele2];
			if(ele2 <0 ) {
				break;
			}
		}
		
		if(ele1 == ele2) {
			result.append(1);
		}else {
			result.append(0);
		}
	}
	
	private static void union(int ele1, int ele2) {
		parents[ele2] = ele1;
	}

}
