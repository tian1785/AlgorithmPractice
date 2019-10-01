package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_8980_택배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int[] truck = new int[N+1];
		
		int[][] info = new int[M][3];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		int Answer=0;
		
		Arrays.sort(info, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1]!=0?o1[1]-o2[1]:o1[0]-o2[0];
			}
		});
		
		
		for(int i=0; i<M; i++) {
			System.out.println(Arrays.toString(info[i]));
		}
		
		
		
		for(int i=0; i<M; i++) {
			
			int max = 0;
			for(int j=info[i][0]; j<info[i][1]; j++) {
				max = Math.max(max, truck[j]);
			}
			
			int p = Math.min(C-max, info[i][2]);
			Answer += p;
			
			for(int j=info[i][0]; j<info[i][1]; j++) {
				truck[j] +=p;
			}
			
		}
		
		
		System.out.println(Answer);
	}
}
