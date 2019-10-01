package swexpert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_dfs {

	static int N;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int maxNum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
//					int temp = dfs(i, j, map[i][j]);
//					if(temp>max) {
//						max = temp;
//						maxNum = map[i][j];
//					}else if(temp==max) {
//						if(map[i][j]<maxNum) {
//							maxNum = map[i][j];
//						}
//					}
				}
			}
			
			System.out.println("#"+test+" "+maxNum+" "+max);
		}
	}
	
	
	
	private static int dfs(int r, int c) {
		
		
		for(int i=0; i<4; i++) {
			int nr = r +dx[i];
			int nc = c +dy[i];
			
			if(map[r][c]+1==map[r][c]) {
				
			}
		}
		
		return 0;
	}

}
