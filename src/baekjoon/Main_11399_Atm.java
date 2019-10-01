package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_Atm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int result = 0;
		int current = 0;
		for(int i=0; i<N; i++) {
			current += arr[i];
			result +=current;
		}
		
		System.out.println(result);
	}

}
