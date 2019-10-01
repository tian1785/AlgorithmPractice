package swexpert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/Flatten.txt"));
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; ++t) {
			int dump = sc.nextInt();
			int gap = -1;

			int[] box = new int[100];

			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}

			
			while (dump-- > 0) {

				
				if (gap == 0 || gap ==1)
					break;
				
				box[99]--;
				box[0]++;
				
				Arrays.sort(box);
				gap = box[99] - box[0];
			}
			System.out.printf("#%d %d\n", t, gap);

		}
	}

}
