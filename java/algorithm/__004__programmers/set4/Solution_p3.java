/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution_p3 {

	public static void main(String[] args) {

		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };

		System.out.println(Arrays.toString(solution(gems)));
	}

	static String[] staticGems;
	static int minNum = Integer.MAX_VALUE;
	static String minGem = null;
	static int gemKindNum = 0;

	public static int[] solution(String[] gems) {
		HashMap<String, Integer> gemsMap = new HashMap<>();
		staticGems = gems;

		for (int i = 0; i < gems.length; i++) {
			if (gemsMap.containsKey(gems[i])) {
				gemsMap.put(gems[i], gemsMap.get(gems[i]) + 1);
			} else {
				gemsMap.put(gems[i], 1);
			}
		}

		gemKindNum = gemsMap.size();
		/* 종류가 하나라면 1,1, 리턴 */
		if (gemKindNum == 1) {
			return new int[] { 1, 1 };
		}

		/* 가장 숫자가 작은 보물과 그 수를 저장 */
		Set<String> keySet = gemsMap.keySet();
		for (String gem : keySet) {
			if (gemsMap.get(gem) < minNum) {
				minNum = gemsMap.get(gem);
				minGem = gem;
			}
		}

		System.out.println(gemsMap.toString() + " " + gemsMap.size());
		System.out.println(minNum + " " + minGem);

		LinkedList<Integer> loc = new LinkedList<>();

		for (int i = 0; i < gems.length; i++) {
			if (gems[i].equals(minGem)) {
				loc.addLast(i);
			}
		}

		while (!loc.isEmpty()) {
	
			int tmp = loc.removeFirst();
			leftCheck(tmp);
			rightCheck(tmp);
			
		}
		return answer;
	}

	static int[] answer = new int[2];
	static HashSet<String> checkSet = new HashSet<String>();
	static int minLength = Integer.MAX_VALUE;

	static void leftCheck(int end) {
		System.out.println("leftCheck from " + end);
		checkSet.clear();
		checkSet.add(minGem);
		int dis = 1;
		int start = end - 1;

		while (start >= 0) {
			checkSet.add(staticGems[start]);
			if (checkSet.size() == gemKindNum && dis < minLength) {
				answer[0] = start;
				answer[1] = end;
			}
			start--;
			dis++;
		}
	}

	static void rightCheck(int start) {
		
		System.out.println("rightCheck from " + start);
		checkSet.clear();
		checkSet.add(minGem);
		int dis = 1;
		int end = start+1;

		while (end < staticGems.length) {
			checkSet.add(staticGems[end]);
			if (checkSet.size() == gemKindNum && dis < minLength) {
				answer[0] = start;
				answer[1] = end;
			}
			end++;
			dis++;
		}
	}
}