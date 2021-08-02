package BJ.BJ_2505;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> answer = new ArrayList<Pair>();
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] origin = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            origin[i] = arr[i];
        } // 초기화

        int endPoint = 0;
        int startPoint = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i - 1] == i)
                continue;
            else {
                cnt++;
                startPoint = i - 1;
                for (int j = startPoint; j < N; j++) {
                    if (arr[j] == i) {
                        endPoint = j;
                        break;
                    }
                }
                swap(arr, startPoint, endPoint);
                answer.add(new Pair(startPoint + 1, endPoint + 1));
            }
        }

        if (cnt > 2) {
            answer.clear();
            // 역순으로 검사
            arr = origin;
            endPoint = 0;
            startPoint = 0;
            for (int i = N; i >= 1; i--) {
                if (arr[i - 1] == i)
                    continue;
                else {
                    endPoint = i - 1;
                    for (int j = endPoint; j >= 0; j--) {
                        if (arr[j] == i) {
                            startPoint = j;
                            break;
                        }
                    }
                    swap(arr, startPoint, endPoint);
                    answer.add(new Pair(startPoint + 1, endPoint + 1));
                }
            }
        }

        if (cnt == 0) {
            System.out.printf("%d %d\n", 1, 1);
            System.out.printf("%d %d\n", 1, 1);
        } else if (cnt == 1) {
            System.out.printf("%d %d\n", 1, 1);
            for (Pair cur : answer) {
                System.out.printf("%d %d\n", cur.num1, cur.num2);
            }
        } else {
            for (Pair cur : answer) {
                System.out.printf("%d %d\n", cur.num1, cur.num2);
            }
        }
        sc.close();
    }

    public static void swap(int[] arr, int start, int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            if (start == end)
                break;
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}

class Pair {
    int num1;
    int num2;

    public Pair(int num1, int num2) {
        super();
        this.num1 = num1;
        this.num2 = num2;
    }
}