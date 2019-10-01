package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Union-Find
 * 1) Make Set
 * 2) find-set : 자신의 대표자(Root) 찾기
 * 3) union-set : 두 집합의 대표자를 이용하여 합치기
*/

public class Main_Jungol_1863_종교 {
	static int[] parents;
	private static int find(int a) {
		if(parents[a]<0) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[aRoot] +=parents[bRoot];
		parents[bRoot] = aRoot; 
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		Arrays.fill(parents, -1);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int Answer =0;
		for(int i=1; i<=N; i++) {
			if(parents[i]<0) Answer++;
		}
		
		System.out.println(Arrays.toString(parents));
		System.out.println(Answer);
	}

}
