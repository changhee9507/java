package exception.cumtomized;

public class CustomizedException extends Exception {

	public CustomizedException() {
		super("사용자 지정 예외입니다.");
	}
	
	public void showDetails() {
		
	}
}
