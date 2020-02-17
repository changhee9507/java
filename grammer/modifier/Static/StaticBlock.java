/**
 * static {} 은 클래스가 클래스 area로 로드 될 때 실행된다. (main보다 먼저 실행 ) 
 * static 변수들 초기화 작업을 위해서 필요.
 * 
 * 
 * {} 는 오브젝트를 만들때 실행된다.
 * contructor이라는 함수보다 우선순위가 높고 위치도 자유롭다.
 */


package modifier.Static;

public class StaticBlock {
	
	static int testnum = 7;
	
	{ /* block */
		System.out.println("Initialization!");
	}

	StaticBlock(){	 /* contructor */
		System.out.println("Contructor!");
	}
	
	static { /* static block */
		System.out.println("Static Block!");
		System.out.println("Static number : " + testnum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main!");
		StaticBlock obj = new StaticBlock();
	}

}
