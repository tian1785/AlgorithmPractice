package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_re {

	static StringBuilder sb  = new StringBuilder();
	static int N, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/hw/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test<=T; test++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			dfs(0, 0);
			
			sb.setLength(0);
			System.out.println("#"+test+" "+answer);
		}
	}
	private static void dfs(int count, int fix) {
		if(count == N) {
			if(answer < Integer.parseInt(sb.toString())) {
				answer = Integer.parseInt(sb.toString());
			}
			return;
		}
		
		for(int i=fix; i<sb.length(); i++) {
			for(int j=i+1; j<sb.length(); j++) {
//				if(sb.charAt(i)<=sb.charAt(j)) {
				swap(i,j);
				dfs(count+1, i);
				swap(i,j);
//				}
			}
		}
	}
	
	private static void swap(int i, int j) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
	}

}
