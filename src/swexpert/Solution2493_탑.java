package swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2493_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] result = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			for(int j = i-1; j>=0; j--) {
				if(input[i]<input[j]) {
					result[i] = j+1;
					break;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.write(result[i]+" ");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}

}
