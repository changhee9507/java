package Interface2;

public class InterfaceA {
	void mA() {};
	
	default void mD() {
		System.out.println("InterfaceA = mD()");
	}
}
