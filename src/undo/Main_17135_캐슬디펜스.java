package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {

	static int N,M,D, MN;
	static int[] archers;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int archer = 3;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		archers = new int[3];
		map = new int[N][M];
		boolean find=false;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]>0 && !find) {
					MN = N-i;
					find = true;
				}
			}
		}
		
		
		
	}
	
	public static void permutation() { //3명 뽑기
		
	}
	
	public static int game() {
		int count = 0;
		int r = N-1;
		while(MN-->0) {
			
			
			for(int a=0; a<3; a++) {
				int currentc = archers[a];
				
				
				
			}
			
			
			
			r--;
		}
		
		
		return count;
	}

}
