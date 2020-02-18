package modifier.Final;

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalClass fc1 = new FinalClass();
		System.out.println(fc1.FINAL_NUM);
		
		FinalClass fc2 = new FinalClass();
		// fc2.FINAL_NUM = 8888; /* 수정 불가능 */
		System.out.println(fc2.FINAL_NUM);
		
	}

}
