package dataStructure.disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DisjointSetTest {
	
	private static int[] parents;
	

	private static void makeSet() { // 자신이 루트인 단위트리 생성
		Arrays.fill(parents, -1);
	}
	
	private static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]); // path compression
	}
	
	private static boolean union(int a, int b) {
		if(findSet(a) != findSet(b)) {
			parents[b] = findSet(a);
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int count = Integer.parseInt(in.readLine());
		
		parents = new int[N];
		
		makeSet();
		
		StringTokenizer st = null;
		while(count-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(union(a,b)) {
				System.out.println("union 성공 : 서로 다른집합을 하나로 만듦");
			}else {
				System.out.println("union 실패 : 이미 같은 집합");
			}
		}
		
		System.out.println(Arrays.toString(parents));	
	}
}
