/**
 *  1. java.lang.Comparable<T> - 인터페이스이기 때문에 이것을 구현할 수 있는 class를 직접만들때 사용할 수 있다.
 *  	
 *  	wrapper 클래스들은 기본적으로 이것이 구현되어 있다.
 *  
 *  	int compareTo(T other)
 *  		양수가 리턴되면 바꿔야 된다는 의미가 되고 0이나 음수가 되면 그대로 둔다.
 *  		그래서 그냥 단순히 - 를 하면 오름차순이 된다.
 *  
 * 	2. java.util.Comparator<T> - 원래의 클래스를 수정할 수 없는 경우에 이것을 사용하면 된다.
 * 		 int compare(T o1, T o2)
 * 
 * 
 * 두 함수 모두 양수를 리턴하면 바꾸는 것이 실행되고 0이나 음수를 리턴하면 그대로 유지하는 것을 기준으로 동작한다. *
 * 
 * @author Changhee Yoon
 */

package Comparing;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableComparatorTest {

	static class Student implements Comparable<Student>{
		int id, score;
		public Student(int id, int score) {
			super();
			this.id = id;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			return this.id - o.id;
		}	
		@Override
		public String toString() {
			return "Student [no=" + id + ", score=" + score + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Student[] students = new Student[] {
				new Student(1,100),
				new Student(10,50),
				new Student(5,10)
		};
		
		Arrays.sort(students);
		for (Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("=================================");
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			}
		});
		for (Student student : students) {
			System.out.println(student);
		}		
		
	}

}












