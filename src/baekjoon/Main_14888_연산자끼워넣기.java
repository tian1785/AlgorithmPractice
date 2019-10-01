package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

	static int Min, Max, N;
	static int[] number, operator;
	static boolean[] used;
//	static char[]  oper = {'+','-','x','/'};
	
	public static int calculate(int a, int b, int oper) {
		int result =0;
		if(oper == 0) {
			result = a+b;
		}else if(oper == 1) {
			result = a-b;
		}else if(oper ==2) {
			result = a*b;
		}else if(oper ==3) {
			result = a/b;
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[N-1];
		used = new boolean[N-1];
		st = new StringTokenizer(br.readLine());
		int c=0;
		for(int i=0; i<4; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(num-- > 0) {
				operator[c++] = i;
			}
		}
		
		Min=Integer.MAX_VALUE;
		Max=Integer.MIN_VALUE;
		
		cal(0, number[0]);
		System.out.println(Max);
		System.out.println(Min);
	}

	
	private static void cal(int count, int result) {
		if(count==N-1) {		//돌아오기
			if(result<Min) {
				Min = result;
			}
			if(result>Max) {
				Max = result;
			}
		}
		
		for(int i=0; i<N-1; i++) {
			if(!used[i]) {
				used[i]=true;
				int r = calculate(result,number[count+1],operator[i]);
				cal(count+1, r);
				used[i]=false;
			}
			
		}
		
	}

}
