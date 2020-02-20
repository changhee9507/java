package com.ssafy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_1260_DFS와BFS_서울8반_정지찬2 {
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static int num;
	static int nodeNum;
	static int start;
	
	public static void dfs(int index) {
		System.out.print(index + " ");
		visited[index] = true;
		ArrayList<Integer> cur = list[index];
		for(int i = 0; i < cur.size(); i++) {
			if(visited[cur.get(i)]) continue;
			dfs(cur.get(i));
		}		
	}
	
	public static void print(ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		visited = new boolean[num + 1];
		list = new ArrayList[num + 1];
		for(int i = 1; i <= num; i++) {
			list[i] = new ArrayList<Integer>();
		}
		nodeNum = sc.nextInt();
		start = sc.nextInt();
		
		int a, b;
		for(int i = 0; i < nodeNum; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= num; i++) {
			Collections.sort(list[i]);
		}
		dfs(start);
	}
}
