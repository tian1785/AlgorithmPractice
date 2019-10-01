package baekjoon;

import java.util.Scanner;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		sc.nextLine();
		
		for(int t=0; t<T; t++) {
			String s = sc.nextLine();
			
			int size = s.length();
			
			int jumsu = 0;
			int result = 0;
			for(int i=0; i<size; i++) {
				if(s.charAt(i)=='O') {
					jumsu++;
					result +=jumsu;
				}else {
					jumsu = 0;
				}
			}
			
			System.out.println(result);
			
		}
	}

}
