package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static boolean[] selected;
	static int[][] skill;
	static int N, Answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Answer = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());

		selected = new boolean[N];
		skill = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		permutation(0,0);
		System.out.println(Answer);
	}
	
	public static void permutation(int index, int count) {
		if(index == N ) {
			if(count==N/2) {
				int team1=0;
				int team2=0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(selected[i]&&selected[j]) {
							team1+=skill[i][j];
						}else if(!selected[i] &&!selected[j]) {
							team2+=skill[i][j];
						}
					}
				}
				if(Math.abs(team1-team2) < Answer) {
					Answer = Math.abs(team1-team2);
				}
			}
			
			return;
		}
		
		selected[index] = true;
		permutation(index+1, count++);
		selected[index] = false;
		permutation(index+1, count);
		
	}

}
