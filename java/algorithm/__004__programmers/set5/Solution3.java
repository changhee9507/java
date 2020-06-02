/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set5;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution3 {

	public static void main(String[] args) {

		int total_sp = 121;
		int[][] skills = { { 1, 2 }, { 1, 3 }, { 3, 6 }, { 3, 4 }, { 3, 5 } };

		System.out.println(Arrays.toString(solution(total_sp, skills)));
	}

	static LinkedList<Integer> answerList = new LinkedList<>();
	static Skill[] toAccess;
	
	public static int[] solution(int total_sp, int[][] skills) {
		
		toAccess = new Skill[skills.length + 2];
		
		for(int i=0; i<skills.length; i++) {
			int higherSkill = skills[i][0];
			int lowerSkill = skills[i][1];
			
			/* 스킬이 없는 상황이면 생성 */
			if(toAccess[higherSkill] == null) {
				
				toAccess[higherSkill] = new Skill();
				toAccess[higherSkill].id = higherSkill;
				toAccess[higherSkill].level = 0;
			}
			
			/* 하위 스킬 추가 */
			toAccess[higherSkill].subSkillIndex.addLast(lowerSkill);
			
			toAccess[lowerSkill] = new Skill();
			toAccess[lowerSkill].higherSkillIndex = higherSkill;
			toAccess[lowerSkill].id = lowerSkill;
			toAccess[lowerSkill].level = toAccess[higherSkill].level + 1;
		}
		
		for(int i=1; i<toAccess.length; i++) {
			//System.out.println(toAccess[i]);
			
			if(toAccess[i].subSkillIndex.size() == 0) {
				toAccess[i].num = 1;
				
				Skill higher = toAccess[toAccess[i].higherSkillIndex];
				while(true) {
					higher.num += 1;
					if(higher.higherSkillIndex != -1) {
						higher = toAccess[higher.higherSkillIndex];
					}else {
						break;
					}
				}
			}
		}
		
		int totalNum = 0;
		
		for(int i=1; i<toAccess.length; i++) {
			totalNum += toAccess[i].num;
			//System.out.println(totalNum);
			
		}
		
		int pointForNum = total_sp/ totalNum;
		
		for(int i=1; i<toAccess.length; i++) {
			toAccess[i].point = toAccess[i].num * pointForNum;
			//System.out.println(toAccess[i]);
		}
		
		answerList.addLast(toAccess[skills[0][0]].point);
		save(toAccess[skills[0][0]]);
		
		//System.out.println(answerList);
		int[] answer = new int[answerList.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
	
	static void save(Skill s) {
		for(int i : s.subSkillIndex) {
			answerList.addLast(toAccess[i].point);
		}
		for(int i : s.subSkillIndex) {
			save(toAccess[i]);
		}
	}
	
	static class Skill{
		public int id;
		public int level;
		public int point;
		public LinkedList<Integer> subSkillIndex;
		public int higherSkillIndex;
		public int num;
		
		public Skill() {
			subSkillIndex = new LinkedList<>();
			higherSkillIndex = -1;
		}

		@Override
		public String toString() {
			return "Skill [id=" + id + ", level=" + level + ", point=" + point + ", higherSkillIndex="
					+ higherSkillIndex + ", num=" + num + "]";
		}

		
		
	}
}