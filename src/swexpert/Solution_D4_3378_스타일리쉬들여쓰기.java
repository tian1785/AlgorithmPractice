package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기 {
	static class Brackets{
		int s;
		int m; 
		int l;
		int answer;
		public Brackets(int s, int m, int r) {
			super();
			this.s = s;
			this.m = m;
			this.l = r;
		}
		public int getS() {
			return s;
		}
		public void setS(int s) {
			this.s = s;
		}
		public int getM() {
			return m;
		}
		public void setM(int m) {
			this.m = m;
		}
		public int getL() {
			return l;
		}
		public void setL(int r) {
			this.l = r;
		}
		public int getAnswer() {
			return answer;
		}
		public void setAnswer(int answer) {
			this.answer = answer;
		}
		
	}
	//R(a – b) + C(c – d) + S(e – f)
	// a: (, b: ), c:{, d:}, e:[, f:]
	static int N, M;
	static int[] rcs, result;
	static Brackets[] example,my;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		rcs = new int[3];
		StringTokenizer st = null;
		for(int test=1; test<=T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = new int[M];
			Arrays.fill(result, -10);
			int s=0,m=0,l=0;
			
			example = new Brackets[N];
			my = new Brackets[M];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				int count = 0;
				for(int j=0, size=line.length();j<size;j++) {
					if(line.charAt(j)=='.') count++;
					else break;
 				}
				for(int j=count, size=line.length();j<size;j++) {
					if(line.charAt(j)=='(') s++;
					else if(line.charAt(j)==')') s--;
					else if(line.charAt(j)=='{') m++;
					else if(line.charAt(j)=='}') m--;
					else if(line.charAt(j)=='[') l++;
					else if(line.charAt(j)==']') l--;
					
				}
				
				if(i<N-1) {
					example[i+1] = new Brackets(s, m, l);
				}
				if(i>0) example[i].setAnswer(count);
				
			}	
			
			s=m=l=0; //내 코드 괄호 개수 구하기
			for(int i=0; i<M; i++) {
				String line = br.readLine();
				for(int j=0, size=line.length();j<size;j++) {
					if(line.charAt(j)=='(') s++;
					else if(line.charAt(j)==')') s--;
					else if(line.charAt(j)=='{') m++;
					else if(line.charAt(j)=='}') m--;
					else if(line.charAt(j)=='[') l++;
					else if(line.charAt(j)==']') l--;
				}
				
				if(i<M-1) {
					my[i+1] = new Brackets(s, m, l);
				}
			}
			
			permutation(0);
			
			System.out.print("#"+test+" 0 ");
			for(int i=1; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		
	}
	
	private static void permutation(int idx) {
		if(idx==3) { //3개 뽑았을 경우
			
			boolean isP=true;
			for(int i=1; i<N; i++) {
				Brackets b = example[i];
				int k = rcs[0] * b.getS()+ rcs[1]*b.getM() + rcs[2]*b.getL();
				if(k!=b.getAnswer()) {
					isP = false;
					break;
				}
			}
			if(isP) {
				for(int i=1; i<M; i++) {
					if(result[i] == -1) continue;
					int k= rcs[0]*my[i].getS()+rcs[1]*my[i].getM()+rcs[2]*my[i].getL();
					if(result[i] != -10 && result[i] != k) {
						result[i] = -1;
					}else {
						result[i] = k;
					}
				}
				
//				System.out.println("R :"+R+", C:"+C+", S:"+S);
			}
			return;
		}
		
		for(int i=1; i<=20; i++) {
			rcs[idx] = i;
			permutation(idx+1);
		}
	}

}
