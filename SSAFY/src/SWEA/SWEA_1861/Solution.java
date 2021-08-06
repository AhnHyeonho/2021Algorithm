package SWEA.SWEA_1861;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static int[][] map;
    static int N;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0}; // 동 서 남 북

    static int maxMovingCnt;
    static int maxMovingStartPoint;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA/SWEA_1861/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            maxMovingCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            } // 초기화
            maxMovingStartPoint = map[0][0];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    /*
                     * 이동횟수가 가장 큰 값을 저장한다. 단 최대이동횟수가 같으면 시작점이 작은 걸 저장한다.
                     */
                    if (movingCount(i, j) > maxMovingCnt) {
                        maxMovingCnt = movingCount(i, j);
                        maxMovingStartPoint = map[i][j];
                    } else if (movingCount(i, j) == maxMovingCnt) {
                        maxMovingStartPoint = map[i][j] < maxMovingStartPoint ? map[i][j] : maxMovingStartPoint;
                    }
                }
            }
            System.out.printf("#%d %d %d\n", test_case, maxMovingStartPoint, maxMovingCnt + 1);
        }

        sc.close();
    }

    public static int movingCount(int row, int col) {
        for (int i = 0; i < 4; i++) {
            if (row + dy[i] >= 0 && row + dy[i] < N && col + dx[i] >= 0 && col + dx[i] < N
                    && map[row][col] + 1 == map[row + dy[i]][col + dx[i]]) {
                return 1 + movingCount(row + dy[i], col + dx[i]);
            }
        }
        return 0;
    }
}