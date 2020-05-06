package __13__collection.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> qInt = new LinkedList<Integer>();
		qInt.offer(1);
		qInt.offer(4);
		qInt.offer(7);
		qInt.offer(8);
		qInt.offer(5);
		qInt.offer(3);
		qInt.offer(2);
		qInt.offer(9);
		
		Iterator<Integer> itr = qInt.iterator();
		itr.next();
		itr.remove();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		
		System.out.println(qInt.poll());
	}
}
