package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2146_다리만들기 {

	static int N, cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N][N];
		visit = new boolean[N][N];
		cnt = 0;
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 몇개 섬인지 찾기 (1,2,3 ...) cnt는 섬의 개수
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(map[i][j]>0 && !visit[i][j]){
					cnt++;
					bfs(i,j);
				}
			}
		}
		
		// 섬의 가장자리를 찾아 queue에 넣기
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				boolean check = false;
				
				if(map[i][j]==0) continue;
				
				for(int d=0; d<4; d++){
					int nr = i+dx[d];
					int nc = j+dx[d];
					if(nr<0 || nc<0 || nr>=N || nc>=N ) continue;
					if(map[nr][nc]==0){
						check = true;
						break;
					}
				}
				
				if(check) queue.offer(new int[]{i,j,map[i][j],0});
			}
		}
		
		// 가장자리에서 다른 섬까지 거리 찾기 bfs
		int distance = 0;
		first:
		while(!queue.isEmpty()){
			int[] current = queue.poll();
			
			for(int d=0; d<4; d++){
				int nr = current[0]+dx[d];
				int nc = current[1]+dy[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N ) continue;
				
				// 다른 섬 찾음
				if(map[nr][nc]>0 && map[nr][nc]!=current[2]){
					distance = current[3];
					break first;
				}
				
				if(map[nr][nc]>0) continue;
				
				queue.offer(new int[]{nr, nc, current[2], current[3]+1});
			}
			
		}
		
		System.out.println(distance);
		
	}
	static void bfs(int r, int c){
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{r,c});
		map[r][c] = cnt;
		visit[r][c] = true;
		
		while(!queue.isEmpty()){
			int[] current = queue.poll();
			
			for(int d=0; d<4; d++){
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N || visit[nr][nc]) continue;
				
				if(map[nr][nc]>0){
					map[nr][nc] = cnt;
					queue.offer(new int[]{nr,nc});
					visit[nr][nc] = true;
				}
				
			}
		}
		
		
	}

}
