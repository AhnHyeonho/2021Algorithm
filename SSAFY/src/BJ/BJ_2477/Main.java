package BJ.BJ_2477;

import java.util.Scanner;

// 2477 참외밭
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int melonPer = sc.nextInt();
        int[] xs = new int[7];
        int[] ys = new int[7];

        for (int i = 1; i <= 6; i++) {
            int dir = sc.nextInt();
            int meter = sc.nextInt();
            switch (dir) {
                case 1:
                    xs[i] = xs[i - 1] + meter;
                    ys[i] = ys[i - 1];
                    break;
                case 2:
                    xs[i] = xs[i - 1] - meter;
                    ys[i] = ys[i - 1];
                    break;
                case 3:
                    xs[i] = xs[i - 1];
                    ys[i] = ys[i - 1] + meter;
                    break;
                case 4:
                    xs[i] = xs[i - 1];
                    ys[i] = ys[i - 1] - meter;
                    break;
            }
        }
        System.out.println(calcMelon(xs, ys, melonPer));
        sc.close();
    }

    private static int calcMelon(int[] xs, int[] ys, int melonPer) {
        int sum = 0;
        for (int i = 0; i < xs.length - 1; i++) {
            sum += xs[i] * ys[i + 1];
        }
        for (int i = 0; i < ys.length - 1; i++) {
            sum -= ys[i] * xs[i + 1];
        } // 신발끈 공식
        return melonPer * Math.abs(sum) / 2;
    }
}