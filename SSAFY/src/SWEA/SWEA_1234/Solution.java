package SWEA.SWEA_1234;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA_1234/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            char[] arr = sc.next().toCharArray();
            int[] iarr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                iarr[i] = arr[i] - 48;
            } // 초기화
            int[] pre;
            int[] post;
            int[] temp = iarr;
            for (int i = 0; i < temp.length - 1; i++) {
                if (iarr[i] == iarr[i + 1]) {
                    pre = Arrays.copyOfRange(iarr, 0, i + 1);
                    post = Arrays.copyOfRange(iarr, i + 1, iarr.length);
                    if (pre.length > 1 && post.length > 1) {
                        temp = new int[pre.length + post.length - 2];
                        System.arraycopy(pre, 0, temp, 0, pre.length - 1);
                        System.arraycopy(post, 1, temp, pre.length - 1, post.length - 1);
                        i--;
                    } else if (pre.length == 1) {
                        temp = new int[post.length - 1];
                        System.arraycopy(post, 1, temp, 0, post.length - 1);
                        i++;
                    } else {
                        temp = new int[pre.length - 1];
                        System.arraycopy(pre, 0, temp, 0, pre.length - 1);
                        i--;
                    }
                    iarr = temp;
                    i -= 1;
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < iarr.length; i++) {
                System.out.print(iarr[i]);
            }
            System.out.println();
        }
    }
}