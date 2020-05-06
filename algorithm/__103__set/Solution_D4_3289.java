package __103__set;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_3289 {

	static int[] parents;
	static StringBuilder sb;
	static int eleNum;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();

		for (int testCase = 1; testCase <= TESTCASE; testCase++) {
			eleNum = scan.nextInt();
			parents = new int[eleNum + 1];
			Arrays.fill(parents, -1);
			int opNum = scan.nextInt();
			sb = new StringBuilder();

			for (int j = 1; j <= opNum; j++) {
				int op = scan.nextInt();
				int ele1 = scan.nextInt();
				int ele2 = scan.nextInt();

				int rep1 = getRepresentor(ele1);
				int rep2 = getRepresentor(ele2);

				if (op == 0) { /* union */
					if(rep1 == rep2) continue;
					else {
						parents[rep2] = rep1;
					}
				} else { /* check whether they are in same set */

					if (rep1 == rep2) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}

				System.out.println(Arrays.toString(parents));
			}
			System.out.printf("#%d %s\n", testCase, sb.toString());
		}

	}

	static int getRepresentor(int ele) {
		if (parents[ele] < 0)
			return ele;
		else {
			return parents[ele] = getRepresentor(parents[ele]);
		}
	}
}