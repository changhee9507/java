/**
 * 조교의 성적 매기기
 * 
 * 요약 : 성적에 따라서 분류하고 k번째 학생의 성적을 출력
 * 
 * 메모 : comparator는 클래스, compare함수를 오버라이드
 * 
 * 		compare 함수는 int를 리턴하기 때문에 doulbe 값으로 비교하는 경우 적절한 값 및 형 변환이 필요하다
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_D2_1983 {

	public static class Student {
		public int id;

		public int midtermScore;
		public int finalScore;
		public int homeworkScore;
		public double totalScore;
		public String grade;

		Student(int id, int m, int f, int h) {
			this.id = id;
			this.midtermScore = m;
			this.finalScore = f;
			this.homeworkScore = h;
			this.totalScore = m * 0.35 + f * 0.45 + h * 0.2;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return id + " " + totalScore + " " + grade;
		}
	}

	public static String targetGrade;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());

		for (int testcase = 1; testcase <= TESTCASE; testcase++) {
			String[] tmp = br.readLine().split(" ");
			int studentNum = Integer.parseInt(tmp[0]);
			int targetStudent = Integer.parseInt(tmp[1]);

			Student[] students = new Student[studentNum];

			for (int i = 0; i < studentNum; i++) {
				tmp = br.readLine().split(" ");

				int midtermScore = Integer.parseInt(tmp[0]);
				int finalScore = Integer.parseInt(tmp[1]);
				int homeworkScore = Integer.parseInt(tmp[2]);

				students[i] = new Student(i + 1, midtermScore, finalScore, homeworkScore);
			}

			Arrays.sort(students, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {

					return (int)((o1.totalScore - o2.totalScore) * 1000); /* 오름차순, 0.001의 차이까지 잡아주기 위해서 1000 곱해줌 */
				}
			});

			for (int i = 0; i < studentNum; i++) {

				switch (i / (studentNum / 10)) {
				case 0:
					students[i].grade = "D0";
					break;
				case 1:
					students[i].grade = "C-";
					break;
				case 2:
					students[i].grade = "C0";
					break;
				case 3:
					students[i].grade = "C+";
					break;
				case 4:
					students[i].grade = "B-";
					break;
				case 5:
					students[i].grade = "B0";
					break;
				case 6:
					students[i].grade = "B+";
					break;
				case 7:
					students[i].grade = "A-";
					break;
				case 8:
					students[i].grade = "A0";
					break;
				case 9:
					students[i].grade = "A+";
					break;
				}

				if (students[i].id == targetStudent) {
					targetGrade = students[i].grade;
				}
			}
			/*
			 * for(int i=0; i<studentNum;i++) { System.out.println(students[i]); }
			 */
			
			System.out.printf("#%d %s\n", testcase, targetGrade);

		}

	}

}
