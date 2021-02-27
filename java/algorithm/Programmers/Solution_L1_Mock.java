package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_L1_Mock {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		int[] input = {1,3,2,4,2};
		
		System.out.println(s.solution(input));
	}
	
	
	/*****************************************/
	static class Solution {
		
		static int[][] result = new int[3][2];
		static int[] answer = new int[3];
	
	    public int[] solution(int[] answers) {
	    	result[0][0] = 1;
	        result[1][0] = 2;
	        result[2][0] = 3;
	        
	    	for(int i=0; i< answers.length; i++) {
	    		answer[0] = i % 5 + 1;
	    		
	    		
	    		if(i%2 == 0) {
	    			answer[1] = 2;
	    		}else {
	    			switch((i/2)%4) {
	    			case 0: answer[1]= 1; break;
	    			case 1: answer[1]= 3; break;
	    			case 2: answer[1]= 4; break;
	    			case 3: answer[1]= 5; break;	    			
	    			}
	    		}
	    		
	    		switch((i/2)%5) {
	    		case 0: answer[2] = 3; break;
	    		case 1: answer[2] = 1; break;
	    		case 2: answer[2] = 2; break;
	    		case 3: answer[2] = 4; break;
	    		case 4: answer[2] = 5; break;
	    		}
	    		
	    		for(int j=0; j<3; j++) {
		    		if(answers[i] == answer[j]) {
		    			result[j][1]++;
		    		}
		    	}
	    	}
	    	
	    	Arrays.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o2[1], o1[1]);
				}
			});
	    	
	    	int cnt = 1;
	    	for(int i=0; i<2; i++) {
	    		if(result[i][1] != result[i+1][1]) {
	    			break;
	    		}
	    		cnt++;
	    	}
	    	
	    	int[] arr = new int[cnt];
	    	for(int i=0; i<arr.length; i++) {
	    		arr[i] = result[i][0];
	    	}
	    	
	    	System.out.println(Arrays.toString(arr));
	    	
	    	return arr;
	    }
	    
	    
	    
	}
	/*****************************************/
}
