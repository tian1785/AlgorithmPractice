package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7532_세영이의SEM력연도 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/input_7532.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E= Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int Answer = 0;
			int temp =0;
			
			while(true) {
//				Answer = 365*temp+1+S;
				Answer = S%365==0?365*(temp+1):365*temp+S;
//				int tempE = Answer%24==0?24:Answer%24;
//				int tempM = Answer%29==0?29:Answer%29;
				int tempE = Answer%24;
				int tempM = Answer%29;
				if(E%24==tempE && M%29==tempM) {
					break;
				}
				temp++;
			}
			
			System.out.println("#"+test+" "+Answer);
			
		}

	}

}
