package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_8980_택배2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			info[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		int Answer=0;
		
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=N; j++) {
//				System.out.print(info[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		LinkedList<int[]> list = new LinkedList<>();
		int current =0;
		for(int i=1; i<=N; i++) {
			
			for(int l=0; l<list.size(); l++) {
				if(list.get(l)[1] == i) {
					current-= list.get(l)[2];
					list.remove(l);
					l--;
				}
			}
			
			int k = i+1;
			while(current<=C && k<=N) {
				if(current+info[i][k]>C) {
					int remain=C-current;
					current += remain;
					Answer +=remain;
					list.add(new int[] {i,k,remain});
				}else {
					current +=info[i][k];
					Answer += info[i][k];
					list.add(new int[] {i,k,info[i][k]});
				}
				k++;
			}
		}
		
		System.out.println(Answer);
	}
}
