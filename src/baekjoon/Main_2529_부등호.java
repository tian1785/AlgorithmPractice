package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2529_부등호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] booho = new char[N];
		
		
		for(int i=0; i<N; i++) {
			booho[i] = st.nextToken().charAt(0);
		}
		
		int[] small = new int[N+1];
		
		boolean isE = false;
		int count=0;
		//최소값 구하기
		for(int i=0; i<N; i++) {
			
			if(booho[i]=='<') {
				small[i] = i;
			}else {
				int idx = i;
				count=0;
				while(idx<N && booho[idx]=='>') {
					count++;
					idx++;
				}
				while(count-->0) {
					small[i++] = idx--;
				}
				small[i] = idx;
				
				if(i==N) {
					isE=true;
				}
			}
		}
		
		if(!isE) {
			small[N]= N;
		}
		
//		System.out.println(Arrays.toString(small));
		
		//최대값 구하기
		int[] big = new int[N+1];
		
		isE = false;
		int cur = 9;
		
		for(int i=0; i<N; i++) {

			if(booho[i]=='<') {
				
				count = 0;
				int idx = i;
				
//				System.out.println("i :"+i);
				
//				System.out.println("1. idx :"+idx );
				while(idx<N && booho[idx++]=='<') {
//					System.out.println("2. idx :"+idx );
					count++;
					cur--;
				}
				
				int start = cur--;
				
//				System.out.println("count :"+count);
//				System.out.println("start :" +start);
				
				while(count-->0) {
					big[i++] = start++;
				}
				
				big[i] = start;
				
				if(i==N) {
					isE=true;
				}
				
			}else {
				big[i] = cur--;
			}
			
		}
		
		if(!isE) {
			big[N]= cur;
		}
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N+1; i++) {
			sb.append(big[i]);
		}
		
		System.out.println(sb.toString());
		sb.setLength(0);
		
		for(int i=0; i<N+1; i++) {
			sb.append(small[i]);
		}
		
		System.out.println(sb.toString());
		
//		System.out.println(Arrays.toString(small));
//		System.out.println(Arrays.toString(big));
		
	}

}
