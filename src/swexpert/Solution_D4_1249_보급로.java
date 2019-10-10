package swexpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1249_보급로 {

	static int N;
	static final int INF = 99999999;
	static int[][] map, D;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			D = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				Arrays.fill(D[i], INF);
				for(int j=0; j<N; j++) {
					map[i][j] = (int) (s.charAt(j)-'0');
				}
			}
			D[0][0] = 0;
			bfs();
			
			System.out.println("#"+test+" "+D[N-1][N-1]);
		}
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					int nd = D[current[0]][current[1]] + map[nr][nc];
					if(nd<D[nr][nc]) {
						D[nr][nc] = nd;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}

}
