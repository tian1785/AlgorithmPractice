package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //롤케이크의 길이
		int N = sc.nextInt(); //방청객 수
		
		int[] arr = new int[L+1]; //롤케이크
		
		int answer1 = 0;
		int max = 0;
		for(int i=1; i<=N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			if(to-from+1 >max) {
				max = to-from+1;
				answer1 = i;
			}
			
			for(int j=from; j<=to; j++) {
				if(arr[j]==0) {
					arr[j] = i;
				}
			}
		}
		
		int[] numbers = new int[N+1]; //counting할 배열
		
		max = 0;
		int answer2 = 0;
		for(int i=1; i<=L; i++) {
			if(arr[i]==0) continue;
			numbers[arr[i]]++;
			if(numbers[arr[i]]>max) {
				max = numbers[arr[i]];
				answer2 = arr[i];
			}
			
		}
		
		System.out.println(answer1);
		System.out.println(answer2);
	}

}
