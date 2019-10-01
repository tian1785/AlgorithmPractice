package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int R, C;
	static boolean[][] check;
	static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int last=0;
		int time=0;
		
		while(true) {
			check = new boolean[R][C];
			List<int[]> list = new LinkedList<>();
			int count=0;
			
			bfs();
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C-1; j++) {
					if(check[i][j] && !check[i][j+1]) {
						list.add(new int[] {i,j+1});
					}
					if(!check[i][j] && check[i][j+1]) {
						list.add(new int[] {i,j});
					}
				}
			}
			for(int i=0; i<R-1; i++) {
				for(int j=0; j<C; j++) {
					if(check[i][j] && !check[i+1][j]) {
						list.add(new int[] {i+1,j});
					}
					if(!check[i][j] && check[i+1][j]) {
						list.add(new int[] {i,j});
					}
				}
			}
			
			
			for(int i=0; i<list.size(); i++) {
				if(map[list.get(i)[0]][list.get(i)[1]]==1) {
					map[list.get(i)[0]][list.get(i)[1]]=0;
					count++;
				}
			}
			
			

			if(count==0) {
				break;
			}else {
				time++;
				last=count;
			}
		}
		
		System.out.println(time);
		System.out.println(last);
	}

	private static void bfs() { // 벽 찾기
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {0,0});
		check[0][0] = true;
		
		while(! queue.isEmpty()) {
			
			int[] current = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = current[0]+direction[i][0];
				int nc = current[1]+direction[i][1];
				
				if(nr>=0 &&nc>=0 && nr<R && nc<C && map[nr][nc]==0 && !check[nr][nc]) {
					queue.offer(new int[] {nr,nc});
					check[nr][nc] = true;
				}
				
			}
			
		}
	}

}
