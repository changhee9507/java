package __13__collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> productPrice = new HashMap<>();
		productPrice.put("TV", 220);
		productPrice.put("Refrigerator", 170);
		productPrice.put("Desk", 50);
		productPrice.put("Computer", 270);
		productPrice.put("Desk", 20);
		
		System.out.println(productPrice.size());
		
		int price = productPrice.get("Computer");
		System.out.println(price);
		
		
		Set<String> keys = productPrice.keySet();
		
		for(String key : keys) {
			System.out.println(key);
		}
		
		if(productPrice.containsKey("Desk")) {
			System.out.println("Desk exist!!");
		}
	}

}
