package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5569_출근경로BFS_실패 {

	private static boolean[][][] visit;
	private static int[][] direction = {{1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[W][H];
		visit = new boolean[2][W][H];
		
		System.out.println(bfs(map));
	}
	
//	private static dfs(int[][] map) {
//		
//	}

	private static int bfs(int[][] map) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int rsize = map.length;
		int csize = map[0].length;
		int count = 0;
		if(rsize>1) {
			queue.add(new int[] {2,1,0,count});
		}
		if(csize>1){
			queue.add(new int[] {2,0,1,count});			
		}
		int Max = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			System.out.println("current :"+Arrays.toString(current));
			int r = current[1];
			int c = current[2];
			int d = current[0];
			count = current[3];
			
			if(r==rsize-1 && c==csize-1) {
				if(Max<count)
					Max = count;
			}
			int nr, nc;
			if(d>1) { // 회전 안했을 때
				for(int j=0; j<2; j++) {
					nr = r+direction[(d+j)%2][0];
					nc = c+direction[(d+j)%2][1];
						
					if(nr>=0 && nr<rsize && nc>=0 && nc<csize && !visit[j][nr][nc]) {
						visit[j][nr][nc] = true;
						queue.offer(new int[] {j,nr,nc,count+1});
					}
				}
			}else { //회전한 다음 d=0 또는 1일때
				nr = r+direction[d][0];
				nc = c+direction[d][1];
					
				if(nr>=0 && nr<rsize && nc>=0 && nc<csize && !visit[d][nr][nc]) {
					visit[d][nr][nc] = true;
					queue.offer(new int[] {2,nr,nc,count+1});
				}
			}
			
		}
		
		return count;
		
	}


}
