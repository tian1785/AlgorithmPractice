package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

	static boolean visited[][];
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 10;
		int onenumber = 0;
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) onenumber++;
			}
		}
		
		int[] numbers = {0,5,5,5,5,5};
		
		int Answer = 0;
		
		if(onenumber!=0) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
//						dfs(i--, j--); //바뀌지 않았을 경우 다시 탐색을 위해
					}
				}
			}
		}
		
		System.out.println(Answer);
	}
	
	static int[] dx = {0,1,0,-1}; // 동 남 서 북
	static int[] dy = {1,0,-1,0};
	static boolean isFind = false;
	private static void dfs(int r, int c, int d) {
		if(d==5) {
			return;
		}
		int count=0;
		while(true) { //제일 끝까지 탐색
			int nr = r+dx[d];
			int nc = c+dy[d];
			
			if(nr>=N || nc>=N || nr<0 || nc<0 || map[nr][nc]==0) break;
			
			r = nr;
			c = nc;
			count++;
		}
		
		
		if(!isFind) {
			for(int i=0; i<count; i++) {
				int nr = r-dx[d];
				int nc = c-dy[d];
				dfs(nr, nc, d+1);
			}
		}
		
	}
	
	private static void marking(int r, int c, int num) {
		
		for(int i=r; i<r+num; i++) {
			for(int j=c; j<c+num; j++) {
				map[i][j] = 0;
			}
		}
	}

}
