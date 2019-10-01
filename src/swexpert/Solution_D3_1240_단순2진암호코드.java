package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// String의 lastIndexOf()는 뒤에서 부터 찾아서 어떠한 문자의 위치를 찾는다
public class Solution_D3_1240_단순2진암호코드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/ws/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// Arraylist 사용 가능
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
				
				/*
				강사님 코드
				int end = s.lastIndexOf('1');
				if( end>= 0) {
					int[] v = new int[8];
					int index = 0;
					for(int j=end-55; j<end; j+=7) {
						String in = s.substring(j,j+7);
						v[index++] = map.get(in).intValue();
					}
					if(((v[0]+v[2]+v[4]+v[6])*3+v[1]+v[3]+v[5]+v[7])%10 == 0) {
						result = v[0]+v[1]+v[2]+v[3]+v[4]+v[5]+v[6]+v[7];
					}
				}*/
				
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
			
			int count =0, leng=7;
			int[] number = new int[8];
			int result=0;
			for(int i=0; i<M-leng && count<8; i++) {
				String target = Amho.substring(i, i+leng);
				for(int j=0; j<10; j++) {
					if(map.containsKey(target)) {
						if(count == 0) {
							if(!map.containsKey(Amho.substring(i+leng, i+2*leng))) {
								continue;
							}
						}
						number[count] = map.get(target);
						result += number[count++];
						i=i+leng-1;
						break;
					}
				}
			}
			
//			System.out.println(Arrays.toString(number));
			
			int cal = 0; 
			for(int i=0; i<8; i++) {
				if(i%2 == 0) {
					cal += 3*number[i];
				}else {
					cal += number[i];
				}
			}
			
//			int cal = (number[0]+number[2]+number[4]+number[6])*3+(number[1]+number[3]+number[5])+number[7];
			if(cal % 10 != 0) {
				result = 0;
			}
			sb.append(result+"\n");
			
			
		}
		System.out.println(sb.toString());
	}

}
