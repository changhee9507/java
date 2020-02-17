package API.Collections.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import API.Collections.set.Point;

public class ListArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		al.add("Cass");
		al.add("IsBack");
		al.add("Cass");
		al.add("Terra");
		al.add("Jangsu");
		
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		ArrayList<Point> alPoint = new ArrayList<Point>();
		alPoint.add(new Point(1,3));
		alPoint.add(new Point(5,7));
		alPoint.add(new Point(3,6));
		alPoint.add(new Point(2,9));
		alPoint.add(new Point(1,3));
		alPoint.add(new Point(7,1));
		alPoint.add(new Point(2,5));
		
		Iterator<Point> itrPoint = alPoint.iterator();
		while(itrPoint.hasNext()) {
			System.out.println(itrPoint.next());
		}
		
	}

}
