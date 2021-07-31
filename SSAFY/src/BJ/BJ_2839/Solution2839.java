package BJ.BJ_2839;

import java.util.Scanner;

public class Solution2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();
        int max5Cnt = weight / 5;
        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= max5Cnt; i++) {
            if ((weight - (5 * i)) % 3 == 0) {
                minCnt = Math.min(minCnt, i + ((weight - (5 * i)) / 3));
            }
        }
        if (minCnt == Integer.MAX_VALUE){
            if( weight % 3 == 0){
                minCnt = weight / 3;
            } else {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(minCnt);
    }
}
