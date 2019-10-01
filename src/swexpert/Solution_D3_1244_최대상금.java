package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {

	private static int max;
	private static HashSet<String> s = new HashSet<String>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/hw/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int[] num =  new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				num[i] = s.charAt(i) - '0';
			}
			int N = Integer.parseInt(st.nextToken());
			max = 0;
			
			find(num, N);
			
			System.out.println("#"+test+" "+max);
		}
	} // end of main
	
	private static void find(int[] num, int N) {
		int val = 0;
		for(int i=0; i<num.length; i++) val = val*10+num[i];
		
		if(s.contains(""+val+N)) return; //메모 숫자+횟수를 메모시킨다.
		s.add(""+val+N);
		if(N==0) {
			if (max < val) max = val;
		}else {
			for(int i=0; i< num.length-1; i++) {
				for(int j= i+1; j<num.length; j++) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					find(num, N-1);
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
	}
	
}
