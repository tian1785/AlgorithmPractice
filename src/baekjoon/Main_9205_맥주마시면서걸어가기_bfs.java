package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기_bfs {
	static String Answer;
	static boolean[] visited;
	static int[][] store;
	static int destr;
	static int destc;
	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if(Math.abs(destr-current[0])+Math.abs(destc-current[1])<=1000) {
				Answer="happy";
				return;
			}
			
			
			for(int i=0; i<store.length; i++) {
				if(!visited[i] && (Math.abs(store[i][0]-current[0])+Math.abs(store[i][1]-current[1])<=1000)) {
					visited[i] = true;
					queue.offer(new int[] {store[i][0],store[i][1]});
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			Answer = "sad";
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startr = Integer.parseInt(st.nextToken());
			int startc = Integer.parseInt(st.nextToken());
			store = new int[N][2];
			visited = new boolean[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			destr = Integer.parseInt(st.nextToken());
			destc = Integer.parseInt(st.nextToken());
			
			bfs(startr,startc);
			System.out.println(Answer);
		}
	}
	
	

}
