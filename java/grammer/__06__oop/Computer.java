package __06__oop;

public class Computer extends Device {
	
	int screenSize = 24;
	String battery = "";
	
	boolean power = false;
	
	public void powerOff() {
		power = false;
		System.out.println("Computer is powered off!");
	}
	
	public void powerOn() {
		power = true;
		System.out.println("Computer is powered on!");
	}

	@Override
	void batteryChange() {
		// TODO Auto-generated method stub
	}
	
	
}
