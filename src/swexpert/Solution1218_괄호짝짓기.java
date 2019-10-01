package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/hw/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1;t<=12;t++) {
			int Answer = 1;
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<N; i++) {
				char now=s.charAt(i);
				if(now =='(' ||now =='[' ||now =='{' ||now =='<') {
					stack.push(now);
				}else {
					char prior='0';
					if(!stack.isEmpty())
						prior = stack.peek();
					else prior='0';
					
					if((prior=='(' && now==')')||(prior=='[' && now==']')||
						(prior=='{' && now=='}')|(prior=='<' && now=='>')){
						stack.pop();
					}else {
						Answer=0;
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				Answer=0;
			}
				
			
			System.out.println("#"+t+" "+Answer);
		}
	}

}
