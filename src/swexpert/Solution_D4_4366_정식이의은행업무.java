package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_4366_정식이의은행업무 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			String binumber = br.readLine();
			String trinumber = br.readLine();
			
			char[] bi = binumber.toCharArray();
			char[] tri = trinumber.toCharArray();
			
			long b=0, t;
			first:
			for(int i=0,bsize=bi.length; i<bsize; i++) {
				if(bi[i]=='0') {
					bi[i] = '1';
					b=Long.parseLong(new String(bi),2);
					bi[i] = '0';
				}else {
					bi[i] = '0';
					b=Long.parseLong(new String(bi),2);
					bi[i] = '1';
				}
				
				for(int j=0, tsize=tri.length; j<tsize; j++) {
					if(tri[j]=='0') {
						tri[j] = '1';
						t=Long.parseLong(new String(tri),3);
						
						if(b==t) break first;
						
						tri[j] = '2';
						t=Long.parseLong(new String(tri),3);
						
						if(b==t) break first;
						
						tri[j] = '0';
					}else if(tri[j]=='1'){
						tri[j] = '0';
						t=Long.parseLong(new String(tri),3);
						
						if(b==t) break first;
						
						tri[j] = '2';
						t=Long.parseLong(new String(tri),3);
						
						if(b==t) break first;
						
						tri[j] = '1';
					}else {
						tri[j] = '0';
						t=Long.parseLong(new String(tri),3);
						
						if(b==t) break first;
						
						tri[j] = '1';
						t=Long.parseLong(new String(tri),3);
						
						if(b==t) break first;
						
						tri[j] = '2';
					}
					
				}
			}
			
			
			System.out.println("#"+test+" "+b);
		}
	}

}
