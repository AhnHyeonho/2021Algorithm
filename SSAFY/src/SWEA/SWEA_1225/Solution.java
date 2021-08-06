package SWEA.SWEA_1225;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA/SWEA_1225/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            test_case = sc.nextInt();
            Queue<Integer> encrypted = new LinkedList<Integer>();
            for (int i = 0; i < 8; i++) {
                encrypted.offer(sc.nextInt());
            }
            decrypt(encrypted);

            System.out.printf("#%d ", test_case);
            while (!encrypted.isEmpty()) {
                System.out.printf("%d ", encrypted.poll());
            }
            System.out.println();
        }
    }

    public static void decrypt(Queue<Integer> encrypted) {
        int gap = 0;
        while (true) {
            int curNum = encrypted.poll() - (gap++ % 5) - 1;
            if (curNum <= 0) {
                encrypted.add(Integer.valueOf(0));
                break;
            } else {
                encrypted.add(Integer.valueOf(curNum));
            }

        }
    }
}