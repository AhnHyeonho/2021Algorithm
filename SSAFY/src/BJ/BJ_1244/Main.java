package BJ.BJ_1244;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] switchs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            switchs[i] = sc.nextInt();
        } // switch 초기화
        int stuN = sc.nextInt();
        for (int i = 0; i < stuN; i++) {
            int curStu = sc.nextInt();
            switch (curStu) {
                case 1: // 남학생
                    toggleSwitchByBoy(switchs, sc.nextInt());
                    break;
                case 2: // 여학생
                    toggleSwitchByGirl(switchs, sc.nextInt());
                    break;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (i!=1 && i % 20 == 1) {
                System.out.println();
            }
            System.out.printf("%d ", switchs[i]);
        }
        sc.close();
    }

    public static void toggleSwitchByBoy(int[] arr, int idx) {
        for (int i = 1; i <= arr.length - 1; i++) {
            if (i % idx == 0) { // 배수이면
                switch (arr[i]) {
                    case 0:
                        arr[i] = 1;
                        break;
                    case 1:
                        arr[i] = 0;
                        break;
                }
            }
        }
    }

    public static void toggleSwitchByGirl(int[] arr, int idx) {
        switch (arr[idx]) { // 현재 idx 뒤집기
            case 0:
                arr[idx] = 1;
                break;
            case 1:
                arr[idx] = 0;
                break;
        }
        int pre = idx - 1; // 좌측이동
        int post = idx + 1; // 우측이동

        while (true) {
            if (pre < 1 || post > arr.length - 1) {
                break;
            }
            if (arr[pre] == arr[post]) {
                switch (arr[pre]) {
                    case 0:
                        arr[pre--] = 1;
                        arr[post++] = 1;
                        break;
                    case 1:
                        arr[pre--] = 0;
                        arr[post++] = 0;
                        break;
                }
            } else
                break;
        }
    }
}