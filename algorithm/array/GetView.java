package array;

import java.util.Scanner;

public class GetView {
	
	final static int TESTCASE = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		for(int testCase =1 ; testCase<= TESTCASE; testCase++) {
			int width = scanner.nextInt();
			int houseCount = 0;
			
			int[][] map = new int[255][width];
			for(int i=0; i<width; i++) {
				int buildingHigh = scanner.nextInt();
				
				for(int j=0; j<buildingHigh; j++) {
					map[j][i] = 1;
				}
			}
			
			/* 맵 출력 */
			/*for(int i =0; i<255;i++) {
				for(int j = 0; j<width; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}*/
			
			/* 확인 & 카운트 */
			for(int i =0; i<255;i++) {
				for(int j = 0; j<width; j++) {
					
					if(map[i][j] == 0) {
						continue;
					}
					
					int leftOne = j-1;
					int leftTwo = j-2;
					int rightOne = j+1;
					int rightTwo = j+2;
					
					if(leftTwo < 0 || rightTwo >= width) {
						continue;
					}
					
					if(map[i][leftOne] ==0 && map[i][leftTwo] ==0&& map[i][rightOne] ==0&& map[i][rightTwo] == 0) {
						houseCount++;
					}
					
				}
			}
			
			System.out.printf("#%d %d\n",testCase, houseCount);
			
		}
		

	}

}
