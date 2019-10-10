package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {

	static int N, Answer;
	static int[] people;
	static boolean[] selected;
	static int[][] city;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		city = new int[N][N];
		selected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				int tmp = Integer.parseInt(st.nextToken())-1;
				city[i][tmp] = city[tmp][i] = 1;
			}
		} // 입력 완료
		Answer = Integer.MAX_VALUE;
		
		divide(0,0);
		
		if(Answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(Answer);
		}
	}
	
	private static void divide(int idx, int count) {
		if(idx==N) {
			if(count!=0 && count!=N) { //모두 선택, 모두 비선택
				if(check()) { // 만들 수 있는 경우의 수
					int a=0, b=0;
					for(int i=0; i<N; i++) {
						if(selected[i]) {
							a+=people[i];
						}else {
							b+=people[i];
						}
					}
					
					int tmp = Math.abs(a-b);
					if(tmp<Answer) {
						Answer = tmp;
					}
				}
			}
			
			return;
		}
		selected[idx] = true;
		divide(idx+1, count+1);
		selected[idx] = false;
		divide(idx+1, count);
		
	}
	
	private static boolean check() { // bfs
		ArrayList<Integer> select = new ArrayList<>();
		ArrayList<Integer> unselect = new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(selected[i]) select.add(i);
			else unselect.add(i);
		}

		boolean[] visit = new boolean[N];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(select.get(0));
		visit[select.get(0)] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=0; i<N; i++) {
				if(selected[i] && city[current][i]==1 && !visit[i]) { //인접노드 큐에 넣기
					queue.offer(i);
					visit[i]=true;
				}
			}
		}
		
		queue.offer(unselect.get(0));
		visit[unselect.get(0)] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=0; i<N; i++) {
				if(!selected[i] && city[current][i]==1 && !visit[i]) { //인접노드 큐에 넣기
					queue.offer(i);
					visit[i]=true;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		
		return true;
	}

}
