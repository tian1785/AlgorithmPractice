package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	static int cctvs;
	static LinkedList<Integer> cctv;
					//동, 서, 남, 북
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][M];
		int areas = 0;
		cctv = new LinkedList<>();
		
		cctvs = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==0) {
					areas++;
				}
				if(room[i][j]>0 && room[i][j]<6) {
					cctvs++;
					cctv.add(room[i][j]); //list에 넣기
				}
			}
		}
		
		
		
	}
	private static void find(int count) { //다 해보기
		if(count ==cctvs) {
			return;
		}
		
		
				
	}
	
	private static void marking(int[][] arr,int r,int c, int d) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] result = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				result[i][j] = arr[i][j];
			}
		}
		
		switch (d) {
		case 0: // 동 
			for(int i=c+1; i<M; i++) {
				if(arr[r][i]==6) break;
				if(arr[r][i]==0) {
					arr[r][i] = 9; //감시지역 마킹
				}
			}
			break;
		case 1: // 서
			for(int i=c-1; i>=0; i--) {
				if(arr[r][i]==6) break;
				if(arr[r][i]==0) {
					arr[r][i] = 9; //감시지역 마킹
				}
			}
			break;
		case 2: // 남
			for(int i=r+1; i<N; i++) {
				if(arr[i][c]==6) break;
				if(arr[i][c]==0) {
					arr[i][c] = 9; //감시지역 마킹
				}
			}
			break;
		case 3: // 북
			for(int i=r-1; i>=0; i--) {
				if(arr[i][c]==6) break;
				if(arr[i][c]==0) {
					arr[i][c] = 9; //감시지역 마킹
				}
			}
			break;

		}
	}

}
