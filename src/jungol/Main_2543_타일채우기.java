package jungol;

import java.util.Scanner;

public class Main_2543_타일채우기 {

	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		map = new int[N][N];
		
		map[r][c] = 9;
		
		DaQ(0,0,N);
		map[r][c] = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void DaQ(int r, int c, int k) {
		if(k==1) {
			return;
		}
		int middle = k/2;
		int T = number(r,c,k);
		marking(r+middle-1,c+middle-1,T);
		
		DaQ(r,c,middle);
		DaQ(r,c+middle,middle);
		DaQ(r+middle,c,middle);
		DaQ(r+middle,c+middle,middle);
	}
	private static int number(int r, int c, int k) {
		int middle = k/2;
		for(int i=r; i<r+middle; i++) {
			for(int j=c; j<c+middle; j++) {
				if(map[i][j]!=0) return 1;
			}
		}
		for(int i=r; i<r+middle; i++) {
			for(int j=c+middle; j<c+k; j++) {
				if(map[i][j]!=0) return 2;
			}
		}
		for(int i=r+middle; i<r+k; i++) {
			for(int j=c; j<c+middle; j++) {
				if(map[i][j]!=0) return 3;
			}
		}
		for(int i=r+middle; i<r+k; i++) {
			for(int j=c+middle; j<c+k; j++) {
				if(map[i][j]!=0) return 4;
			}
		}
		return -1;
	}

	private static void marking(int r, int c, int t) {
		switch (t) {
		case 1:
			map[r][c+1]=map[r+1][c+1]=map[r+1][c] = 1;
			break;
		case 2:
			map[r][c]=map[r+1][c+1]=map[r+1][c] = 2;
			break;
		case 3:
			map[r][c]=map[r][c+1]=map[r+1][c+1] = 3;
			break;
		case 4:
			map[r][c]=map[r][c+1]=map[r+1][c] = 4;
			break;

		}
	}
}
