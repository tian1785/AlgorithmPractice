package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/hw/input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<10; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#"+N+" ");
			Queue<Integer> crypto = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<8; i++) {
				crypto.offer(Integer.parseInt(st.nextToken()));
			}
			first:
			while (true) {
				for (int i = 1; i <= 5; i++) {
					int current = crypto.poll();
					if(current-i <= 0) {
						current = 0;
						crypto.offer(current);
						break first;
					}
					crypto.offer(current-i);
				} 
			}
			// 출력
			while(!crypto.isEmpty()) {
				sb.append(crypto.poll()+" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
