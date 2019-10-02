package baekjoon;

import java.util.Scanner;

public class Main_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		int[] D = new int[N];
		int[] memo = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
			D[i] = 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(input[i]>input[j]) {
					if(D[i]<(D[j]+1)) {
						memo[i] = j;
						D[i] = D[j]+1;
					}
				}
			}
		}
		
		int max=0;
		int maxIdx=-1;
		for(int i=0; i<N; i++) {
			if(max<D[i]) {
				max = D[i];
				maxIdx=i;
			}
		}
		
		System.out.println(max);
		int[] sol = new int[max];
		int so = max-1;
		int idx = maxIdx;
		
		while(so>=0) {
			sol[so--] = input[idx];
			idx = memo[idx];
		}
		
		for(int i=0; i<max; i++) {
			System.out.print(sol[i]+" ");
		}
		
		
	}
}
