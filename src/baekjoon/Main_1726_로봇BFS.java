package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇BFS {

	static int M,N,destr,destc,destd;
	static int[][] map;
	static boolean[][][] isVisited;
	static int[] direction = {0, 0, 2, 1, 3};	//동서남북
	static int[][] turned = {{0,1},{1,0},{0,-1},{-1,0}}; // 동남서북 (시계방향)
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/bfs/input_1726"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		isVisited = new boolean[5][M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		st = new StringTokenizer(br.readLine());
		int startr = Integer.parseInt(st.nextToken())-1;
		int startc = Integer.parseInt(st.nextToken())-1;
		int startd = direction[Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(br.readLine());
		destr = Integer.parseInt(st.nextToken())-1;
		destc = Integer.parseInt(st.nextToken())-1;
		destd = direction[Integer.parseInt(st.nextToken())];
		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
//		System.out.println("======================");
		bfs(startr, startc, startd);
		
//		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println(map[destr][destc]);
		
	}
	
	private static void bfs(int r, int c, int d) {
		Queue<int[]> queue = new LinkedList<int[]>();
		isVisited[d][r][c] = true;
		queue.offer(new int[] {r,c,d,0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
//			System.out.println("current :"+Arrays.toString(current));
			r = current[0];
			c = current[1];
			d = current[2];
			int count= current[3];
			
//			count = current[3];	
//			isVisited[d][r][c]=true;

			if(r==destr && c==destc && d==destd) {
//				map[r][c] = count;
//				System.out.println("출력출력");
				System.out.println(current[3]);
				return;
			}

			for(int j=1; j<=3; j++) {
				int nr = r + turned[d][0]*j;
				int nc = c + turned[d][1]*j;
				if(nr>=0 && nr<M && nc>=0 && nc<N) { 
					if(map[nr][nc]==0) { 
						if(!isVisited[d][nr][nc]) {
							isVisited[d][nr][nc]=true;
							queue.offer(new int[]{nr,nc,d,count+1});
						}
					}else {
						break;
					}
				}
			}
			
			for(int i=1; i<=3; i=i+2) {
//				int nr = current[0] + turned[current[2]][0];
//				int nc = current[1] + turned[current[2]][1];
				if(!isVisited[(d+i)%4][r][c]) { 
					isVisited[(d+i)%4][r][c]=true;
					queue.offer(new int[]{r,c,(d+i)%4,count+1});
				}
			}
			
		}
				
		
	}
	
	
	

}
