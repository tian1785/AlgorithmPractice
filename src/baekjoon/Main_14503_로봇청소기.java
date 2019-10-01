package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//로봇청소기
public class Main_14503_로봇청소기 {
						//북 동 남 서
//	int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[] rd = {0, 3, 2, 1};
	static int[][] rdirection = {{-1,0},{0,-1},{1,0},{0,1}};
	static int Answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Answer=0;
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = rd[Integer.parseInt(st.nextToken())];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int nr, nc, backr, backc;
		int count =0;
		// 북 -> 서  ->  남  ->  동
		while(true) {
			if(map[r][c]==0) {
				map[r][c]=2;
				Answer++;
			}
			d = (d+1)%4; // 왼 방향 회전
			nr = r+ rdirection[d][0];
			nc = c+ rdirection[d][1];
			count++;
			
			// 왼쪽 방향에 아직 청소가능한 공간이 존재한다면,
			if( map[nr][nc]==0) { //nr>=0 && nr<N && nc>=0 && nc<M &&
				r = nr;
				c = nc;
				count=0;
				continue;
			}/*else {
				d = (d+1)%4;
				count++;
			}*/
			
			//뒷방향  d+2
			
			
			if(count==4) { // 4방향 돌아봤을때
				backr= r+rdirection[(d+2)%4][0];
				backc= c+rdirection[(d+2)%4][1];
				
				if( map[backr][backc]!=1) { //backr>=0 && backr<N && backc>=0 && backc<M &&
					r= backr;
					c= backc;
					count=0;
					continue;
				}else {
					break;
				}
				
			}
			
		}
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		System.out.println(Answer);
		
	}

}
