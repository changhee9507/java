package hwjava08_서울_7반_윤창희;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class hwjava08_서울_7반_윤창희 {

public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		int[][] matter=new int[n][2];
		String[] data=null;
		
		for(int i=0;i<n;i++){
			data=br.readLine().split(" ");
			matter[i][0]=Integer.parseInt(data[0]);
			matter[i][1]=Integer.parseInt(data[1]);	
		}
		
		Arrays.sort(matter, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		} );
		
		//처리
		int cnt=0;
		int max=0;
		for(int i=0;i<n;i++){
			
			if(i==0){
				max=matter[i][1];
				cnt++;
			}
			if(matter[i][0]>max){
				cnt++;
				max=matter[i][1];
			}
		}

		System.out.println(cnt);
	}
}
