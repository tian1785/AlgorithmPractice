package baekjoon;

import java.util.Scanner;

public class Main_6987_월드컵 {

	static int[][] tempT, T;
	static boolean Find;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test=0; test<4; test++) {
			T = new int[6][3];
			int[] sum = new int[3];
			int[] sumr = new int[6];
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					T[i][j] = sc.nextInt();
					sum[j]+=T[i][j];
					sumr[i] += T[i][j];
				}
			}
			boolean p = true;
			boolean m = true;
			for(int i=0; i<6; i++) {
				if(sumr[i]!=5) p=false;
				if(T[i][1] >5) m=false;
			}
			
			int total = sum[0]+sum[1]+sum[2];
			if(total != 30 || sum[0] != sum[2] || sum[1]%2==1 || !p || !m) {
				System.out.print("0 ");
			}else {
				Find = false;
				tempT = new int[6][3];
				permutation(0,1);
				if(Find) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
		}
	}
	private static void permutation(int i, int j) {
		if(Find) {
			return;
		}
		if(j==6 && i<5) {
			i++;
			j=i+1;
		}
		
		if(j==6 && i==5) { //마지막
			if(isSame()) {
				Find=true;
			}
			return;
		}
		
		
		//승 
		tempT[i][0]++;
		tempT[j][2]++;
		permutation(i, j+1);
		tempT[i][0]--;
		tempT[j][2]--;
		
		//패
		tempT[i][2]++;
		tempT[j][0]++;
		permutation(i, j+1);
		tempT[i][2]--;
		tempT[j][0]--;
		
		//무
		tempT[i][1]++;
		tempT[j][1]++;
		permutation(i, j+1);
		tempT[i][1]--;
		tempT[j][1]--;
		
	}

	private static boolean isSame() {
		for(int i=0; i<6; i++) {
			for(int j=0; j<3; j++) {
				if(T[i][j] != tempT[i][j]) return false;
			}
		}
		return true;
	}
}
