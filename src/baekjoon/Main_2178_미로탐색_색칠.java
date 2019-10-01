package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색_색칠 {
	static int[][] check;
	static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N+2][M+2];
		check = new int[N+2][M+2];
		
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				maze[i][j] = (int)(s.charAt(j-1)-'0');
			}
		}
		bfs(maze, N, M);
		System.out.println(check[N][M]);
//		System.out.println(bfs(maze, N, M));
		
	}
	
	private static void bfs(int[][] maze, int N, int M) {
		Queue<int[]> queue = new LinkedList<int[]>();
		check[1][1] = 1;
		queue.offer(new int[]{1,1,1});
		
		while(! queue.isEmpty()) {
			int[] current = queue.poll();
			
			if(current[0]==N && current[1]==M) { //목적지
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = current[0]+direction[i][0];
				int nc = current[1]+direction[i][1];
				
				if(maze[nr][nc]==1 && check[nr][nc] == 0) {
					check[nr][nc] =check[current[0]][current[1]]+1;
					queue.offer(new int[] {nr, nc, current[2]+1});
				}
				
			}
		}
	}
	

}
