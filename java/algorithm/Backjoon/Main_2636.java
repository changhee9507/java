/**
 * 치즈
 * 
 * 메모 : 이런 문제는 단계단계마다 어떤 변화가 일어났는지를 정확히 파악해야
 * 		끝나는 시점과 동작을 제대로 시뮬레이션할 수 있다.
 * 
 * @author Changhee Yoon
 */
package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_2636 {

	static int R, C; /* row, col */
	static int map[][];
	static int time;
	static int cheezeNum;
	static int lastNum;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);

		map = new int[R][C];

		/* 맵 인풋 저장 */
		for (int i = 0; i < R; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if (map[i][j] == 1) {
					cheezeNum++;
				}
			}
		}

		/* 밀폐되지 않은 공기 부분만 체크해서 맵에 2로 저장한다 */
		checkAir(0,0);
		
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
	
		/* 치즈의 갯수가 없어질때까지 반복해서 시뮬레이션 한다 */
		while (cheezeNum != 0) {	
			
			simulation();
//			for(int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}

		System.out.println(time);
		System.out.println(lastNum);
	}

	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	static void simulation() {
		
		time++; /* 시뮬레이션 실행으로 시간이 1 흐른다. */
		LinkedList<int[]> willBeMelt = new LinkedList<>(); /* 공기랑 다아서 없어질 치즈의 위치를 저장한다 */

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1 ) { /* 치즈이면 수행한다. */
					
					/* 4방향으로 접근해서 공기인 2와 붙어있는 상태라면 그 위치를 저장해서 나중에 없앤다. */
					for (int k = 0; k < 4; k++) {
						int nextRow = i + dRow[k];
						int nextCol = j + dCol[k];
						
						if (nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) {
							continue;
						} else {
							if (map[nextRow][nextCol] == 2) {
								willBeMelt.add(new int[] { i, j });
								break;
							}
						}
					}
				}				
			}
		}

		//System.out.println(">> " + willBeMelt.size());
		/* 남은 치즈의 숫자와 이제 없어질 치즈의 숫자가 같다면 이것이 사라지기 전의 치즈 갯수이므로 저장한다 */
		if (cheezeNum == willBeMelt.size()) {
			lastNum = cheezeNum;
		}
		
		/* 치즈의 숫자를 빼준다음 녹아 없어질 치즈의 위치가 담긴 리스트에서 위치를 하나씩 꺼내서 치즈를 없애고 그곳을 공기 체크한다. */
		cheezeNum -= willBeMelt.size();
		while (!willBeMelt.isEmpty()) {
			int[] meltingPoint = willBeMelt.remove();
			int row = meltingPoint[0];
			int col = meltingPoint[1];
			map[row][col] = 0;
			checkAir(row, col);
		}

	}
	
	/* 공기체크는 단순히 치즈가 없는 곳과 밖의 공기를 구분해주며 2가 밖으 공기고 0은 밀폐된 곳이다. */
	static void checkAir(int row, int col) {
		
		map[row][col] = 2;
		for(int i=0; i<4; i++) {
			int newRow = row + dRow[i];
			int newCol = col + dCol[i];
			
			if(newRow < 0 || newCol <0 || newRow>= R || newCol >= C) {
				continue;
			}else {
				if(map[newRow][newCol] == 0) {
					checkAir(newRow, newCol);
				}
			}
		}
		
	}

}
