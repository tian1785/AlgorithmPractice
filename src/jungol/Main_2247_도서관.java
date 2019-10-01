package jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2247_도서관 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] hour = new boolean[25];
		
		int[][] student = new int[N][2];
		
		for(int i=0; i<N; i++) {
			student[i][0] = sc.nextInt();
			student[i][1] = sc.nextInt();
		}
		
		Arrays.sort(student, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
			}
		}); //정렬
		
		int maxin =0, maxnot=0;
		int idx=0;

		int starthour = student[idx][0];
		for(int i=1; i<N; i++) {
			if(student[idx][1] < student[i][0]) {
				int temp = student[idx][1] - starthour;
				if(temp>maxin) maxin=temp;
				int temp2 = student[i][0] - student[idx][1];
				if(temp2>maxnot) maxnot=temp2;
				starthour = student[i][0];
				idx = i;
//				idx++;
			}else {
				if(student[idx][1]<=student[i][1]) idx = i;
			}
		}
		
		int temp = student[idx][1]-starthour;
		if(temp>maxin) maxin=temp;
		
		System.out.println(maxin +" "+ maxnot);
	}

}
