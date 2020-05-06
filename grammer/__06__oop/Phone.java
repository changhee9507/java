package __06__oop;

public class Phone extends Computer {

	int screenSize = 7;

	boolean power = false;

	public void powerOff() {
		power = false;
		System.out.println("Phone is powered off!");
	}

	public void powerOn() {
		power = true;
		System.out.println("Phone is powered on!");
	}
	
	public void music() {
		System.out.println("pop is playing");
	}
}
