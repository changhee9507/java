package __13__collection.stack;

import java.util.Iterator;
import java.util.Stack;

import __13__collection.set.Point;

public class ListStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> sInt = new Stack<Integer>();
		sInt.push(1);
		sInt.push(4);
		sInt.push(7);
		sInt.push(8);
		sInt.push(5);
		sInt.push(3);
		sInt.push(2);
		sInt.push(9);
		
		Iterator<Integer> itr = sInt.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
		System.out.println("---------------------------");
		System.out.println(sInt.pop());
		System.out.println("---------------------------");
		itr = sInt.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("---------------------------");
		System.out.println(sInt.search(5));
	}

}
