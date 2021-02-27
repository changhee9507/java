package __15__lang.object;

public class javaLangClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaLangClass javalang = new JavaLangClass();
		System.out.println(javalang);
		
		JavaLangClass javalang2 = new JavaLangClass();
		if(javalang == javalang2) {
			System.out.println("javalang == javalang2 : true");
		}else {
			System.out.println("javalang == javalang2 : false");
		}
		
		if(javalang.equals(javalang2)) {
			System.out.println("javalang == javalang2 : true");
		}else {
			System.out.println("javalang == javalang2 : false");
		}
		
		
	}

}
