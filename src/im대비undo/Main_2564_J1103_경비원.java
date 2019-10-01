package im대비undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_J1103_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine()); // 상점 개수
		
		int[][] map = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken()); //동근이가 있는 방향
		int r = Integer.parseInt(st.nextToken()); //동근이가 서 있는 거리
		
		
		//최저길이 찾기
		int Answer = 0;
		for(int i=0; i<N; i++) {
			if(map[i][0] == d) {
				Answer+= Math.abs(r-map[i][1]);
				continue;
			}
			
			if(map[i][0]%2==0) { //짝수일 때  d-1이 맞은편
				
			}else {
				
			}
		}
				
	}

}
