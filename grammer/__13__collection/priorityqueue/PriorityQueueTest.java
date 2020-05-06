/**
 * 우선순위 큐는 우선순위를 비교해야 되기 때문에
 * 객체의 comparable 인터페이스가 구현되어야 한다. 
 * 
 * 
 */

package __13__collection.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Point> qPoints = new PriorityQueue<Point>();
		qPoints.offer(new Point(1,5));
		qPoints.offer(new Point(4,9)); /* 우선순위를 비교해야 하는데 그 기준이 없어서 에러 메세지 */
		qPoints.offer(new Point(3,2));
		qPoints.offer(new Point(8,8));
		qPoints.offer(new Point(7,3));
		qPoints.offer(new Point(2,0));
		qPoints.offer(new Point(3,2));
		
		System.out.println(qPoints.size());
		System.out.println(qPoints.poll());
		Iterator<Point> itr = qPoints.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
