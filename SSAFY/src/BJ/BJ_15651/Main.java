package BJ.BJ_15651;

import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		permutation(0);
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 가능한 모든 수 시도
		for (int i = 1; i <= N; i++) {
			numbers[cnt] = i;
			// 다음 자리순열 뽑으로 gogo
			permutation(cnt + 1);
		}
	}
}
