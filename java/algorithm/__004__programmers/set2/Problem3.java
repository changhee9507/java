package __004__programmers.set2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {

	static int maxLength = Integer.MIN_VALUE;
	static String input;

	public static void main(String[] args) {

		String road = "111011110011111011111100011111";
		int n = 3;

		System.out.println(solution(road, n));
	}

	static public int solution(String road, int n) {
		getMaxLength(road, n, 0, 0);
		return maxLength;
	}

	static public void getMaxLength(String input, int remain, int index, int preLength) {
		if (index == input.length() - 1) {

			if (maxLength < preLength) {
				maxLength = preLength;
			}

		} else {
			while (index != input.length() - 1) {
				if (input.charAt(index) == '1') {
					index++;
					preLength++;
				} else {
					if (remain > 0) {
						getMaxLength(input, remain - 1, index + 1, preLength + 1);
					}
					if (maxLength < preLength) {
						maxLength = preLength;
					}
					getMaxLength(input, remain, index + 1, 0);

					break;
				}
			}

			if (maxLength < preLength) {
				maxLength = preLength;
			}

		}

	}

}
