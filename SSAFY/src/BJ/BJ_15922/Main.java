package BJ.BJ_15922;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int startP;
        int endP;
        int tempStartP;
        int tempEndP;
        int sum = 0;

        startP = sc.nextInt();
        endP = sc.nextInt();// 첫 선분
        for (int i = 1; i < N; i++) {
            tempStartP = sc.nextInt();
            tempEndP = sc.nextInt();
            if (endP >= tempEndP && startP <= tempStartP) { // 기존 선분이 새 선분을 덮는 경우
                continue;
            } else if (endP >= tempStartP) { // 기존선분과 곂치는 경우
                endP = tempEndP;
            } else { // 선분이 만나지 않는 경우
                sum += Math.abs(endP - startP); // 기존 선분 길이 sum에 누적
                startP = tempStartP; // 기존 선분 x좌표로 갱신
                endP = tempEndP; // 기존 선분 y좌표로 갱신
            }
        }
        sum += Math.abs(endP - startP); // 마지막 선분 계산
        System.out.println(sum);
        sc.close();
    }
}
