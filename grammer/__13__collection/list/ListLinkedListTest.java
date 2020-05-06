package __13__collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import __13__collection.set.Point;

public class ListLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Cass");
		ll.add("IsBack");
		ll.add("Cass");
		ll.add("Terra");
		ll.add("Jangsu");
		
		Iterator<String> itr = ll.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		LinkedList<Point> llPoint = new LinkedList<Point>();
		llPoint.add(new Point(1,3));
		llPoint.add(new Point(5,7));
		llPoint.add(new Point(3,6));
		llPoint.add(new Point(2,9));
		llPoint.add(new Point(1,3));
		llPoint.add(new Point(7,1));
		llPoint.add(new Point(2,5));
		
		Iterator<Point> itrPoint = llPoint.iterator();
		while(itrPoint.hasNext()) {
			System.out.println(itrPoint.next());
		}
		
		
		
	}

}
