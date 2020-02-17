package Interface;

public class Dog extends Animal implements Run {
	
	private int leg;
	
	public int getLeg() {
		return leg;
	}
	
	public void setLeg(int leg) {
		this.leg = leg;
	}

	@Override
	public void run() { /* interface에 저장된 함수를 재정의 */
		// TODO Auto-generated method stub
		System.out.println("Dog run!");
	}
}
