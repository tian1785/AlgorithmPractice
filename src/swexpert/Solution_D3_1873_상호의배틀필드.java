package swexpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {

	static char[] direction = {'^', 'v', '<', '>'};
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int tr, tc, d, W, H;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int test=1; test<=T; test++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 H = Integer.parseInt(st.nextToken());
			 W = Integer.parseInt(st.nextToken());
			 map = new char[H][W];
			 
			 for(int i=0; i<H; i++) { // 상 : 0, 하: 1, 좌:2, 우:3
				 String s = br.readLine();
				 for(int j=0; j<W; j++) {
					map[i][j] = s.charAt(j);
					 
					 
					switch (map[i][j]) {
					case '^':
						tr = i;
						tc = j;
						d = 0;
						break;
					case 'v':
						tr = i;
						tc = j;
						d = 1;
						break;
					case '<':
						tr = i;
						tc = j;
						d = 2;
						break;
					case '>':
						tr = i;
						tc = j;
						d = 3;
						break;
						
					}
				 }
			 }
			 
			 int N = Integer.parseInt(br.readLine());
			 String s = br.readLine();
			 
			 for(int i=0,size=s.length(); i<size; i++) {
				 game(s.charAt(i));
			 }
			 
			 System.out.print("#"+test+" ");
			 
			 for(int i=0; i<H; i++) {
				 for(int j=0; j<W; j++) {
					 System.out.print(map[i][j]);
				 }
				 System.out.println();
			 }
		 }
	}
	
	private static void game(char order) {
		if(order == 'S') {
			
			int r = tr;
			int c = tc;
			
			while(true) {
				int nr = r + dx[d];
				int nc = c + dy[d];
				
				if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc]=='#') break;
				
				if(map[nr][nc]=='*') {
					map[nr][nc] = '.';
					break;
				}
				
				r = nr;
				c = nc;
			}
			
		}else {
			switch (order) {
			case 'U': 
				d = 0;
				break;
				
			case 'D':
				d = 1;
				break;
				
			case 'L': 
				d = 2;
				
				break;
			case 'R':
				d = 3;
				
				break;
			}
			
			int nr = tr+dx[d];
			int nc = tc+dy[d];
			
			if(nr>=0 && nc>=0 && nr<H && nc<W && map[nr][nc] =='.') { //평지라면 한칸 이동
				map[tr][tc] = '.';
				tr = nr;
				tc = nc;
			}
			map[tr][tc] = direction[d];
		}

	}

}
