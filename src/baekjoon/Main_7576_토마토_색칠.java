package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_색칠 {

	static Queue<int[]> queue;
	static int[][] checked;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		int[][] map = new int[N][M];
		checked = new int[N][M];
		int count=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					queue.offer(new int[] {i,j});
					checked[i][j] =0;
				}
				if(map[i][j]==0)
					count++;
			}
		}
		bfs(map);
		int max = Integer.MIN_VALUE;
		int num=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(checked[i][j]>max)
					max = checked[i][j];
//				System.out.print(checked[i][j]+" ");
				if(checked[i][j]!=0)
					num++;
			}
//			System.out.println();
		}

		if(count==num)
			System.out.println(max);
		else
			System.out.println(-1);
			
		
		
	}
	private static void bfs(int[][] map) {
		int rsize = map.length;
		int csize = map[0].length;
		
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
//			System.out.println(Arrays.toString(current));
			int r = current[0];
			int c = current[1];
			
			for(int i=0; i<4; i++) {
				int nr = r+direction[i][0];
				int nc = c+direction[i][1];
				if(nr<rsize && nr>=0 && nc>=0 && nc<csize) {
					if(map[nr][nc]==0 && checked[nr][nc]==0) {
						checked[nr][nc]=checked[r][c]+1;
						queue.offer(new int[] {nr, nc});


//						for (int k = 0; k < rsize; k++) {
//							for (int j = 0; j < csize; j++) {
//								System.out.print(checked[k][j]+" ");
//							}
//							System.out.println();
//						}
//						
//						System.out.println();
					}
				}
				
			}
		}
		
	}

}
