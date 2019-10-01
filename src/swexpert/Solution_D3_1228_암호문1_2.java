package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/hw/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t =1 ; t<=10; t++) {
			sb.append("#"+t+" ");
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> originlist = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				originlist.add(Integer.parseInt(st.nextToken()));
			}
			
			int orderN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for(int i=0; i<orderN; i++) {
				st.nextToken();
				int k = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				
				
				
				for(int j=0; j<n; j++) {
					if(k>10) {
						st.nextElement();
						continue;
					}
					originlist.add(k+j, Integer.parseInt(st.nextToken()));
				}
			
			}
			
			for(int i=0; i<10; i++) {
				sb.append(originlist.get(i)+" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
