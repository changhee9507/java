/**
 * 일정한 규칙에 따라서 줄을 서서 사탕을 받아가는 상황을 
 * 시뮬레이션하는 프로그램
 * 
 * @author Changhee Yoon
 * 
 */

package simulation;

import java.util.LinkedList;
import java.util.Queue;

class Person{
	
	public int number;
	public int count = 1;
	
	Person(int num){
		this.number = num;
	
	}

}

public class WhoTakeLastCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int totalNum = 35;
		int count = 1;
		Person temp;
		
		Queue<Person> line = new LinkedList<Person>();  
		line.offer(new Person(count));
		
		while(totalNum > 0) {
		
			temp = line.poll();
			totalNum = totalNum - temp.count;
			temp.count++;
			
			System.out.println("받는사람 번호 : " + temp.number );
			System.out.println("받는 갯수 : " + (temp.count-1));
			System.out.println("남은 마이쮸 갯수 : " + totalNum);
			System.out.println();
			
			line.offer(temp);
			line.offer(new Person(++count));
			
		}
			
	}

}

