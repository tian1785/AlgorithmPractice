package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] used = new boolean[N];
		int[][] C = new int[N][2];
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			C[i][0] = Integer.parseInt(st.nextToken());
			C[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(C, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		}); //최고 온도 기준으로 오름차순 정렬
		
		int Answer=1;
		
		for(int i=0; i<N; i++) {
			int cmax = C[i][1];
			
			for(int j=i+1; j<N; j++) {
				if(cmax<C[j][0]) { // 기존 냉장고 사용 불가능
					Answer++; // 냉장고 한대 추가해야함
					break;
				}
				i++;
			}
			
		}
		
		
		System.out.println(Answer);
	}

}
