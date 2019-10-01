package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
11
8 3 2 4 8 7 2 4 0 8 8
*/
public class Main_5557_1학년 {

	static int lastNumber, N, Answer;
	static int[] numbers;
	static long[][] dp;
//	static LinkedList<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		dp = new long[101][21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine())-1;
		
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
//			list[i] = new LinkedList<Integer>();
		}
		lastNumber = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 21; j++) {
				dp[i][j]=-1;
			}
		}
		
		
		System.out.println(permutation(0, numbers[0]));
		
//		for (int i = 0; i < 101; i++) {
//			for (int j = 0; j < 21; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(Answer);
		
	}
	private static long permutation(int index, int answer) {
		if(answer<0 || answer>20) return 0;;
		if(index==N-1) {
			if(answer == lastNumber) {
				dp[index][answer] = 1;
			}else {
				dp[index][answer] = 0;
			}
			return dp[index][answer];
		}

		if(dp[index][answer] != -1) {
			return dp[index][answer];
		}
		
		long val = 0;
		
		val += permutation(index+1, answer+numbers[index+1]);
		val += permutation(index+1, answer-numbers[index+1]);
		
		return dp[index][answer] = val;
/*		if(!list[index].contains(answer)) {			
			list[index].add(answer);
			permutation(index+1, answer+numbers[index]);
			permutation(index+1, answer-numbers[index]);
		}else {
//			if() {
//				Answer++;
//			}
		}
*/		
		

	}

}
