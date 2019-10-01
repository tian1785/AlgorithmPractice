package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen_배열1개 {

	static int Answer,N;
	static int col[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			col = new int[N];
			
			find(0);
			System.out.println("#"+test+" "+Answer);
		}
	}
	
	
	private static void find(int idx) {
		
		if(idx == N) {
			Answer++;
			return;
		}
		
		
		for(int j=0; j<N; j++) {
			if(!check(j, idx)) continue;
			col[idx] = j;
			find(idx+1);
		}
	}
	
	private static boolean check(int j, int idx) {
		for(int i=0; i<idx; i++) {
			if(col[i] == j || Math.abs(col[i]-j) == Math.abs(i-idx)) return false;
		}
		
		return true;
	}
	


}
