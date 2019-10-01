package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {

	static int max, N, L;
	static int[][] food;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 재료제한수
			L = Integer.parseInt(st.nextToken());  // 칼로리 제한
			food = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken()); // 점수
				food[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			
			find(0,0,0);
//			for (int i = 0; i < N; i++) {
//				System.out.print(food[i][0]+" ");
//				System.out.print(food[i][1]);
//				System.out.println();
//			}
			
			System.out.println("#"+test+" "+max);
		}
	}
	
	private static void find(int idx, int cal, int taste) {
		if(cal>L) return;
		if(idx == N) {
			if(taste >max) max = taste;
			return;
		}
		
		find(idx+1, cal+food[idx][1], taste+food[idx][0]);
		find(idx+1, cal, taste); //선택 안했을 경우
		
	}

}
