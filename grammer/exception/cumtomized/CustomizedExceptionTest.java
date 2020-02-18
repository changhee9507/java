package exception.cumtomized;

public class CustomizedExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomizedExceptionUse ceu = new CustomizedExceptionUse();
		try {
			ceu.m(10);
		} catch (CustomizedException e) {
			e.showDetails();
			e.printStackTrace();
	 	}                     
 	}                                      
 }                       
                                                                        