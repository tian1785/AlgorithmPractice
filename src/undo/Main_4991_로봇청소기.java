package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {

	static int W,H, Num;
	static boolean[][] visited;
	static int[][] map;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<int[]> list = new LinkedList<>();
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0 && H==0) {
				break;
			}
			
			int r=0, c=0;
			map = new int[H][W];
			visited = new boolean[H][W];
			for(int i=0; i<H; i++) {
				String s = br.readLine();
				for(int j=0; j<W; j++) {
					if(s.charAt(j)=='x') { //가구가 있을 때
						map[i][j] = 1;
					}else if(s.charAt(j)=='*') { //청소할 곳
						map[i][j] = 2;
						Num++;
					}else if(s.charAt(j)=='o') {
						r=i;
						c=j;
					}
				}
			}//입력받음
			
			
		}
	}// main end
	private static int bfs(int sr, int sc, int dr, int c, int count) {
		return 0;
	}
	
	

}
