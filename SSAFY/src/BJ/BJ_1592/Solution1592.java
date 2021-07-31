package BJ.BJ_1592;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1592 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/BJ_1592/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] catchCnt = new int[N];
        int ball = 0;
        int cnt = 0;
        catchCnt[ball]++; // 0번 사람 한 번 받음
        while (checkCatchCnt(catchCnt, M)) {
            cnt++;
            if ((catchCnt[ball] & 1) == 0) { // 짝수
                ball = ((ball - L + N) % N);
                catchCnt[ball]++;
            } else { // 홀수
                ball = ((ball + L + N) % N);
                catchCnt[ball]++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean checkCatchCnt(int[] catchCnt, int M) {
        for (int i = 0; i < catchCnt.length; i++) {
            if (catchCnt[i] == M)
                return false;
        }
        return true;
    }
}