package etc;

import java.util.Scanner;

public class SumOdd {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		final int TESTCASE = scanner.nextInt();

		for(int test_case = 1; test_case <= TESTCASE; test_case++)
		{
            int sum=0;
            int input=0;
			for(int i =0; i<10; i++){
                input = scanner.nextInt();
                if(input %2 ==1){
                	sum += input;
                }
            }
            
            System.out.printf("#%d %d\n", test_case, sum);
            
		}

	}

}
