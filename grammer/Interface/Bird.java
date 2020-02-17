
package Interface;

public class Bird extends Animal implements Fly {
	private int wing;
	
	public int getWing() {
		return wing;
	}
	
	public void setWing(int wing) {
		this.wing = wing;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Bird Fly!");
	}
}
