package API.Collections.notype;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Interface.Bird;
import Interface.Duck;
import Interface.Fly;

public class CollectionInterfaceTypeTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Fly> set = new HashSet<Fly>();
		Fly af1 = new Bird();
		Fly af2 = new Duck();
		set.add(af1);
		set.add(af2);
		
		Iterator<Fly> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().fly();
		}
		
		
	}

}
