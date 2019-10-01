package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D5_만화책정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
//			Stack<Integer> stack = new Stack<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count=1;
//			int visited = 0;
			int[] input = new int[N];
			int[] newarr = new int[N+1];
			boolean[] sorted = new boolean[N];
			
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				newarr[input[i]]=i;
			}

			for(int i=1; i<N; i++) {
				if(newarr[i]>newarr[i+1]) {
					count++;
				}
			}
			
			
			
			
/*			first:
			while(true) {
				int min = 0;

				for(int i=0; i<N; i++) {
					if(!sorted[i] && input[i]>min) {
						min = input[i];
						sorted[i] = true;
						visited++;
					}
					
					if(visited == N) {
						count++;
						break first;
					}
					
					if(i==N-1) {
						count++;
						continue first;
					}
					
				}
				
			}*/
//			
//			for(int i=0; i<N; i++) {
//				int current = Integer.parseInt(st.nextToken());
//
//				while(!stack.isEmpty() && stack.peek()<current) stack.pop();
//				
//				if(!stack.isEmpty()) {
//					
//				}
//				
//				stack.push(i);
//				
//			}
			
			System.out.println("#"+test+" "+count);
		}
	}

}
