package swexpert;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_3074_입국심사 {
	
	static int N,M;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			time = new int[N];
			
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				time[i] = sc.nextInt();
				min = Math.min(min, time[i]);
			}
			
			long end = min * (long)M;
			long start=0;
			long middle = (start+end)/2;
			
			while(start <= end) {
				if(Scan(middle)) {
					end = middle-1;
				}else {
					start = middle+1;
				}
				middle = (start+end)/2;
				
				
			}
			
			
			System.out.println("#"+test_case+" "+start);
		}
	}
	
	private static boolean Scan(long k) {
		long a=0;
		for(int i=0; i<N; i++) {
			a+=k/time[i];
		}
		
		if(a<M) return false;
		return true;
	}

}
