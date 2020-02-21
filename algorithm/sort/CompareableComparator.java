/**
 * Comparable은 interface로 CompareTo라는 함수를 구현하도록 만들어서
 * 객체 포인터 자체로는 비교 불가능한 것을 개발자의 의도제대로 비교할 수 있게 만들어준다. 
 * # 주의사항 : comparable은 타입을 설정해줘야한다 <>
 * 
 * 
 * Comporator는 Comparable의 함수보다 높은 우선순위를 가지며
 * 클래스를 만들고 객체를 생성하는 불편함 없이 바로 객체를 만들기 위해서 사용되는 anonymous클래스
 * # 사용할 때는 함수 안에 파라미터로 들어간다. ex) Arrays.sort( , new Comporator<타입> ....)
 * 
 * 
 */
package sort;

import java.util.Arrays;
import java.util.Comparator;

public class CompareableComparator {

			/* 기존의 비교능력이 없는 객체사이의 비교 능력을 만들어줌 */
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
		      public int compareTo(Student o) { /* 오름차순으로 설정 */
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
		            //return o2.intValue()-o1.intValue(); // 양수와 음수가 섞일때 문제가 생긴다.
		            // return o2.compareTo(o1);
		        	return o1 - o2; /* 오름차순 */
		        	//return o2 - o1; /* 내림차순 */
		         }
		      } );
    
		      int[][] testArray = new int[][] {
		    	  {7,2},
		    	  {3,4},
		    	  {8,9},
		    	  {11,6},
		    	  {1,2}
		      };
		      
		      Arrays.sort(testArray, new Comparator<int[]>() { /* 비교되는 원소는 1차원 배열 */
		    	 
		    	  @Override
		    	  public int compare(int[] o1, int[] o2) {
		    		  
		    		return o1[0] - o2[0];  
		    		  
		    	  }
		      });
		      
		      for(int i =0; i<5; i++) {
		    	  System.out.println(Arrays.toString(testArray[i]));
		      }
		      
		      
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
