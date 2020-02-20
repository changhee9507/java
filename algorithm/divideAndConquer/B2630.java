/**
 * 4부분으로 분할하는 재귀를 이용한다.
 * 기저조건(쉽게 판단할 수 있거나 결정이 된 부분)에서 판단하는 재귀의 성질 그대-로
 * 
 */
package divideAndConquer;

import java.util.Scanner;

public class B2630 {
	
	static int whiteNum = 0; // false
	static int blueNum = 0; // true
	static int mapSize = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		mapSize = scan.nextInt();
		
		int[][] input = new int[mapSize][mapSize];
		
		/*인풋 저장*/
		for(int i=0; i<mapSize; i++) {
			for(int j =0; j<mapSize; j++) {
				input[i][j] = scan.nextInt();			
			}
		}
		/*인풋 출력*/
		/*for(int i=0; i<size; i++) {
			for(int j =0; j<size; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}*/
		
		divideAndConquer(input);
		
		System.out.println(whiteNum);
		System.out.println(blueNum);
	}
	
	public static int divideAndConquer(int[][] input) { // 8
		
		int size = input.length;
		int halfSize = size/2;
		
		if(size == 1) {
			return input[0][0];
		}
	
		/* 맵 나누기 */
		int[][] map1 = new int[size/2][size/2]; // 4 4
		int[][] map2 = new int[size/2][size/2]; // 4 4
		int[][] map3 = new int[size/2][size/2]; // 4 4
		int[][] map4 = new int[size/2][size/2]; // 4 4
		
		/* 값 저장 */
		for(int i=0; i<size; i++) {
			for(int j =0; j<size; j++) {
				if(i < halfSize && j < halfSize) {
					map1[i][j] = input[i][j];
				}
				else if(i < halfSize && j >= halfSize) {
					map2[i][j%halfSize] = input[i][j];
				}
				else if(i >= halfSize && j < halfSize) {
					map3[i%halfSize][j] = input[i][j];
				}
				else {
					map4[i%halfSize][j%halfSize] = input[i][j];
				}
			}
		}
	
		int[] parts = new int[4];
		parts[0] = divideAndConquer(map1);
		parts[1] = divideAndConquer(map2);
		parts[2] = divideAndConquer(map3);
		parts[3] = divideAndConquer(map4);
		
		
		/* 전부 같은 숫자라면 그 숫자를 리턴한다 */
		if(parts[0] == parts[1] && parts[1] == parts[2] && parts[2] == parts[3]) {
			if(size == mapSize) {
				if(parts[0] == 0) whiteNum++;
				else if(parts[0] == 1) blueNum++;
			}
			return parts[0];
		}else { /* 전부 같은 숫자가 아니라면 0,1의 카운트를 세서 올린다 */
			for(int i=0; i<4; i++) {
				if(parts[i] == 0) whiteNum++;
				else if(parts[i] == 1) blueNum++;
			}
			return 7;
		}
		
	}
}
