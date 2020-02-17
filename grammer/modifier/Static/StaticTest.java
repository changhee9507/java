package modifier.Static;

public class StaticTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StaticClass.MIN_NUM); /* 객체 생성없이 접근 가능 */
		//System.out.println(StaticClass.MAX_NUM); /* static이 아니라서 접근 불가 */
	
		StaticClass.method1(); /* static method라서 객체 생성없이 호출 가능 */
		//StaticClass.method2(); /* 접근 불가 */
	}
}
