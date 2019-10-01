package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution5432_쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/ws/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int Answer;
		for (int test=1; test<=T; ++test) {
			Answer=0;
			String input = br.readLine();
			Stack<Character> saved = new Stack<>();
			
			int counter=0;
			for(int i=0; i<input.length();i++) {
				char now = input.charAt(i);
				if(now=='(') {
					counter++;
					saved.push(now);
				}else if(now==')') {
					if(saved.peek()=='(') { //레이저 인 경우
						Answer+=--counter;						
					}else {
						Answer++;
						if(counter>0) {
							counter--;
						}
					}
					saved.push(now);					
				}
			}
			
			System.out.println("#"+test+" "+Answer);
		}	
	}
}
