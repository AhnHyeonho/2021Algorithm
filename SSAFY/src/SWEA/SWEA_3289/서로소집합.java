package SWEA.SWEA_3289;

import java.util.Scanner;

public class 서로소집합 {

	static int[] parents;
	static int n, m;

	// 모든 원소를 자신을 대표자로 만듦.
	private static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false; // 이미 같은 집합이므로

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			n = sc.nextInt()+1;
			m = sc.nextInt();
			parents = new int[n];
			make();
			for (int i = 0; i < m; i++) {
				int calc = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				switch (calc) {
				case 0:
					union(a, b);
					break;

				case 1:
					if (find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
					break;
				}
			}
			System.out.printf("#%d %s\n", test_case, sb.toString());
		}
		sc.close();
	}
}
