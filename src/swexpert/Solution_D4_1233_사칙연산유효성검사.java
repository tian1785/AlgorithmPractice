package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {
	
	private static boolean isOperater(char c) {
		switch (c) {
		case '*': case '+': case '-' : case '/':
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/hw/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test=1; test<=10; test++) {
			int N = Integer.parseInt(br.readLine());
			
			int Answer = 1;
			
			char[] tree = new char[N+1];
			
			for (int i = 1;i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
				
				while(st.hasMoreTokens()) {
					st.nextToken();
				}					
				
			}
			
			int left,right;
			for (int i = 1; i <= N; i++) {
				left = 2*i;
				right = left+1;
				
				if(!Character.isDigit(tree[i])) { 
					if(left<=N && right <=N) {
						if(Character.isDigit(tree[left]) && !Character.isDigit(tree[right])) {
							Answer = 0;
							break;
						}
					}else {
						Answer = 0;
						break;
					}
				}else { // 숫자 : 자식노드가 있으면 안됨.
					if(left<=N && right <=N) {
						if(tree[left] != '\u0000' || tree[right] != '\u0000') {
							Answer = 0;
							break;
						}
					}
				}
			}
			
			System.out.println("#"+ test + " "+ Answer);
		}
		
	}

}
