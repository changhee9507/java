package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS_Queue {

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
				{ 0, 0, 0, 0, 0, 1, 0 },// G의 인접행렬
		};

		dfs(0);
		System.out.println("\n===================");
		dfs2(0);
		System.out.println("\n===================");
		bfs(0);
		System.out.println("\n===================");
		bfs2(0);
	}

	private static void dfs(int current) { // 현재노드
		//// 방문한 다음에 visited 처리 //부르기전에 visited처리 할 수도 있음=>4번 stack으로 풀기
		visited[current] = true;
		System.out.printf("%c", current + 65); // 알파벳으로 찍기
		for (int i = 0; i < N; i++) {
			// 기저조건
			// 갈 수 있는데만 가려고, 현재행에서 갈 수 있는곳 탐색(인접체크) / visited체크
			if (adjMatrix[current][i] > 0 && !visited[i])
				dfs(i);
		}
	}

	// 4

	// dfs : 스택으로

	private static void dfs2(int start) { // 현재노드

		boolean[] visited = new boolean[N];

		Stack<Integer> stack = new Stack<Integer>();

		visited[start] = true;

		stack.push(start);

		int current;

		while (!stack.isEmpty()) {

			// 뒤에서 나오기

			current = stack.pop();

			System.out.printf("%c", current + 65); // 알파벳으로 찍기

			for (int i = 0; i < N; i++) {

				// 기저조건

				if (adjMatrix[current][i] > 0 && !visited[i]) {

					// 부르기전에 visited처리 할 수도 있음

					visited[i] = true;

					stack.push(i);

				}

			}

		}

	}

	// 2

	private static void bfs(int start) {

		boolean[] visited = new boolean[N];

		Queue<Integer> queue = new LinkedList<Integer>();

		visited[start] = true;

		queue.offer(start);

		int current;

		while (!queue.isEmpty()) {

			// 앞에서 나오기

			current = queue.poll();

			System.out.printf("%c", current + 65); // 알파벳으로 찍기

			for (int i = 0; i < N; i++) {

				// 기저조건

				// 갈 수 있는데만 가려고, 현재행에서 갈 수 있는곳 탐색(인접체크) / visited체크

				if (adjMatrix[current][i] > 0 && !visited[i]) {

					// 또다른 bfs호출하기 방문처리

					visited[i] = true;

					queue.offer(i);

				}

			}

		}

	}

	// 3

	// 한 턴씩 나눠서 출력하기

	private static void bfs2(int start) {

		boolean[] visited = new boolean[N];

		Queue<Integer> queue = new LinkedList<Integer>();

		// 들어올때 방문처리

		visited[start] = true;

		queue.offer(start);

		int current, size;

		while (!queue.isEmpty()) {

			size = queue.size(); // 같은 너비끼리 끊기 위해서

			while (size-- > 0) {

				// 같은 너비인것들

				current = queue.poll();

				System.out.printf("%c", current + 65); // 알파벳으로 찍기

				for (int i = 0; i < N; i++) {

					// 기저조건

					// 갈 수 있는데만 가려고, 현재행에서 갈 수 있는곳 탐색(인접체크) / visited체크

					if (adjMatrix[current][i] > 0 && !visited[i]) {

						visited[i] = true;

						queue.offer(i);

					}

				}

			}

			System.out.println("\n-------------------------");

		}

	}
}
