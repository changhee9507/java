package Interface;

public class Duck extends Animal implements Run,Fly { /* interface 구현은 여러개가 가능 */

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Duck Fly!");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Duck Run!");
	}

}
