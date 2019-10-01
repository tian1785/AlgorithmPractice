package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	static int H, Answer, N;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		
		H = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>H) H = map[i][j];
			}
		}
		
		for(int i=0; i<H; i++) {
			int temp = safe(i);
			if(temp>Answer) Answer = temp;
		}
		
		System.out.println(Answer);
	}
	private static int safe(int height) {
		for(int i=0; i<N; i++ ) {
			for(int j=0; j<N; j++) {
				if(map[i][j] <=height) {
					map[i][j] = 0;
				}
			}
		}
		visited = new boolean[N][N];
		int count=0;
		for(int i=0; i<N; i++ ) {
			for(int j=0; j<N; j++) {
				if(map[i][j]>0 && !visited[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}
		
		return count;
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		visited[r][c] = true;
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]>0 && !visited[nr][nc] ) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
}
