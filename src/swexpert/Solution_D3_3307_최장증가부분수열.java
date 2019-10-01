package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] number = new int[N];
			int[] D = new int[N];
			Arrays.fill(D, 1);
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<i; j++) {
					if(number[i]>number[j]) {
						D[i] = Math.max(D[i], D[j]+1);
					}
				}
				
			}
			
			int Answer = 0;
			for(int i=0; i<N; i++) {
				if(D[i]>Answer) {
					Answer = D[i];
				}
			}
			
			System.out.println("#"+test+" "+Answer);
		}
	}

}
