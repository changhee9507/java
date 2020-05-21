/**
 * 줄 세우기
 * 
 * 메모: 위상정렬
 * 
 */
package __002__baekjoon;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2252 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] indegree = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		/* 리스트 생성 및 indegree 저장(대소관계에서 뒤에 있는 횟수) */
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			indegree[y]++;
		}

		/* indegree가 0이면 큐에 저장 */
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		/* 큐의 앞에서 부터 접근하면서 해당 숫자의 뒤에 있어야 되는 수자의 indegree를 1씩 줄이고 0이면 큐에 입력*/
		while (!queue.isEmpty()) {
			System.out.println(queue.peek());
			int current = queue.poll();

			// 자신이 가르키고 있는 좌표들을 방문하여 indegree값을 -1 해주고 만약 0이라면 큐에 넣어준다.
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}

	}

}
