/**
 * 재귀로 구현을 할 때는 현재 어떤 행동을 하는지
 * 언제 함수가 끝나는지를 중심으로 생각해야 된다.
 * 
 * @author Changhee Yoon
 */

package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS_Recursion {

	private static int adjMatrix[][]; // 인접행렬
	private static boolean visited[];
	private static int mapSize;

	public static void main(String[] args) {
		
		mapSize = 7;
		adjMatrix = new int[mapSize][mapSize];
		visited = new boolean[mapSize];
		adjMatrix = new int[][] {
				{ 0, 1, 1, 0, 0, 0, 0 }, // A의 인접행렬
				{ 1, 0, 0, 1, 1, 0, 0 }, // B의 인접행렬
				{ 1, 0, 0, 0, 1, 0, 0 }, // C의 인접행렬
				{ 0, 1, 0, 0, 0, 1, 0 }, // D의 인접행렬
				{ 0, 1, 1, 0, 0, 1, 0 }, // E의 인접행렬
				{ 0, 0, 0, 1, 1, 0, 1 }, // F의 인접행렬
				{ 0, 0, 0, 0, 0, 1, 0 }, // G의 인접행렬
		};
		dfs(0);
	}

	/* 재귀를 이용한 dfs */
	private static void dfs(int current) {
		//// 방문한 다음에 visited 처리 //부르기전에 visited처리 할 수도 있음=>4번 stack으로 풀기
		visited[current] = true; /* 현재 */
		System.out.printf("%c", current + 65); // 알파벳으로 찍기
		for (int i = 0; i < mapSize; i++) {
			// 기저조건
			// 갈 수 있는데만 가려고, 현재행에서 갈 수 있는곳 탐색(인접체크) / visited체크
			if (adjMatrix[current][i] > 0 && !visited[i])
				dfs(i);
		}
	}
}
