package SWEA_1234;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA_1234/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            } // 초기화

            int[] pre;
            int[] post;

            for (int i = 0; i < N - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    for (int j = i + 2; j < N; j++) {

                    }
                }
            }
        }
    }

    public int[] removeDupl(int[] arr) {
        int[] curArr = arr;
        if (num==1) {
            removeDupl(curArr);
        } else return curArr;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                for (int j = i + 2; j < N; j++) {

                }
            }
        }
    }
}
