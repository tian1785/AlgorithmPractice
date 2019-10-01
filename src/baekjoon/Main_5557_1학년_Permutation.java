package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
11
8 3 2 4 8 7 2 4 0 8 8

 */
public class Main_5557_1학년_Permutation {

	static int lastNumber, N, Answer;
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N-1; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		lastNumber = Integer.parseInt(st.nextToken());
		
		permutation(1, numbers[0]);
		
		System.out.println(Answer);
		
	}
	private static void permutation(int index, int answer) {
		if(answer<0 || answer>20) return;
		if(index==N-1) {
			if(answer == lastNumber) {
				Answer++;
			}
			return;
		}
		
			
		permutation(index+1, answer+numbers[index]);
		permutation(index+1, answer-numbers[index]);
		

/*		int k = answer+numbers[index];
		if(k>=0 && k<=20)
			permutation(index+1, k);
		
		k = answer-numbers[index];
		if(k>=0 && k<=20)
			permutation(index+1, k);*/
	}

}
