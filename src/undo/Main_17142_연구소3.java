package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {

	static class Virus{
		int r;
		int c;
		int time; //몇번째 자리인지 표시
		public Virus(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static ArrayList<Virus> list;
	static int N,CN, CR, zero, Answer;
	static int[] selected;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		CR = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		selected = new int[CR];
		list = new ArrayList<>();
		visited = new boolean[N][N];
		zero=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Virus(i,j, 0));
				}
				if(map[i][j]!=1) {
					zero++; //퍼져야 되는 곳들의 개수
				}
			}
		} // 입력 완료
		
		CN = list.size();
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	private static void infection(int[] arr) { //bfs
		int count = 0;
		int time = 0;
		Queue<Virus> queue = new LinkedList<>();
		for(int i=0; i<CR; i++) {
			queue.offer(list.get(i)); // Queue에 저장
			visited[list.get(i).r][list.get(i).c] = true;
			count++;
		}
		
		while(!queue.isEmpty()) {
//			int qsize = queue.size();
//			while(qsize-->0) {
				Virus current = queue.poll();
				time = current.time;
				
				for(int i=0; i<4; i++) {
					int nr = current.r + dx[i];
					int nc = current.c + dy[i];
					
					if(nr<N && nc<N && nr>=0 && nc>=0 && !visited[nr][nc]) {
						if(map[nr][nc]==0) { 
							// 빈 칸일 때
							visited[nr][nc] = true;
							queue.offer(new Virus(nr, nc, current.time+1));
							count++;
						}else if(map[nr][nc]==2) {
							visited[nr][nc] = true;
							queue.offer(new Virus(nr, nc, current.time));
							count++;
						}
					}
				}
				
//			}
			
		}
		
		if(count!=zero) {
			time = -1;
		}
		
		if(time !=-1 && time<Answer) {
			Answer = time;
		}
		
	}
	
	private static void combination(int idx, int count) {
		if(count==CR) { //조합 완료
			infection(selected);
		}
		
		if(idx<CN) {
			selected[count] = idx; // idx 선택
			combination(idx+1, count+1);
			
			combination(idx+1, count);
		}
		
	}
	
}
