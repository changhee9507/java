/**
 * 
 * 백준 17471 게리멘더링;
 * 
 * 
 */

package Combination;

import java.util.Arrays;
import java.util.Scanner;

public class Gerrymandering {

	static boolean[][] adjMatrix;
	static int[] population;
	static boolean[] isInComb;
	static int size;
	static int minGap = 99999;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();

		adjMatrix = new boolean[size + 1][size + 1];
		population = new int[size + 1];
		isInComb = new boolean[size + 1];

		/* 인구 정보 저장 */
		for (int i = 1; i <= size; i++) {
			population[i] = scan.nextInt();
		}

		/* 인접 정보 저장 */
		for (int i = 1; i <= size; i++) {
			int num = scan.nextInt();
			for (int j = 1; j <= num; j++) {
				int region = scan.nextInt();
				adjMatrix[i][region] = true;
			}
		}

		/* 연결 되어 있으면 모두 추가 */

		/* 인접 정보 출력 */
		/*
		 * for (int i = 0; i < size + 1; i++) { for (int j = 0; j < size + 1; j++) {
		 * System.out.print(adjMatrix[i][j] + " "); } System.out.println(); }
		 */

		System.out.println(Arrays.toString(population));

		
		for(int i =1; i<=size/2 ; i++) { combination(1,0,i); }
		 
		
		
		System.out.println(minGap);
	}

	static void connection() {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (adjMatrix[i][j] == true) {
					if (isInComb[i] == isInComb[j]) {

						for (int k = 1; k <= size; k++) {
							if (adjMatrix[j][k] == true) {
								adjMatrix[i][k] = true;
							}
						}

					}

				}
			}
		}
	}

	static void combination(int start, int count, int depth) {
		/* 카운트는 뽑는 숫자의 갯수가 된다. 카운트가 1이라면 원소가 한개인 것들 */
		if (count == depth) {
			System.out.println(Arrays.toString(isInComb));

			/* 이 조합에서 연결 상태를 갱신 */
			connection();

			/* 연결 되어 있지 않으면 return */
			for (int i = 1; i <= size; i++) {
				for (int j = 1; j <= size; j++) {
					if (i == j)
						continue;
					else {
						if (isInComb[i] == isInComb[j]) {
							if (adjMatrix[i][j] == false) {
								return;
							}
						}
					}
				}
			}
			
			
			
			int trueSum = 0;
			int falseSum = 0;
			
			for(int i = 1; i<size; i++) {
				if(isInComb[i] == true) {
					trueSum += population[i];
				}else {
					falseSum += population[i];
				}
			}
			
			System.out.println("trueSum " + trueSum + " falseSum " + falseSum);
			int gap = (trueSum - falseSum);
			
			if(gap>= 0 && gap < minGap) {
				minGap = gap;
			}
			
			if(gap <0 && (-1*gap) < minGap ) {
				minGap = -1 * gap;
			}
			

			/* 인접 정보 출력 */
			for (int i = 0; i < size + 1; i++) {
				for (int j = 0; j < size + 1; j++) {
					System.out.printf("%6s ", adjMatrix[i][j]);
				}
				System.out.println();
			}

			return;
		}

		for (int i = start; i <= size; i++) {
			if (isInComb[i] == true)
				continue;
			isInComb[i] = true;
			combination(start + 1, count + 1, depth);
			isInComb[i] = false;
		}
	}
}
