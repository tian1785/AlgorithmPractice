package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int[] numbers;
	static int[][] rinfo;
	static int N,M,K, Answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = (int)(st.nextToken().charAt(0)-'0');
			}
		}
		
		numbers = new int[K];
		rinfo = new int[K][3];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			rinfo[i][0] = Integer.parseInt(st.nextToken());
			rinfo[i][1] = Integer.parseInt(st.nextToken());
			rinfo[i][2] = Integer.parseInt(st.nextToken());
		}
		Answer = Integer.MAX_VALUE;
		
		permutation(map, 0,0);
		
		System.out.println(Answer);
		
	}
	
	private static void permutation(int[][] arr, int count, int visit) {
		if(count==K) {
			for(int i=0; i<K; i++) {
				int idx = numbers[i];
				arr = rotation(arr, rinfo[idx][0],rinfo[idx][1],rinfo[idx][2]);
			}
			int temp = cal(arr);
			if(Answer>temp) {
				Answer = temp;
			}
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0; i<K; i++) {
			if((visit & 1<<i) == 0) { //방문 안했을 때
				numbers[count] = i;
				permutation(arr, count+1, visit|1<<i);
			}
			
		}
	}
	private static int cal(int[][] arr) { // 배열의 값 계산 함수
		int N = arr.length;
		int M = arr[0].length;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<N; i++) {
			int sum=0;
			for(int j=1; j<M; j++) {
				sum+=arr[i][j];
			}
			if(sum<min) {
				min = sum;
			}
		}
		
		return min;
	}
	
	private static int[][] rotation(int[][] input, int r, int c, int s) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = input[i][j];
			}
		}
		
//		int[] dx = {0,1, 0,-1};
//		int[] dy = {1,0,-1, 0};
		
		for(int i=0; i<s; i++) {
			int currentr = r-s+i;
			int currentc = c-s+i;
			int temp = map[currentr][currentc];
			
			for(int d=0; d<4; d++) {
				
				while(true) {
					int nr = currentr + dx[d];
					int nc = currentc + dy[d];
					
					if(nr>r+s-i || nc>c+s-i || nr<r-s+i || nc<c-s+i) break;
					map[currentr][currentc] = map[nr][nc];
					currentr = nr;
					currentc = nc;
				}
				
			}
			// 다 돌린 후
			map[r-s+i][c-s+i+1] = temp;
			
		}
		
		
		return map;
		
	}

}
