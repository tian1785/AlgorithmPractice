package im대비undo;

import java.util.Scanner;

public class Main_2941_크로아티아알파벳 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int count=0;
		String s = sc.nextLine();
		int len = s.length();
		for(int i=0; i<len; i++) {
			switch (s.charAt(i)) {
			case '=':
				if(i>1 && s.charAt(i-1)=='z' && s.charAt(i-2)=='d') {
					count-=2;
				}
				break;
		

			default:
				break;
			}
		}
	}
}
