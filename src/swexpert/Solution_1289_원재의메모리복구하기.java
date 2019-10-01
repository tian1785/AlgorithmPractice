package swexpert;
import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int n=1;n<=N;n++) {
			String origin = sc.next().trim();
			int count=0;
			if(origin.startsWith("1")) count++;
			
			for(int i=1; i<origin.length();++i) {
				if(origin.charAt(i-1)!=origin.charAt(i)) count++;
			}
			System.out.println("#"+n+" "+count);
		}
	}

}
