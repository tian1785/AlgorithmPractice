package baekjoon;

import java.util.Scanner;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int N = s.length();
		
		int R=0, C=0;
		for(int i=1; i<N; i++) {
			if(N%i==0) { //나누어 떨어지는 경우
				C = i;
				R = N/i;
			}
			
			if(C>=R) {
				break;
			}
		}
		char[][] amho = new char[R][C];
		
		int count = 0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				amho[j][i] = s.charAt(count++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(amho[i][j]);
			}
		}
		
		System.out.println(sb.toString());

	}

}
