package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {

	private static int[][] map;
	private static int N, blueN, whiteN;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		map = new int[N][N];
		int white=0, blue=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) white++;
				else blue++;
			}
		}
		
		if(white==0 ) {
			whiteN = 0;
			blueN = 1;
		}else if(blue==0) {
			whiteN = 1;
			blueN = 0;
		}else { //나머지
			
			find(0,0,N);
		}
		
		System.out.println(whiteN);
		System.out.println(blueN);
	}
	private static void find(int r, int c, int k) {
		if(k==1) return;
		
		int middle = k/2;
		if(!check(r,c,middle)) {
			find(r, c, middle);
		}
		if(!check(r,c+middle,middle)) {
			find(r, c+middle, middle);
		}
		
		if(!check(r+middle,c,middle)) {
			find(r+middle,c,middle);
		}
		
		if(!check(r+middle,c+middle, middle)) {
			find(r+middle,c+middle,middle);
		}
		
	}
	
	private static boolean check(int r, int c, int k) {
		int w=0,b=0;
		for(int i=r; i<r+k; i++) {
			for(int j=c; j<c+k; j++) {
				if(map[i][j]==1) b++;
				else w++;
			}
		}
		
		if(b==0) {
			whiteN++;
			return true;
		}else if(w==0) {
			blueN++;
			return true;
		}else {
			return false;
		}
	}

}
