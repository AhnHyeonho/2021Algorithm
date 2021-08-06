package BJ.BJ_15650;

import java.util.Scanner;

public class Main {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		int[] sel = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		combination(arr, sel, 0, 0);
	}

	private static void combination(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[k] = arr[i];
			combination(arr, sel, i + 1, k + 1);
		}
	}
}
