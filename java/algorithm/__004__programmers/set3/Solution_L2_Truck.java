/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set3;

import java.util.LinkedList;

public class Solution_L2_Truck {

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		LinkedList<Truck> onBridge = new LinkedList<>();
		LinkedList<Truck> waitings = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			waitings.addLast(new Truck(truck_weights[i], bridge_length));
		}

		int time = 0;
		int capacity = weight;

		while (!onBridge.isEmpty() || !waitings.isEmpty()) {
			if (!onBridge.isEmpty() && onBridge.get(0).remain_length == 0) {
				capacity += onBridge.get(0).weight;
				onBridge.remove(0);
			}
			
			time++;
			
			if (!waitings.isEmpty() && capacity >= waitings.get(0).weight) {
				Truck thisTruck = waitings.removeFirst();
				onBridge.addLast(thisTruck);
				capacity -= thisTruck.weight;
			}

			for (Truck truck : onBridge) {
				truck.go();
			}

			//System.out.println("time " + time + " " + waitings.toString() + " " + onBridge.toString());
			
		}

		return time;
	}

	static class Truck {
		int weight;
		int remain_length;

		public Truck(int w, int r) {
			this.weight = w;
			this.remain_length = r;
		}

		public void go() {
			remain_length--;
		}

		@Override
		public String toString() {
			return "(" + weight + " " + remain_length + ")";
		}

		
	}

}