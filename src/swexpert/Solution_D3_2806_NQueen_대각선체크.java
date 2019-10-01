package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen_대각선체크 {

	static int Answer,N;
	static boolean[] col, slash, bSlash;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			col = new boolean[N+1];
			slash = new boolean[2*N+1];
			bSlash = new boolean[2*N];
			
			go(1);
			System.out.println("#"+test+" "+Answer);
		}
	}
	
	
	private static void go(int row) {
		
		if(row == N+1) {
			Answer++;
			return;
		}
		
		
		for(int c=1; c<=N; c++) {
			if(!col[c] && !slash[row+c] && !bSlash[row-c+N]) {
				col[c] = slash[row+c] = bSlash[row-c+N] = true;
				go(row+1);
				col[c] = slash[row+c] = bSlash[row-c+N] = false;
			}
		}
	}
}
