package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int room = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] people = new int[room+1];
		for(int i=1; i<=room; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long Answer = room;
		for(int i=1; i<=room; i++) {
			int remain = people[i]-B;

			if(remain>0)
				Answer += (remain-1)/C +1;

		}
		System.out.println(Answer);
	}
}
