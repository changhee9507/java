/**
 * 백준 1931 회의실배정
 * 
 * 
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931  {

	static class Meeting implements Comparable<Meeting> {
		int start , end;
		Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			int res = this.end - o.end;
			if(res == 0) {
				res = this.start - o.start;
			}
			return res;
		}
	}
	
	static int N;
	static Meeting[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new Meeting[N];
		
		StringTokenizer st = null;
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list);
		ArrayList<Meeting> schedule = new ArrayList<Meeting>();
		schedule.add(list[0]);
		for(int i = 1; i<N; i++) {
			if(schedule.get(schedule.size()-1).end <= list[i].start) {
				schedule.add(list[i]);
			}
		}
		System.out.println(schedule.size());
	}

	

}
