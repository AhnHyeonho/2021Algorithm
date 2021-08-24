package BJ.BJ_14502;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소 {
	static int R, C, zeroCnt;
	static int[][] map;
	static int[] dr = { 0, 0, 1, -1 }; // 동서남북
	static int[] dc = { 1, -1, 0, 0 };
	static ArrayList<Loc> zeroLocs;
	static ArrayList<Loc> virusLocs;
	static int maxZeroCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		zeroLocs = new ArrayList<Loc>();
		virusLocs = new ArrayList<Loc>();
		zeroCnt = 0;
		maxZeroCnt = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					zeroCnt++;
					zeroLocs.add(new Loc(i, j));
				} else if (map[i][j] == 2) {
					virusLocs.add(new Loc(i, j));
				}
			}
		}

		/*
		 * zeroLoc 중 3개 선택 후, 각 바이러스로부터 퍼져나가는 경로 검색.
		 */

		solve(new Loc[3], 0, 0);
		System.out.println(maxZeroCnt);
		sc.close();
	}

	static int ccc = 0;

	private static void solve(Loc[] sel, int idx, int k) {
		if (k == sel.length) {
			ccc++;
			// 각 바이러스로부터 퍼져나가는 경로 검색
			int[][] tmap = mapCopy(map);
			for (Loc loc : sel) {
				tmap[loc.r][loc.c] = 1;
			} // 벽 세우기
			
			infection(tmap);

			return;
		}

		for (int i = idx; i < zeroLocs.size(); i++) {
			sel[k] = zeroLocs.get(i);
			solve(sel, i + 1, k + 1);
		}
	}

	private static void infection(int[][] map) {
		//System.out.println(ccc+ " 돌고있어요");
		int[][] tmap = mapCopy(map);
		Queue<Loc> curVirusLocs = new LinkedList<Loc>();
		for (Loc curVi : virusLocs) {
			curVirusLocs.add(curVi);
		}

		while (!curVirusLocs.isEmpty()) {
			Loc curVirus = curVirusLocs.poll();
			int r = curVirus.r;
			int c = curVirus.c;
			// 바이러스마다 사방 탐색
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && tmap[nr][nc] == 0) {
					tmap[nr][nc] = 2;
					curVirusLocs.add(new Loc(nr, nc));
				}
			}
		}
		int curZeroCnt = 0;
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[0].length; j++) {
				if (tmap[i][j] == 0) {
					curZeroCnt++;
				}
			}
		}
		maxZeroCnt = Math.max(maxZeroCnt, curZeroCnt);

	}

	private static int[][] mapCopy(int[][] map) {
		int[][] tmap = new int[map.length][map[0].length];
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[0].length; j++) {
				tmap[i][j] = map[i][j];
			}
		}
		return tmap;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Loc {
	int r;
	int c;

	public Loc(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Loc [c=" + c + ", r=" + r + "]";
	}
}