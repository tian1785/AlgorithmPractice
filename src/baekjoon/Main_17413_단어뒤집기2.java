package baekjoon;

import java.util.Scanner;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String word = "";
		StringBuilder sb = new StringBuilder();
		StringBuilder tword = new StringBuilder();
		for(int i=0, size=s.length(); i<size; i++) {
			if(s.charAt(i)=='<') { //태그는 뒤집으면 안됨
				if(tword.length()!=0) {
					String temp = tword.toString();
					tword.setLength(0);
					for(int j=temp.length()-1;j>=0; j--) {
						sb.append(temp.charAt(j));
					}
//					sb.append(' ');
				}
				
				int starti = i;
				while(s.charAt(i)!='>') {
					i++;
				}
				sb.append(s.substring(starti, i+1));
			}else if(s.charAt(i)==' ') {
				String temp = tword.toString();
				tword.setLength(0);
				for(int j=temp.length()-1;j>=0; j--) {
					sb.append(temp.charAt(j));
				}
				sb.append(' ');
				
			}else {
				tword.append(s.charAt(i));
			}
		}
		
		if(tword.length()!=0) {
			String temp = tword.toString();
			for(int j=temp.length()-1;j>=0; j--) {
				sb.append(temp.charAt(j));
			}
//			sb.append(' ');
		}
		
		System.out.println(sb.toString());
	}

}
