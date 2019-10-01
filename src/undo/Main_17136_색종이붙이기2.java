package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기2 {

	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		int onenumber = 0;
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) onenumber++;
			}
		}
		
		int[] numbers = {0,5,5,5,5,5};
		
		int Answer = 0;
		
		if(onenumber!=0) {
			first:
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==1) {
						int temp = find(i, j);
						System.out.println("temp :"+ temp);
						if(numbers[temp]>0) {
							Answer++;
							marking(i,j,temp);
							numbers[temp]--;
						}else {
							Answer = -1;
							break first;
						}
						
					}
				}
			}
		}
		
		System.out.println(Answer);
	}
	
	private static int find(int r, int c) {
		
		int result = 0;
		//5,4,3,2,1 가능성 체크
		first:
		for(int k=5; k>=1; k--) {
			
			for(int i=r; i<r+k; i++) {
				for(int j=c; j<c+k; j++) {
					if(map[i][j] !=1) {
						continue first;
					}
					
				}
			}
			result = k;
			break;
		}
		return result;
	}
	
	private static void marking(int r, int c, int num) {
		
		for(int i=r; i<r+num; i++) {
			for(int j=c; j<c+num; j++) {
				map[i][j] = 0;
			}
		}
	}

}
