/**
 * 링크드 리스트는 큐와 스택 등으로 다양하게 활용 가능하다
 * 
 * @author Changhee Yoon
 */
package __13__collection.list;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		queueTest();
		
	}
	
	/* 링크드 리스트를 큐처럼 활용 
	 * 
	 * offer()은 뒤에서 큐에 삽입
	 * poll()은 앞에서 하나를 빼고 그 값을 리턴
	 * */
	static void queueTest() {
		
		LinkedList<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty() + " " + queue.size());
		queue.offer("hi");
		queue.offer("my");
		queue.offer("name");
		queue.offer("is");
		queue.offer("changhee");
		System.out.println(queue.isEmpty() + " " + queue.size());
		queue.poll();
		System.out.println(queue.isEmpty() + " " + queue.size());		
	}
}
