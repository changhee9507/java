package __004__programmers;

import java.util.Arrays;

public class Solution_L1_Budget {

	public static void main(String[] args) {
		int[] d = {1,3,2,5,4};
		int budget = 9;
		System.out.println(solution(d, budget));
	}

	public static int solution(int[] d, int budget) {
        int cnt = 0;
        
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
        	if(d[i] <= budget) {
        		cnt++;
        		budget -= d[i];
        	}else {
        		break;
        	}
        }
        
        return cnt;
    }
}