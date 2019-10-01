package baekjoon;

import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기 {

	static final int INF = 1000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test=1; test<=T; test++) {
			int N = sc.nextInt();
			int[][] location= new int[N+2][2];
			for(int i=0; i<N+2; i++) {
				location[i][0] = sc.nextInt();
				location[i][1] = sc.nextInt();
			}
			
			boolean[][] distance = new boolean[N+2][N+2];
//			int[][] D = new int[N+2][N+2];
			for(int i=0; i<N+1; i++) {
				for(int j=i+1;j<N+2; j++) {
					if(Math.abs(location[i][0]-location[j][0])+Math.abs(location[i][1]-location[j][1])<=1000) { //갈 수 있음
//						D[i][j] = D[j][i] = 1;
						distance[i][j] = distance[j][i] = true;
					}/*else {
						D[i][j] = D[j][i] = INF;
					}*/
				}
			}
			
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
//					if(i==k) continue;
					for(int j=0; j<N+2; j++) {
						if(!distance[i][j] && distance[i][k] && distance[k][j]) distance[i][j] =true;
//						if(j==k && i==j) continue;
//						if(D[i][j]==INF) {
//							if(D[i][k]==1 && D[k][j]==1) D[i][j]=1;
//						}
					}
				}
			}
			
			System.out.println(distance[0][N+1]?"happy":"sad");
			
//			String Answer = "";
//			if(D[0][N+1]==1) {
//				Answer = "happy";
//			}else {
//				Answer = "sad";
//			}
//			
//			
//			System.out.println(Answer);
		}
	}

}
