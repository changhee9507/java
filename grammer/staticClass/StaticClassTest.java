package staticClass;

public class StaticClassTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(StaticOuterClass.StaticClass.MAX_NUM); /* 접근 불가 */
		System.out.println(StaticOuterClass.StaticClass.STATIC_MAX_NUM); /* 접근 가능 */
		StaticOuterClass.StaticClass sc = new StaticOuterClass.StaticClass();
		System.out.println(sc.MAX_NUM);
	}
	
	
}
