package SWEA.SWEA_7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {
	static int cnt, N, M;
	static int[][] adjMat;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			String[] inputNM = br.readLine().split(" ");
			if (inputNM.length == 2) {
				N = Integer.parseInt(inputNM[0]);
				M = Integer.parseInt(inputNM[1]);

				visited = new boolean[N + 1];
				adjMat = new int[N + 1][N + 1];
				for (int i = 0; i < M; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					adjMat[from][to] = 1;
					adjMat[to][from] = 1;
				}

				// 관계 확인해보기
				for (int i = 1; i <= N; i++) {
					if (!visited[i]) {
						dfs(i);
						cnt++;
					}
				}
			} else {
				cnt = N;
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}

	private static void dfs(int idx) {
		visited[idx] = true;
		for (int i = 1; i < adjMat.length; i++) {
			if (!visited[i] && adjMat[idx][i] == 1) {
				dfs(i);
			}
		}
	}
}
