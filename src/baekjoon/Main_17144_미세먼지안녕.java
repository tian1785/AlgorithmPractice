package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3 3 5
0 30 7
-1 10 0
-1 0 20
*/
public class Main_17144_미세먼지안녕 {

	static int R, C, cr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		cr=0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) cr = i;
			}
		}//입력완료
		
//		System.out.println(cr);
		for(int i=0; i<T; i++) {
			map = diffusion(map);
			circulator(map, cr);
		}
		
		int Answer = 0; 
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) {
					Answer += map[i][j];
				}
			}
		}
		System.out.println(Answer);

//		map = diffusion(map);
//		circulator(map, cr);
		
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	
	}
	
	private static void circulator(int[][] arr, int r) {
		//반시계방향 순회 1
		for(int i=r-2; i>0; i--) {
			arr[i][0] = arr[i-1][0]; 
		}
		//반시계방향 순회 2
		for(int i=0; i<C-1; i++) {
			arr[0][i] = arr[0][i+1];
		}
		//반시계방향 순회 3
		for(int i=0; i<r-1; i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		//반시계방향 순회 4
		for(int i=C-1; i>1; i-- ) {
			arr[r-1][i] = arr[r-1][i-1];
		}
		arr[r-1][1] =0;
		
		//시계방향 순회1
		for(int i=r+1; i<R-1; i++) {
			arr[i][0] = arr[i+1][0];
		}
		//시계방향 순회2
		for(int i=0; i<C-1; i++) {
			arr[R-1][i] = arr[R-1][i+1];
		}
		//시계방향순회3
		for(int i=R-1; i>r; i-- ) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		//시계방향순회4
		for(int i=C-1; i>1; i-- ) {
			arr[r][i] = arr[r][i-1];
		}
		
		arr[r][1] = 0;
	}
	
	private static int[][] diffusion(int[][] input) { // 1초 확산 후 배열 상태를 반환하는 함수
		int[][] result = new int[R][C];
		result[cr][0] = -1;
		result[cr-1][0] = -1;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(input[i][j]>0) { //먼지 존재
					int count = 0;
					int addv = input[i][j]/5;
					for(int d=0; d<4; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						if(nr>=0 && nr<R && nc>=0 && nc<C && input[nr][nc]>=0) {
							result[nr][nc] +=addv;
							count++;
						}
					}
					result[i][j] += input[i][j] - (addv*count);
				}
			}
		}
		return result;
		
	}

}
