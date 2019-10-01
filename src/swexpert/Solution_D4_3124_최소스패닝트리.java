package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


/*
 * LinkedList : 시간 초과
 * ArrayList :  120,548 kb 메모리  1,603 ms 실행시간 
 * 배열1 :  122,872 kb 메모리  1,756 ms 실행시간 
 * 배열2 :  124,256 kb 메모리  1,826 ms 실행시간 
*/
public class Solution_D4_3124_최소스패닝트리 {

	static int[] parents;
	
	private static int find(int a) {
		if(parents[a]<0) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
//			ArrayList<int[]> list = new ArrayList<>();
			int[][] edges = new int[E][3];
			
			parents = new int[V+1];
			Arrays.fill(parents, -1); // Tree 초기값 설정
			
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
//				int[] temp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
//				list.add(temp);
				edges[i][0] = Integer.parseInt(st.nextToken());
				edges[i][1] = Integer.parseInt(st.nextToken());
				edges[i][2] = Integer.parseInt(st.nextToken());
			}
			
			long Answer = 0;
			
			Arrays.sort(edges, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
//					Integer.compare(o1[2], o2[2]);  비교하는 메서드
					return o1[2]-o2[2];
				}
			});
//			Collections.sort(list, new Comparator<int[]>() {
//				public int compare(int[] o1, int[] o2) {
//					return o1[2]-o2[2];
//				}
//			});
			
			int count = 0;
			for(int i=0; i<E; i++) {
				if(union(edges[i][0],edges[i][1])) {
					count++;
					Answer+=edges[i][2];
				}
				
				if(count==V-1) break;
			}
//			for(int i=0; i<E; i++) {
//				if(union(list.get(i)[0],list.get(i)[1])) {
//					count++;
//					Answer+=list.get(i)[2];
//				}
//				
//				if(count==V-1) break;
//			}
			
			
			
			System.out.println("#"+test+" "+Answer);
		}
	}

}
