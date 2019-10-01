package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기_dfs {

	static int N;
	private static boolean[][] visited;
	static int[][] map;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int count=0;
		map = new int[N][N];
		visited = new boolean[N][N];
		LinkedList<Integer> Answer = new LinkedList<>();
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = (int)(s.charAt(j)-'0');
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					count++;
					Answer.add(bfs(i,j));
				}
			}
		}
		Collections.sort(Answer);
		System.out.println(count);
		for(int i : Answer) {
			System.out.println(i);
		}
	}

	private static int bfs(int r, int c) {
		Stack<int[]> stack = new Stack<>();
		
		stack.push(new int[]{r,c});
		int t=0;
		
		while(!stack.isEmpty()) {
			int[] current = stack.pop();
			if(!visited[current[0]][current[1]]) {
				visited[current[0]][current[1]]=true;
				t++;
			}
			
			for(int i=0; i<4; i++) {
				int nr = current[0]+direction[i][0];
				int nc = current[1]+direction[i][1];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(map[nr][nc]==1 && !visited[nr][nc]) {
						stack.push(new int[] {nr, nc});
					}
				}
			}
			
		}
		return t;
		
	}

}
