package SWEA.SWEA_3499;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static String[] origin;
    static int N;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA/SWEA_3499/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            sc.nextLine();
            origin = sc.nextLine().split(" ");
            perfectShuffle(origin);
            System.out.printf("#%d ", test_case);
            System.out.println(Arrays.toString(origin).replaceAll("[\\[,\\]]", ""));
        }
        sc.close();
    }

    public static void perfectShuffle(String[] origin) {
        int half = origin.length / 2;
        String[] temp = new String[N];
        if ((origin.length % 2) == 1) { // 길이가 홀수
            for (int idx = 0; idx < N; idx++) {
                if (idx <= half) {
                    temp[idx * 2] = origin[idx];
                } else {
                    temp[(idx - half) * 2 - 1] = origin[idx];
                }
            }
        } else { // 길이가 짝수
            for (int idx = 0; idx < N; idx++) {
                if (idx < half) {
                    temp[idx * 2] = origin[idx];
                } else {
                    temp[(idx - N / 2) * 2 + 1] = origin[idx];
                }
            }
        }
        System.arraycopy(temp, 0, origin, 0, N);
    }
}