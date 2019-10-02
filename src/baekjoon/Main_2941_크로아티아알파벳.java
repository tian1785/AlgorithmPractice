package baekjoon;

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
					count-=1;
				}
				break;
			case '-':
				break;
			case 'j':
				if((i>0 && s.charAt(i-1)=='l') || (i>0 && s.charAt(i-1)=='n')) {
					
				}else {
					count++;
				}
				break;
			default:
				count++;
				break;
			}
		}
		
		System.out.println(count);
	}
}
