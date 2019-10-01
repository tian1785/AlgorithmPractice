package swexpert;

import java.util.Scanner;
/*
 * �޸� : 54,988 kb
 * ����ð� : 377 ms
 */
public class Solution_D3_5431_민석이의과제체크하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		while(count++ <N) {
			int num = sc.nextInt();
			int hw = sc.nextInt();
			int[] arr = new int[num];
			for(int i=0; i<hw; i++) {
				arr[sc.nextInt()-1]=1;
			}
			
			System.out.printf("#%d ",count);
			for(int i=0; i<num; i++) {
				if(arr[i]==0) {
					System.out.print(i+1 +" ");
				}
			}
			System.out.println();
		}
		
	}

}
