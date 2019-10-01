package swexpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기 {

	static LinkedList<int[]> answerlist;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			answerlist = new LinkedList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = (int)(st.nextToken().charAt(0)-'0');
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && map[i][j]>0) {
						bfs(i,j);
					}
				}
			}
			
			Collections.sort(answerlist, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2]-o2[2]==0?o1[0]-o2[0]:o1[2]-o2[2];
				}
			});
			StringBuilder sb = new StringBuilder();
			sb.append(answerlist.size()+" ");
			for(int[] arr : answerlist) {
				sb.append(arr[0]+" "+arr[1]+" ");
			}
			System.out.println("#"+test+" "+sb.toString());
		}
	}
	
	private static void bfs(int r, int c) {
		int dx[] = {1,0};
		int dy[] = {0,1};
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] {r,c});
		
		int count=0;
		int maxr =0;
		int maxc =0;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int i=0; i<2; i++) {
				int nr = current[0] + dx[i];
				int nc = current[1] + dy[i];
				if(nr<N && nc<N && map[nr][nc]!=0 && !visited[nr][nc]) {
					count++;
					visited[nr][nc]=true;
					
					queue.offer(new int[] {nr, nc});
					if(maxr<nr) maxr=nr;
					if(maxc<nc) maxc=nc;
				}
			}
		}
		answerlist.add(new int[] {maxr-r+1,maxc-c+1,count});
	}

}
