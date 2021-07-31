package SWEA.SWEA_2805;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2805 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA/2805/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] plate = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = sc.next();
                Arrays.setAll(plate[i], j -> Character.getNumericValue(line.charAt(j)));
            }
            int half = N / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = Math.abs(half - i); j <= N - 1 - Math.abs(half - i); j++) {
                    sum += plate[i][j];
                }
            }
            System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}
