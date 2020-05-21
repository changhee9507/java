/**
 * 하나로
 * 
 * 요약 :
 * 
 * 메모 : 크루스칼 알고리즘을 이용한다
 * 		사이클이 생긴다는 것은 두 노드가 같은 집합에 있다는 것과 동일하게 생각할 수 있기 때문에 집합의 연산을 이용한다.
 * 		
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_D4_1251 {
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for (int test=1; test<=TESTCASE; test++) {
			int N = Integer.parseInt(br.readLine());
			int[][] islands = new int[N][2];
			
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				islands[i][0] = Integer.parseInt(tmp[i]);
			}
			tmp = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				islands[i][1] = Integer.parseInt(tmp[i]);
			}
			
			double E = Double.parseDouble(br.readLine());
			long[][] paths = new long[(N * (N - 1)) / 2][3]; /* 출발지, 도착지, 거리를 담은 */
			
			int count = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					paths[count][0] = i;
					paths[count][1] = j;
					paths[count][2] = distance(islands[i][0], islands[j][0], islands[i][1], islands[j][1]);
					count++;
				}
			}
			
			Arrays.sort(paths, new Comparator<long[]>() {
				@Override
				public int compare(long[] o1, long[] o2) {
					return Long.compare(o1[2], o2[2]);
				}
			});
			
			parents = new int[N];
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			
			long result = 0;
			int cnt = 0;
			for (int i = 0; i < (N * (N - 1)) / 2; i++) {
				
				int a = findSet((int) paths[i][0]);
				int b = findSet((int) paths[i][1]);
				if (a == b) /* 대표자가 같다면 즉 두 섬이 같은 집합에 있다면 그냥 넘어간다 */
					continue;
				cnt++; /* 대표자가 다르다면 카운트를 올린다. */
				unionSet(a, b); /* 두 섬을 같은 집합으로 (뒤의 대표자를 앞의 대표자로)*/
				result += paths[i][2]; /* 현재 환경부담금을 누적 */
				if (cnt == N - 1) /* n-1개의 간선이 추가 되었다면 모든 노드가 연결 되기 때문에 종료 */
					break;
			}
			System.out.println("#" + test + " " + Math.round(result * E));
		}
	}

	static long distance(int x1, int x2, int y1, int y2) {
		long d = (long) ((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		return d;
	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	/* 해당 노드의 대표노드(집합에서 대표자개념)를 리턴*/
	static int findSet(int x) {
		if (parents[x] == x) { /*자신과 대표자가 같은 상황이면 자신의 인덱스를 그대로 리턴*/
			return x;
		}
		parents[x] = findSet(parents[x]); /*그렇지 않다면 자신의 대표자의 대표자를 찾는 과정을 반복해서 결국 가장 상위의 대표자를 리턴 */
		return parents[x];
	}

	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px != py) {
			parents[py] = parents[px];
		}
	}

}