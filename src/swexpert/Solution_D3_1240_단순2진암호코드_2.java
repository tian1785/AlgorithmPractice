package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/ws/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
		
		for(int test=1; test<=T; test++) {
			sb.append("#"+test+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String Amho="";
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				if(!Amho.equals("")) {
					continue;
				}else {
					for(int j=0; j<M; j++) {
						if(s.charAt(j)=='1') {
							Amho = s;
							break;
						}
					}
					
				}
			}
			
			int count =7, leng=7;
			int[] number = new int[count+1];
			int result=0;
			for(int i=M; i>=0 && count>=0; i--) {
				String target = Amho.substring(i-leng, i);
				for(int j=0; j<10; j++) {
					if(map.containsKey(target)) {
						number[count] = map.get(target);
						result += number[count--];
						i=i-leng+1;
						break;
					}
				}
			}
			
//			System.out.println(Arrays.toString(number));
			int cal = (number[0]+number[2]+number[4]+number[6])*3+(number[1]+number[3]+number[5])+number[7];
			if(cal % 10 != 0) {
				result = 0;
			}
			sb.append(result+"\n");
			
			
		}
		System.out.println(sb.toString());
	}

}
