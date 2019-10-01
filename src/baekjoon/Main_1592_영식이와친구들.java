package baekjoon;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		arr[0]=1;
		
		int current = 0;
		int count =0;
		while(true) {
			

			if(arr[current]%2==1) { //홀수번일 때
				current = (current+L)%N;
				arr[current]++;
			}else {
				current = (current+N-L)%N;
				arr[current]++;
			}
			
			count++;
			
			if(arr[current] == M) break;
			
		}
		
		
		System.out.println(count);
	}

}
