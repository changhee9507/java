/**
 * 지금 이 시점에서만 잠깐 클래스의 특정 함수나 지역변수를 사용하고 싶은 경우
 */

package anonymous;

public class AnonymousClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonymousClass ac = new AnonymousClass();
		
		/* 객체가 잠깐 필요한 경우 이렇게 생성할 수 있다. */
		ac.callWrite(new AnonymousInterface() {
			@Override
			public void write() {
				System.out.println("anonymousClass - wirte()");
			}
		});
	}

}
