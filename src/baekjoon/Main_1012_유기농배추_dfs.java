package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_dfs {
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
						dfs(map,i,j);
					}
				}
			}
			System.out.println(Answer);
			
		}
	}

	private static void dfs(int[][] map, int r, int c) {
		visited[r][c] = true;
		
		for(int k=0; k<4; k++) {
			int nr = r+direction[k][0];
			int nc = c+direction[k][1];
			
			if(nr>=0 && nr<M && nc>=0 && nc<N && map[nr][nc]==1 && !visited[nr][nc]) {
//				visited[nr][nc] = true;
				dfs(map, nr, nc);
			}
			
			
		}
		/*Stack<int[]> stack = new Stack<>();
		
		int result =0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					visited[i][j] = true;
					for(int k=0; k<4; k++) {
						int nr = i+direction[k][0];
						int nc = j+direction[k][1];
						
						if(nr>=0 && nr<M && nc>=0 && nc<N && map[nr][nc]==1 && !visited[nr][nc]) {
							stack.push(new int[] {i,j});
							i = nr;
							j = nc;
							
						}
						
					}
					
					result++;
				}
				
			}
		}*/
	}
}
