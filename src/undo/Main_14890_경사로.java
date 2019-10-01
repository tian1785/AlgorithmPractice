package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int Answer = 0;
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean up=false, down=false;
		for(int i=0; i<N; i++) {
			int max = 0;
			for(int j=0; j<N-L-1; j++) {
				
				if(map[i][j]< map[i][j+1]) {
					up = true;
				}else if(map[i][j] > map[i][j]) {
					down = true;
				}
				// 내려가는 방향
				for(int k=1; i<L; k++) {
					if(up && map[i][j+k] >map[i][j+k+1]) {
						up = false;
					}
					if(down && map[i][j+k]<map[i][j+k+1]) {
						down = false;
					}
				}
				
				if(up) {
					
				}
				
				if(down) {
					
				}
				
				//중간에 걸리는 것이 없으면 갈 수 있는 길!
				Answer++;
//				map[i][j];
//				map[i][j+1];
//				map[i][j+2];
//				map[i][j] 
			}
		}
	}

}
