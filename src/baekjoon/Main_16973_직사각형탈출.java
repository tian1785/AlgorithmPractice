package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
	
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int N, M, W, H, fr, fc, Answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		fr = Integer.parseInt(st.nextToken());
		fc = Integer.parseInt(st.nextToken());
		Answer = -1;
		bfs(sr,sc);
		System.out.println(Answer);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {r,c,0});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if(current[0]==fr && current[1]==fc) {
				Answer = current[2];
				return;
			}
			
			
			for(int i=0; i<4; i++) {
				int nr = current[0]+ dx[i];
				int nc = current[1]+ dy[i];
				
				if(nr>0 && nr<=N && nc>0 && nc<=M &&nr+H-1<=N && nc+W-1<=M && !visited[nr][nc]) {
					if(check(nr,nc)) {
						queue.offer(new int[] {nr, nc, current[2]+1});
					}
					visited[nr][nc] = true;
				}
			}
			
		}
		
	}
	
	private static boolean check(int r, int c) {
		for(int i=r; i<r+H && i<=N; i++) {
			for(int j=c; j<c+W && j<=M; j++) {
				if(map[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}
}
