package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[][] map = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] curves = new int[N][4];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			curves[i][0] = Integer.parseInt(st.nextToken());
			curves[i][1] = Integer.parseInt(st.nextToken());
			curves[i][2] = Integer.parseInt(st.nextToken());
			curves[i][3] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	private static int[] drangon(int r, int c, int[] direction) {
		int[] returndirection = new int[direction.length*2];
		
		
		
		
		
		return returndirection;
	}

}
