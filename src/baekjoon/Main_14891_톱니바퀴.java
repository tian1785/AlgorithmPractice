package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] gears = new int[5][8];
		
		for(int i=1; i<=4; i++) { 
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i][j] = (int)(s.charAt(j)-'0'); //N극 0, S극 1
			}
		}
		
		int[] status = new int[5]; // 톱니바퀴 12시방향 
		int N = Integer.parseInt(br.readLine());
		int[][] move = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			move[i][0]= Integer.parseInt(st.nextToken()); // 바퀴번호
			move[i][1]= Integer.parseInt(st.nextToken()); // 방향
		}
		
		for(int i=0; i<N; i++) {
			int target = move[i][0]; //바퀴번호
			int direction = -move[i][1]; // 방향
			
			boolean isC = false;
			
			int k=0;
			
			while(target > 1) {
				if(gears[target][(status[target]+6)%8] != gears[target-1][(status[target-1]+2)%8]) {// 회전 가능
					
					int priork = k;
					
					if(direction>0 && status[target-1]==0){
						k = 7;
//						status[target-1] = 7;
					}else {
						k = (status[target-1]-direction)%8;
//						status[target-1] -=direction;
					}
					direction = -direction;
					
					if(isC) {
						status[target] =priork;
					}
					isC=true;
				}else {
					break;
				}
				target--;
			}
			if(isC) {
				status[target] =k;
			}
			
			isC=false;
			target = move[i][0];
			direction = -move[i][1];
			k=0;
			
			while(target < 4) {
				if(gears[target][(status[target]+2)%8] != gears[target+1][(status[target+1]+6)%8]) {// 회전 가능
					
					int priork = k;
					
					if(direction>0 && status[target+1]==0){
						k = 7;
//						status[target-1] = 7;
					}else {
						k =(status[target+1]-direction)%8;
//						status[target-1] -=direction;
					}
					direction = -direction;
					
					if(isC) {
						status[target] =priork;
					}
					
					isC=true;
				}else {
					break;
				}
				target++;
			}
			if(isC) {
				status[target] =k;
			}
			
			target = move[i][0];
			direction = -move[i][1];
			if(direction<0 && status[target]==0) {
				status[target] = 7;
			}else {
				status[target]=(status[target]+direction)%8;
			}
		}
		// 점수들의 합 구하기
		int answer = 0;
		for(int i=1; i<5; i++) {
//			System.out.println(gears[i][status[i]]);
			answer += gears[i][status[i]]*Math.pow(2, i-1);
		}
		
		System.out.println(answer);
	}

}
