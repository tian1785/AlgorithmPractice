package baekjoon;

import java.util.Scanner;

public class Main_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //색종이의 수
		
		int[][] map = new int[101][101];
		
		int count=0;
		for(int k=0; k<N; k++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(map[r+i][c+j] == 0) {
						map[r+i][c+j] = 1;
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
