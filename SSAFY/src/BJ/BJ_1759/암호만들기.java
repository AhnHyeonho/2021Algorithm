package BJ.BJ_1759;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int N = sc.nextInt();
		char[] arr = new char[N];
		sc.nextLine();
		String[] line = sc.nextLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = line[i].charAt(0);
		}
		Arrays.sort(arr);
		permutation(arr, new char[length], 0, new boolean[N]);
		System.out.println(cnt);
	}

	private static void permutation(char[] arr, char[] sel, int k, boolean[] visited) {
		cnt++;
		if (k == sel.length) {
			String str = new String(sel);
			int consonantCnt = 0;
			int vowelCnt = 0;
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					// 모음
					vowelCnt++;
					break;
				default:
					// 자음
					consonantCnt++;
					break;
				}
			}
			if (consonantCnt < 2 || vowelCnt < 1)
				return;
			System.out.println(str);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (k == 0) {
				visited[i] = true;
				sel[k] = arr[i];
				permutation(arr, sel, k + 1, visited);
				visited[i] = false;
			} else if (sel[k - 1] < arr[i] && visited[i] == false) {
				visited[i] = true;
				sel[k] = arr[i];
				permutation(arr, sel, k + 1, visited);
				visited[i] = false;
			}
		}
	}
}
