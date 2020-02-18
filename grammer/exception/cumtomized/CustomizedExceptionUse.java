package exception.cumtomized;

public class CustomizedExceptionUse {
	public void m(int value) throws CustomizedException{
		if(value < 0) throw new CustomizedException();
	}
}
