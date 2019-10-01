package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen {

	static int Answer,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			find(0,map);
			System.out.println("#"+test+" "+Answer);
		}
	}
	
	
	private static void find(int idx, int[][] arr) {
		
		if(idx == N) {
			Answer++;
			return;
		}
		
/*		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==0) {
					arr[i][j] = 2;
					find(idx+1, marking(arr, i, j));
				}
			}
		}*/
		for(int i=0; i<N; i++) {
			if(arr[idx][i]==0) {
				arr[idx][i] = 2;
				find(idx+1, marking(arr, idx, i));
			}
		}
	}
	
	private static int[][] marking(int[][] map, int r, int c) {
		int[][] direction = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,-1},{-1,1}};
		
		int[][] result = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<8; i++) {
			for(int j=1; j<=N; j++){
				int nr = r + direction[i][0]*j;
				int nc = c + direction[i][1]*j;
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(result[nr][nc] == 0) {
						result[nr][nc] = 1;
					}
				}else {
					break;
				}
			}
		}
		return result;
	}

}
