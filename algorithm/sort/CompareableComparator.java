/**
 * Comporator이 우선 순위가 높다.
 * 
 * Comparable의 compareTo는 어떤 객체 자체가 비교를 가능하도록 만들고
 * Comporator은 상황에 맞춰서 비교를 한다.
 * 
 */
package sort;

import java.util.Arrays;
import java.util.Comparator;

public class CompareableComparator {

		   static class Student implements Comparable<Student>{
		      int no,score;

		      public Student(int no, int score) {
		         super();
		         this.no = no;
		         this.score = score;
		      }

		      @Override
		      public String toString() {
		         return "Student [no=" + no + ", score=" + score + "]";
		      }
		      @Override
		      public int compareTo(Student o) {
		         return this.no - o.no;
		      }
		      
		   }
	
		   
		   public static void main(String[] args) {
		      int[] arr = new int[] {4,3,7,9,10};
		      System.out.println("초기 배열 출력");
		      System.out.println(Arrays.toString(arr));
		      Arrays.sort(arr);
		      
		      System.out.println("Arrays.sort 이후 출력");
		      System.out.println(Arrays.toString(arr));
		      
		      
		      Integer[] arr2 = new Integer[] {new Integer(4),3,7,9,10};
		      System.out.println("Integer 타입 원소 배열 출력");
		      System.out.println(Arrays.toString(arr2));
		      /* Arrays.sort(arr2);*/ // 사용가능 
		     
		      
		      /* 원소의 타이비 comparator에 들어간다. */
		      Arrays.sort(arr2, new Comparator<Integer>() {
		         @Override
		         public int compare(Integer o1, Integer o2) {
		           /* return o2.intValue()-o1.intValue();*/ // 양수와 음수가 섞일때 문제가 생긴다.
		            return o2.compareTo(o1);
		         }
		      } );
		      System.out.println(Arrays.toString(arr2));
		      
		      
		      
		      System.out.println("2차 배열의 정렬, 첫 원소 기준");
		      int[][] arr3 = new int[][]{{1,10},{3,50}, {8,50},{2,80},{4,10}};
		      
		      Arrays.sort(arr3, new Comparator<int[]>() {

		         @Override
		         public int compare(int[] o1, int[] o2) {
		            return o1[0] - o2[0];
		         }
		      });       
		      
		      
		      for (int[] ar : arr3) {
		         System.out.println(Arrays.toString(ar));
		      }
		      
		      
		      
		      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>.2.");
		      Arrays.sort(arr3, new Comparator<int[]>() {
		         
		         @Override
		         public int compare(int[] o1, int[] o2) {
		            int result = o1[1] - o2[1];
		            if(result==0) {
		               result = o1[0] - o2[0];
		            }
		            return result;
		         }
		      });
		      for (int[] ar : arr3) {
		         System.out.println(Arrays.toString(ar));
		      }
		      
		      Student[] arr4 = new Student[] {
		         new Student(1, 10),   
		         new Student(3, 50),   
		         new Student(2, 80),   
		         new Student(4, 10)   
		      };
		      
		      System.out.println("=========================");
//		      Arrays.sort(arr4);
		      Arrays.sort(arr4, new Comparator<Student>() {

		         @Override
		         public int compare(Student o1, Student o2) {
		            return o2.score - o1.score;
		         }
		      });
		      for (Student student : arr4) {
		         System.out.println(student);
		      }
		   }

}
