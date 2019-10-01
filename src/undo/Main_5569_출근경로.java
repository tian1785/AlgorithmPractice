package undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5569_출근경로 {
	private static int count,W,H;
	private static int[][] map;
	private static boolean[][] visit;
	private static int[][] direction = {{1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[W][H];
		visit = new boolean[W][H];

		
		
		System.out.println(count);
	}
	


}
