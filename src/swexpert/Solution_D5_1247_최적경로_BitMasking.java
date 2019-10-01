package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_BitMasking {

	static int N, Answer;
	static int[][] diff;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/ws/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine()); //고객 수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
//			int[] company = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
//			int[] home = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
//			List<int[]> cList = new ArrayList<int[]>();
//			int[][] customer = new int[N][];
			int[][] input = new int[N+2][];
			for(int i=0; i<N+2; i++) {
//				cList.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
//				customer[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
				input[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			}
			
			diff = new int[N+2][N+2]; // 0~N+1
			
			for(int i=0; i<N+2; i++) {
				for(int j=i+1; j<N+2; j++) {
					diff[i][j] = Math.abs(input[i][0] - input[j][0])+Math.abs(input[i][1]-input[j][1]);
					diff[j][i] = diff[i][j];
				}
			}
			
			Answer = Integer.MAX_VALUE;
			
			find(0,0,0,0);
			
			System.out.println("#"+test+" " + Answer);
		}
	}
	
	private static void find(int current, int idx, int distance, int visit) {
		if(distance>=Answer) return;
		if(idx==N) { //집으로
			distance +=diff[current][1];
			
			if(distance<Answer) {
				Answer = distance;
			}
			return;
		}
		
		for (int i = 2; i < N+2; i++) {
			if((visit & 1<<i) == 0) {
				find(i, idx+1, distance+diff[current][i], visit | 1<<i);
			}
		}
		
	}

	
	
}

