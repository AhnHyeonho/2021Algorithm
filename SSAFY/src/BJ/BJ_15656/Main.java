package BJ.BJ_15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permutation(arr, new int[M], 0, visited);
		System.out.println(sb.toString());
		sc.close();
	}

	private static void permutation(int[] arr, int[] sel, int k, boolean[] visited) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// 고른값을 sel 배열에 넣고 다음 인덱스 제귀호출
			sel[k] = arr[i];
			permutation(arr, sel, k + 1, visited);
			// 되돌아 가면서 방문배열 원복
		}
	}
}
