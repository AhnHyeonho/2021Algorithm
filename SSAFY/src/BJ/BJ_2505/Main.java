package BJ.BJ_2505;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/BJ/BJ_2505/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            Map<Integer, Integer> answer = new HashMap<>();
            int N = sc.nextInt();
            int[] arr = new int[N];
            int[] origin = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                origin[i] = arr[i];
            } // 초기화

            int endPoint = 0;
            int startPoint = 0;
            System.out.println("current Array:: \n" + Arrays.toString(arr));
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
                    answer.put(startPoint + 1, endPoint + 1);
                }
            }

            if (cnt > 2) {
                answer.clear();
                // 역순으로 검사
                System.out.println("역순검사 시작");
                arr = origin;
                System.out.println(Arrays.toString(arr));
                endPoint = 0;
                startPoint = 0;
                for (int i = N; i >= 1; i--) {
                    if (arr[i - 1] == i)
                        continue;
                    else {
                        cnt++;
                        endPoint = i - 1;
                        for (int j = endPoint; j >= 0; j--) {
                            if (arr[j] == i) {
                                startPoint = j;
                                break;
                            }
                        }
                        swap(arr, startPoint, endPoint);
                        answer.put(startPoint + 1, endPoint + 1);
                    }
                }
            }

            for (Integer cur : answer.keySet()) {
                System.out.printf("%d %d\n", cur + 1, answer.get(cur) + 1);
            }


            if(cnt==0) {
                System.out.printf("%d %d\n", 1 , 1);
                System.out.printf("%d %d\n", 1 , 1);
            } else if(cnt==1){
                System.out.printf("%d %d\n", 1 , 1);
            }
        }
    }

    public static void swap(int[] arr, int start, int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            if (start == end) break;
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
