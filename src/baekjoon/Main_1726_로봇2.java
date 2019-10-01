package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1726_로봇2 {

	static int Count;
	static int destr;
	static int destc;
	static int destd;
	static int M,N;
	
	static boolean[][] isVisited;
	static int[][] map;
	static int[] direction = {0, 0, 2, 1, 3};	//동서남북
	static int[][] turned = {{0,1},{1,0},{0,-1},{-1,0}}; // 동남서북 (시계방향)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Count = 0;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+2][N+2];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int startr = Integer.parseInt(st.nextToken());
		int startc = Integer.parseInt(st.nextToken());
		int startd = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		destr = Integer.parseInt(st.nextToken());
		destc = Integer.parseInt(st.nextToken());
		destd = Integer.parseInt(st.nextToken());
		
		dfs(startr,startc, direction[startd]);
		System.out.println(Count);
			
	}
	
	private static void dfs(int r, int c, int direction) {
		if(r==destr && c==destc) {
			for(int i=0; i<4; i++) {
				if(destd==direction) {
					if(i==3) i=2;
					if(i==4) i=1;
					Count+= i;
					return;
				}
			}
		}
		int turn =0;
		
			for(int i=0; i<2; i++) {
				int nr = r + turned[(direction+i)%4][0];
				int nc = c + turned[(direction+i)%4][1];
				turn++;
				if(map[nr][nc]==0) {
					if(turn==3) turn=2;
					if(turn==4) turn=1;
					Count += turn; 
					
					for(int j=1; j<=3; j++) {
						int tempr = r + turned[(direction+i)%4][0]*j;
						int tempc = c + turned[(direction+i)%4][1]*j;
						
						if(nr>=0 && nr<M && nc>=0 && nc<N) {
							if(nr==destr && nc==destc) return;
							
							if(map[nr][nc]!=0) break; 
							
							nr=tempr;
							nc=tempc;
						}
					}
					Count++;
					dfs(nr, nc,(direction+i)%4);
				}
			}
		
	}
	
	
	

}
