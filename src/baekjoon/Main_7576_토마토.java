package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	static boolean[][] visited;
	static int days;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int tomatonum = 0;
		days=0;
		LinkedList<int[]> tomato = new LinkedList<>();
		int[][] map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) tomatonum++;
				if(map[i][j]==1) tomato.add(new int[] {i,j});
			}
		}
		
//		System.out.println("tomatonum : "+ tomatonum);
//		System.out.println();
		int bfsresult = bfs(map, tomato);
		if( bfsresult == tomatonum) {
			System.out.println(days);
//			System.out.println(bfsresult);
		}else {
			System.out.println(-1);
		}
		
//		System.out.println("days : "+days);
	}

	private static int bfs(int[][] arr, LinkedList<int[]> tomato) {
		Queue<LinkedList<int[]>> queue = new LinkedList<>();
		int sizer= arr.length;
		int sizec= arr[0].length;
		
		queue.offer(tomato);
		int result =0;
		
		for(int[] first : tomato) {
			visited[first[0]][first[1]]=true;
//			System.out.println("first"+ Arrays.toString(first));
		}
		
		while(!queue.isEmpty()) {
//			System.out.println("queue length : "+queue.size());
			LinkedList<int[]> current = queue.poll();
			
//			System.out.println("current linkedlist :"+current);
			
			LinkedList<int[]> temp = new LinkedList<>();
			for(int i=0; i<4; i++) {
				for(int[] cur : current) {
					int nr = cur[0] + direction[i][0];
					int nc = cur[1] + direction[i][1];
					
					if(nr>=0 && nr<sizer && nc>=0 && nc<sizec) {
						if(arr[nr][nc]==0 && !visited[nr][nc]) {
							visited[nr][nc]= true;
							result++;
							temp.add(new int[] {nr,nc});
//							System.out.println("second"+ Arrays.toString(temp.getLast()));
						}
						
					}
				}
				
			}
			if(temp.size()>0) {
				queue.offer(temp);
				days++;
			}
			
		}
//		System.out.println("result : "+result);
		return result;
	}

}
