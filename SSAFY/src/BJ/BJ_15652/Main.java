package BJ.BJ_15652;

import java.util.Scanner;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		combination(arr,new int[M],0,0);
		System.out.println(sb.toString());
		sc.close();
	}

	private static void combination(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(arr, sel, i, k + 1);
		}
	}

}
