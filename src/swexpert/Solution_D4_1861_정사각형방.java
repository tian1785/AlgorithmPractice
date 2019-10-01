package swexpert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {

	static int N;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int maxNum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int temp = move(i, j, map[i][j]);
					if(temp>max) {
						max = temp;
						maxNum = map[i][j];
					}else if(temp==max) {
						if(map[i][j]<maxNum) {
							maxNum = map[i][j];
						}
					}
				}
			}
			
			System.out.println("#"+test+" "+maxNum+" "+max);
		}
	}
	
	
	
	private static int move(int r, int c, int num) {
		int count = 1;
		int next = num+1;
		boolean isMove;
		
		while(true) {
			isMove = false;
			for(int d=0; d<4; d++) {
				int nr = r + dx[d];
				int nc = c + dy[d];
				if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]==next) { //이동 가능
					isMove=true;
					r = nr;
					c = nc;
					next++;
					count++;
					break;
				}
			}
			
			if(!isMove) {
				break;
			}
		}
		return count;
		
	}

}
