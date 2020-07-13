package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14722_우유도시 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][][] dp = new int[3][n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0][0] = map[0][0]==0?1:0;
		
		for(int i=1; i<n; i++){
			int milk = map[i][0];
			dp[0][i][0] = milk==0 ?dp[2][i-1][0]+1:dp[0][i-1][0];
			dp[1][i][0] = milk==1&&dp[2][i][0]<dp[0][i][0] ?dp[0][i-1][0]+1:dp[1][i-1][0];
			dp[2][i][0] = milk==2&&dp[0][i][0]<dp[1][i][0] ?dp[1][i-1][0]+1:dp[2][i-1][0];
		}
		
		for(int i=1; i<n; i++){
			int milk = map[0][i];
			dp[0][0][i] = milk==0 ?dp[2][0][i-1]+1:dp[0][0][i-1];
			dp[1][0][i] = milk==1&&dp[2][0][i]<dp[0][0][i] ?dp[0][0][i-1]+1:dp[1][0][i-1];
			dp[2][0][i] = milk==2&&dp[0][0][i]<dp[1][0][i] ?dp[1][0][i-1]+1:dp[2][0][i-1];
		}
		
		for(int i=1; i<n; i++){
			for(int j=1; j<n; j++){
				int milk = map[i][j];
				
				dp[0][i][j] = milk==0 
						? Math.max(dp[2][i-1][j], dp[2][i][j-1])+1 
						: Math.max(dp[0][i-1][j], dp[0][i][j-1]);
				dp[1][i][j] = milk==1 && dp[2][i][j]<dp[0][i][j]
						? Math.max(dp[0][i-1][j], dp[0][i][j-1])+1 
						: Math.max(dp[1][i-1][j], dp[1][i][j-1]);
				dp[2][i][j] = milk==2 && dp[0][i][j]<dp[1][i][j]
						? Math.max(dp[1][i-1][j], dp[1][i][j-1])+1 
						: Math.max(dp[2][i-1][j], dp[2][i][j-1]);
			}
		}
		
		System.out.println(Math.max(dp[0][n-1][n-1], Math.max(dp[1][n-1][n-1], dp[2][n-1][n-1])));
	}

}
