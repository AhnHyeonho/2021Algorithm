package SWEA.SWEA_1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 상호의 배틀필드
public class Main {
	static int tankLocationRow = 0;
	static int tankLocationCol = 0;
	static int h, w;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day20210804/SWEA1873/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				map[i] = s.toCharArray();
			}

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String ss = br.readLine();
			char[] commands = ss.toCharArray();
			findCurTankPosition(); // 탱크 초기 위치 확인
			for (int i = 0; i < N; i++) {
				switch (commands[i]) {
				case 'U': // 위 바라보고 갈 수 있으면 1칸 전진
					map[tankLocationRow][tankLocationCol] = '^';
					move();
					break;
				case 'D': // 아래 바라보고 갈 수 있으면 1칸 전진
					map[tankLocationRow][tankLocationCol] = 'v';
					move();
					break;
				case 'L': // 좌측 바라보고 갈 수 있으면 1칸 전진
					map[tankLocationRow][tankLocationCol] = '<';
					move();
					break;
				case 'R': // 우측 바라보고 갈 수 있으면 1칸 전진
					map[tankLocationRow][tankLocationCol] = '>';
					move();
					break;
				case 'S': // 현재 바라보고 있는 위치로부터 포탄이 날라가는 궤적에 따라 폭발처리
					shoot();
					break;
				}
			}

			System.out.printf("#%d ", test_case);
			printMap(map);
		}
	}

	private static void shoot() {
		char tankPosition = map[tankLocationRow][tankLocationCol];
		int shellPositionRow;
		int shellPositionCol;
		switch (tankPosition) {
		case '^':
			shellPositionRow = tankLocationRow;
			shellPositionCol = tankLocationCol;
			while (true) {
				--shellPositionRow;
				if (shellPositionRow < 0) // 범위를 벗어나면
					return;
				else {
					switch (map[shellPositionRow][shellPositionCol]) {
					case '.':
						continue;
					case '-':
						continue;
					case '#':
						return;
					case '*':
						map[shellPositionRow][shellPositionCol] = '.';
						return;
					}
				}
			}
		case 'v':
			shellPositionRow = tankLocationRow;
			shellPositionCol = tankLocationCol;
			while (true) {
				++shellPositionRow;
				if (shellPositionRow >= h) // 범위를 벗어나면
					return;
				else {
					switch (map[shellPositionRow][shellPositionCol]) {
					case '.':
						continue;
					case '-':
						continue;
					case '#':
						return;
					case '*':
						map[shellPositionRow][shellPositionCol] = '.';
						return;
					}
				}
			}
		case '<':
			shellPositionRow = tankLocationRow;
			shellPositionCol = tankLocationCol;
			while (true) {
				--shellPositionCol;
				if (shellPositionCol < 0) // 범위를 벗어나면
					return;
				else {
					switch (map[shellPositionRow][shellPositionCol]) {
					case '.':
						continue;
					case '-':
						continue;
					case '#':
						return;
					case '*':
						map[shellPositionRow][shellPositionCol] = '.';
						return;
					}
				}
			}
		case '>':
			shellPositionRow = tankLocationRow;
			shellPositionCol = tankLocationCol;
			while (true) {
				++shellPositionCol;
				if (shellPositionCol >= w) // 범위를 벗어나면
					return;
				else {
					switch (map[shellPositionRow][shellPositionCol]) {
					case '.':
						continue;
					case '-':
						continue;
					case '#':
						return;
					case '*':
						map[shellPositionRow][shellPositionCol] = '.';
						return;
					}
				}
			}
		}
	}

	private static void move() {
		switch (map[tankLocationRow][tankLocationCol]) {
		case '^':
			if (tankLocationRow - 1 >= 0 && map[tankLocationRow - 1][tankLocationCol] == '.') {
				map[tankLocationRow][tankLocationCol] = '.';
				map[--tankLocationRow][tankLocationCol] = '^';
			}
			return;
		case 'v':
			if (tankLocationRow + 1 < h && map[tankLocationRow + 1][tankLocationCol] == '.') {
				map[tankLocationRow][tankLocationCol] = '.';
				map[++tankLocationRow][tankLocationCol] = 'v';
			}
			return;
		case '<':
			if (tankLocationCol - 1 >= 0 && map[tankLocationRow][tankLocationCol - 1] == '.') {
				map[tankLocationRow][tankLocationCol] = '.';
				map[tankLocationRow][--tankLocationCol] = '<';
			}
			return;
		case '>':
			if (tankLocationCol + 1 < w && map[tankLocationRow][tankLocationCol + 1] == '.') {
				map[tankLocationRow][tankLocationCol] = '.';
				map[tankLocationRow][++tankLocationCol] = '>';
			}
			return;
		}
	}

	public static void findCurTankPosition() {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if (map[row][col] == '^' || map[row][col] == 'v' || map[row][col] == '<' || map[row][col] == '>') {
					tankLocationRow = row;
					tankLocationCol = col;
					return;
				}
			}
		}
	}

	public static void printMap(char[][] map) {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				System.out.printf("%c", map[row][col]);
			}
			System.out.println();
		}
	}
}
