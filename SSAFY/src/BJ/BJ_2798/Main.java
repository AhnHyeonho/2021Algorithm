package BJ.BJ_2798;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/BJ/BJ_2798/input.txt"));
        Scanner sc = new Scanner(System.in);
        for (int test_case = 0; test_case < 2; test_case++) {
            int N = sc.nextInt(); // 카드의 개수
            int M = sc.nextInt(); // 근사치
            int[] cards = new int[N];
            for (int i = 0; i < N; i++) {
                cards[i] = sc.nextInt();
            } // 초기화
            int approximation = 0;
            int i, j, k;
            for (i = 0; i < N - 2; i++) {
                for (j = i + 1; j < N - 1; j++) {
                    for (k = j + 1; k < N; k++) {
                        int curCombi = cards[i] + cards[j] + cards[k];
                        if (curCombi > M) continue;
                        approximation = M - approximation > M - curCombi ? curCombi : approximation;
                    }
                }
            }
            System.out.println(approximation);
        }

    }
}
