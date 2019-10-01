package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] map = new int[100][100];
		
		
//		LinkedList<Integer>[] garo = new LinkedList[100];
//		LinkedList<Integer>[] sero = new LinkedList[100];
//		
//		for(int i=0; i<100; i++) {
//			garo[i] = new LinkedList<>();
//			sero[i] = new LinkedList<>();
//		}
//		
		int count=0;
		
		StringTokenizer st = null;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					map[r+i][c+j] = 1;
				}
			}
			
//			for(int i=0; i<10; i++) {
//				if(!garo[c].contains(r+i)) {
//					garo[c].add(r+i);
//					count++;
//				}
//				
//				if(!sero[r].contains(c+i)) {
//					sero[r].add(c+i);
//					count++;
//				}
//			}
			
		}
		
		for(int i=0; i<100; i++) {
			if(map[0][i]==1) {
				count++;
			}
			if(map[i][0]==1) {
				count++;
			}
			if(map[99][i]==1) {
				count++;
			}
			if(map[i][99]==1) {
				count++;
			}
		}
		
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<99; j++) {
				if((map[i][j]^map[i][j+1])==1) { // 경계값 체크
					count++;
				}
				
				if((map[j][i]^map[j+1][i])==1) {
					count++;
				}
				
			}
		}
		
		
		System.out.println(count);
		
	}

}
