package exception.runtime;

public class ThrowRuntimeClass {

		/*public  void method() {
			throw new IOException();
		}*/

		public static void main(String[] args) {
			try {
				throw new NullPointerException();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("catch block!!");
			}finally {
				System.out.println("finally block!!");
			}
		}
		
}
