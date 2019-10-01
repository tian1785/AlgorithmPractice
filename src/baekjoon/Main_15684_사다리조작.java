package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {

	static boolean possible;
	static int H, N, Answer;
	static int[][] sadari;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로선 개수
		int M = Integer.parseInt(st.nextToken()); //가로선 개수
		H = Integer.parseInt(st.nextToken()); //가로선을 놓을 수 있는 위치의 개수
		sadari = new int[H][N+2]; //앞뒤로 한칸 늘리기
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			sadari[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())] = 1; //사다리 존재
		}
		Answer = 4;
		possible = false;
		
		permutation(0);
		if(!possible) {
			Answer = -1;
		}
		System.out.println(Answer);
	}
	
	
	private static void permutation(int count) {
		if(game(sadari)) {
			possible=true;
			if(count<Answer) {
				Answer = count;
			}
			return;
		}
		if(count ==3) {
			return;
		}
		
		for(int i=0; i<H; i++) {
			for(int j=1; j<N; j++) {
				if(sadari[i][j] == 0 && sadari[i][j-1]==0 && sadari[i][j+1]==0) {
					sadari[i][j] = 1;
					permutation(count+1);
					sadari[i][j] = 0;
				}
			}
		}
	}
	
	// 사다리 게임 했을 때 1->1, 2->2 3->3 ... N->N 가는지 체크해주는 함수
	private static boolean game(int[][] s) {
		for(int i=1; i<=N; i++) {
			
			int currentr = 0;
			int currentc = i;
			while(currentr < H) {
				if(s[currentr][currentc]==1) { //오른쪽으로 가는 사다리 존재
					currentc = currentc+1;
				}else if(s[currentr][currentc-1]==1) { //왼쪽으로 가는 사다리 존재
					currentc = currentc-1;
				}
				currentr++;
			}
			
			if(currentc != i) { // 하나라도 걸리는 것이 있으면
				return false;
			}
		}
		return true;
	}

}
