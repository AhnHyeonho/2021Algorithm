package BJ.BJ_15649;

import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		isSelected = new boolean[N];
		numbers = new int[R];

		permutation(0);
		sc.close();
	}

	private static void permutation(int cnt) {
		if (cnt == R) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R; i++) {
				sb.append(numbers[i]).append(" ");
			}

			System.out.println(sb.toString());
			return;
		}
		// 가능한 모든 수들이 들어있는 배열모든 원소에 대해 시도
		for (int i = 0; i < N; i++) { // i : 인덱스
			if (isSelected[i])
				continue; // 인덱스에 해당하는 수가 사용중인 수면 다음 수로.

			numbers[cnt] = input[i];
			isSelected[i] = true;

			// 다음 자리순열 뽑으로 gogo
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
