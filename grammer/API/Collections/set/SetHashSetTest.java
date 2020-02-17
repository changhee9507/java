package API.Collections.set;

import java.util.HashSet;
import java.util.Iterator;

public class SetHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("Cass");
		hs.add("IsBack");
		hs.add("Cass");
		hs.add("Terra");
		hs.add("Jangsu");
		
		Iterator<String> itr = hs.iterator();
		while(itr.hasNext()) { /* 중복 허용 x, 순서x */
			System.out.println(itr.next());
		}
		
		HashSet<Point> hsPoint = new HashSet<Point>();
		hsPoint.add(new Point(1,3));
		hsPoint.add(new Point(5,7));
		hsPoint.add(new Point(3,6));
		hsPoint.add(new Point(2,9));
		hsPoint.add(new Point(1,3));
		hsPoint.add(new Point(7,1));
		hsPoint.add(new Point(2,5));
		
		Iterator<Point> itrPoint = hsPoint.iterator();
		while(itrPoint.hasNext()) {
			System.out.println(itrPoint.next());
		}
		
 	}
}