package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스_dfs {
	static int count;
	static boolean[] visited;
	static LinkedList<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		visited = new boolean[com+1];
		list = (LinkedList<Integer>[])new LinkedList[com+1];
		for(int i=1; i<=com; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		count = 0;
		dfs(1);
//		bfs(1);
		System.out.println(count);
		
		
	}
	
	private static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(current);
		visited[current] = true;
		while(!queue.isEmpty()) {
			current = queue.poll();
			for(int i : list[current]) {
				if(!visited[i]) {
					count++;
					visited[i]= true;
					queue.offer(i);
				}
			}
		}
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		
		for(int i : list[current]) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		return;
		
	}

}
