package __004__programmers.set1;

import java.util.Arrays;
import java.util.Comparator;

public class p2 {

	public static void main(String[] args) {
		String[] ip_addrs = { "7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0" };
		String[] langs = { "C++", "Java", "C#", "C#", "C", "Python3"};
		int[] scores = {314, 225, 45, 0, 155, 400};

		Solution s = new Solution();

		System.out.println(s.solution(ip_addrs, langs, scores));
	}

///////////////////////////////////////////////////////////////
	static class Solution {

		public int solution(String[] ip_addrs, String[] langs, int[] scores) {
			int size = ip_addrs.length; /* 시험 참여 학생 수 */
			int cheating = 0; /* 부정행위 학생의 수 */
			Student[] students = new Student[size+1];

			/* 객체 형식 저장 */
			for (int i = 0; i < size; i++) {
				String lang = (langs[i].charAt(0) == 'C')? "C" : langs[i];
				students[i] = new Student(ip_addrs[i], lang, scores[i]);
			}
			students[size] = new Student("~~~", "~~~", Integer.MIN_VALUE);

			/* ip 기준 정렬 */
			Arrays.sort(students, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if(o1.ip.equals(o2.ip)) {
						return o1.lang.compareTo(o2.lang);
					}else {
						return o1.ip.compareTo(o2.ip);						
					}
				}
			});

			/* 부정 행위자 검사 */
			int cnt = 1;
			for (int i = 1; i < size+1; i++) {
				System.out.println(">>" + i + " " + cnt);

				if (students[i].ip.equals(students[i - 1].ip)) {
					cnt++;
				} else {
					if (cnt >= 4) {
						cheating += cnt;
						cnt = 1;
						System.out.println(">>>4");
					} else if (cnt == 3) {
						if (students[i - 1].lang.equals(students[i - 2].lang)
								&& students[i - 2].lang.equals(students[i - 3].lang)) {
							cheating += cnt;
							System.out.println(">>>3");
							cnt = 1;
						}else {
							cnt = 1;
						}
					} else if (cnt == 2) {
						if (students[i - 1].lang.equals(students[i - 2].lang)
								&& students[i - 1].score == students[i - 2].score) {
							cheating += cnt;
							System.out.println(">>>2");
							cnt = 1;
						} else {
							cnt = 1;
						}
					} else {
						cnt = 1;
					}
				}
			}

			System.out.println(Arrays.toString(students));
			return size - cheating;
		}

		class Student {
			String ip;
			String lang;
			int score;

			public Student(String ip, String lang, int score) {
				this.ip = ip;
				this.lang = lang;
				this.score = score;
			}

			@Override
			public String toString() {
				return "Student [ip=" + ip + ", lang=" + lang + ", score=" + score + "]\n";
			}

		}
	}
///////////////////////////////////////////////////////////////
}
