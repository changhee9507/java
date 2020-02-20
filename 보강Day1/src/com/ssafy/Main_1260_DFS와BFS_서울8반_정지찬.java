package com.ssafy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS와BFS_서울8반_정지찬 {
	
	static boolean[] visited;
	static boolean[][] map;
	static int num;
	static int nodeNum;
	static int start;
	
	public static void dfs(int index) {
		System.out.print(index + " ");
		visited[index] = true;
		for(int i = 1; i <= num; i++) {
			if(index == i) continue;
			if(visited[i] || !map[index][i]) continue;
			dfs(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		visited = new boolean[num + 1];
		map = new boolean[num + 1][num + 1];
		nodeNum = sc.nextInt();
		start = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int a, b;
		for(int i = 0; i < nodeNum; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		
		dfs(start);
		System.out.println();
		Arrays.fill(visited, false);
		queue.offer(start);
		visited[start] = true;
		int cur;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur + " ");
			for(int i = 1; i <= num; i++) {
				if(!map[cur][i]) continue;
				if(visited[i]) continue;
				queue.offer(i);
				visited[i] = true;
			}
		}
	}
}









