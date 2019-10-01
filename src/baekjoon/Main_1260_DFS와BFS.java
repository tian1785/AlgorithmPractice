package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static LinkedList<Integer>[] list;
	static boolean[] isvisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeN = Integer.parseInt(st.nextToken());
		int edgeN = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		list = new LinkedList[nodeN+1];
		isvisited = new boolean[nodeN+1];

		for(int i=1; i<=nodeN; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < edgeN; i++) {
			st = new StringTokenizer(br.readLine());
				
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			if(list[a]==null)
//				list[a]= new LinkedList<Integer>();
//			if(list[b]==null)
//				list[b] = new LinkedList<Integer>();
			list[a].add(b);
			list[b].add(a);
		}

		for (int i =1; i <= nodeN; i++)
//			if(list[i] !=null)
			Collections.sort(list[i]);

		dfs(startNode);
		System.out.println(sb.toString());
		sb.setLength(0);
		for(int i=0; i<nodeN+1; i++) {
			isvisited[i]=false;
		}
//		System.out.println();
		bfs(startNode);
		System.out.println(sb.toString());
	}

	private static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<Integer>();

		isvisited[startNode] = true;
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.printf("%d ",current);
			sb.append(current + " ");
			for (int i : list[current]) {
				if (!isvisited[i]) {
					isvisited[i] = true;
					queue.offer(i);
				}
			}
		}

	}

	private static void dfs(int startNode) {

		isvisited[startNode] = true;
//		System.out.printf("%d ",startNode);
		sb.append(startNode + " ");

		for (int i : list[startNode]) {
			if (!isvisited[i]) {
				dfs(i);
			}

		}

	}

}
