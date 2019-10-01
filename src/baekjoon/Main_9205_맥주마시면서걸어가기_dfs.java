package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기_dfs {
	static String Answer;
	static boolean[] visited;
	static int[][] store;
	static int destr;
	static int destc;
	
	private static void dfs(int r, int c) {
		
		if(Math.abs(destr-r)+Math.abs(destc-c)<=1000) {
			Answer="happy";
			return;
		}
		
		for(int i=0; i<store.length; i++) {
			if(!visited[i] && (Math.abs(store[i][0]-r)+Math.abs(store[i][1]-c)<=1000)) {
				visited[i] = true;
				
//				if(Math.abs(destr-store[i][0])+Math.abs(destc-store[i][1])<=1000) {
//					Answer="happy";
//					return;
//				}
				
				dfs(store[i][0],store[i][1]);
			}
		}
		
		return;
		
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
			
			dfs(startr,startc);
			System.out.println(Answer);
		}
	}
	
	

}
