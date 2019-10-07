package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {

	static int K, N;
	static int[] len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		len = new int[K];
		long max = 0;
		for(int i=0; i<K; i++) {
			len[i] = Integer.parseInt(br.readLine());
			max += len[i];
		}
		
		max = max/N;
		
		long start = 0;
		long end = max;
		long middle =(start+end)/2;
		while(start<=end) {
			if(middle==0) break;
			
			if(check(middle)) {
				start = middle+1;
			}else {
				end = middle-1;
			}
			middle = (start+end)/2;
			
		}
		
		System.out.println(end);
	}
	
	private static boolean check(long k) { // 길이 입력
		int total=0;
		
		for(int i=0; i<K; i++) {
			total+= len[i]/k; //개수 다 더함
		}
		
		if(total<N) return false;
		
		return true;
	}
	

}
