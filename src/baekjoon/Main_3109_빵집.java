package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	static boolean isFind;
	static int R, C, Answer;
	static boolean[][] visited;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				if(s.charAt(j)=='x') {
					map[i][j] = 1; //건물이 있는 곳
				}
			}
		}
		Answer=0;
		
		for(int i=0; i<R; i++) {
			isFind = false;
			find(0, i);
		}
		
		System.out.println(Answer);
	}
	
	private static void find(int count, int ridx) { //다 해보기
//		if(isFind) return;
		if(count==C-1) { 
			isFind = true;
			Answer++;
			return;
		}

		int i=ridx==0?0:(ridx-1);
		for(; i<=ridx+1 && i<R ; i++) { 
			if(map[i][count+1]==0 && !visited[i][count+1]) { //지나갈 수 있는 경우
				visited[i][count+1] = true;
				find(count+1, i);
				if(isFind) return;
			}
		}
	}
	

}
