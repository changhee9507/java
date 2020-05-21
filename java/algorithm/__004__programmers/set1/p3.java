package __004__programmers.set1;

import java.util.Arrays;
import java.util.Comparator;

public class p3 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		String[] registered_list = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
		String new_id = "ace15";
		System.out.println(s.solution(registered_list, new_id));
	}

///////////////////////////////////////////////////////////////
	static class Solution {
	    public String solution(String[] registered_list, String new_id) {
	    	Arrays.sort(registered_list);
	    	System.out.println(Arrays.toString(registered_list));
	    	boolean sameExist = false;
	    
	    	
	    	for(int i=0; i<	registered_list.length; i++) {
	    		int compare = new_id.compareTo(registered_list[i]);
	    		if( compare > 0) {
	    			continue;
	    		}else if( compare == 0) {
	    			int targetIndex= 0;
	    			for(int k=0; k<new_id.length(); k++) {
	    				if(new_id.charAt(k) >= '0' && new_id.charAt(k) <= '9') {
	    					targetIndex = k;
	    				}
	    			}
	    			
	    			String S = new_id.substring(0, targetIndex);
	    			int N = Integer.parseInt(new_id.substring(targetIndex));
	    		}else {
	    			break;
	    		}
	    	}
	    	
	    	if(!sameExist) {
	    		return new_id;
	    	}
	    	
	        String answer = "";
	        return answer;
	    }
	    
	}
		
///////////////////////////////////////////////////////////////
}
