package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_bfs {
	static boolean[][] visited;
	static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int Answer;
		for(int test =1; test<=T; test++) {
			Answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[M][N];
			visited = new boolean[M][N];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] =1;
			}
			
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						Answer++;
						bfs(map,i,j);
					}
				}
			}
			System.out.println(Answer);
			
		}
	}

	private static void bfs(int[][] map, int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int rsize = map.length;
		int csize = map[0].length;
		
		queue.offer(new int[] {r,c});
		visited[r][c] =true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = current[0]+direction[i][0];
				int nc = current[1]+direction[i][1];
				
				if(nr<rsize && nr>=0 && nc<csize && nc>=0) {
					if(map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] =true;
						queue.offer(new int[] {nr,nc});
					}
				}
			}			
		}
	}
}
