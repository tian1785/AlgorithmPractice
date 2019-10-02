package swexpert;
import java.util.Scanner;

public class Solution_D4_4301_콩많이심기 {

	static int[][] map;
	static int[] dx = {-2,0,2,0};
	static int[] dy = {0,-2,0,2};
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test=1; test<=T; test++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int Answer = 0;
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) {
						map[i][j]=1;
						Answer++;
						marking(i,j);
					}
				}
			}
			
			System.out.println("#"+test+" "+Answer);
		}
			
	}
	
	private static void marking(int r, int c) {
		for(int d =0; d<4; d++) {
			int nr = r+dx[d];
			int nc = c+dy[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc]==0) {
					map[nr][nc] = 2; //마킹하기 사방
				}
			}
		}
	}
	
}
