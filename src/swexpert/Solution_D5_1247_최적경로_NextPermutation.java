package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_NextPermutation {

	static int N;
	static int[] number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/ws/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine()); //고객 수
			
			number = new int[N];
			for(int i=0; i<N; i++) {
				number[i] = i;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] company = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] home = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			int[][] customer = new int[N][];
			for(int i=0; i<N; i++) {
				customer[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			}
						
			int min = Integer.MAX_VALUE;
			
			do {
				int distance = 0, diff=0;
				int[] current = company;
				for(int i=0; i<N; i++) {
					diff = Math.abs(current[0] - customer[number[i]][0]) +Math.abs(current[1] - customer[number[i]][1]);
					distance += diff;
					current = customer[number[i]];
				}
				
				distance += Math.abs(current[0] - home[0]) +Math.abs(current[1] - home[1]);
				
				
				if(distance<min) {
					min = distance;
				}
				
			} while (nextPermutation());
			
			System.out.println("#"+test+" " + min);
		}
	}
	
	private static boolean nextPermutation() {
		int i = N-1;
		while(i>0 && number[i-1]>=number[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(number[i-1] >= number[j]) j--;
		
		swap(i-1,j);
		
		j = N-1;
		
		while(i<j){
			swap(i++,j--);
		}
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
}

