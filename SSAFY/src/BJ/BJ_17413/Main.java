package BJ.BJ_17413;

import java.util.Scanner;
import java.util.Stack;

// 17413  단어 뒤집기 2
public class Main {
    static int i = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder totAnswer = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        for (i = 0; i < line.length(); i++) {
            char curChar = line.charAt(i);
            if (curChar == '<') {
                if (!stack.isEmpty()) {
                    String temp = popAll(stack);
                    totAnswer.append(temp);
                }

                totAnswer.append(curChar);
                while (true) {
                    i++;
                    curChar = line.charAt(i);
                    if (curChar == '>') {
                        totAnswer.append(curChar);
                        break;
                    }
                    totAnswer.append(curChar);
                }
            } // 꺽쇠 처리완료

            // 만약 일반 문자면
            if (curChar == '>') continue;

            if (curChar == ' ') {
                String temp = popAll(stack);
                totAnswer.append(temp);
                totAnswer.append(curChar);
                continue;
            }
            stack.add(curChar);
        }

        String temp = popAll(stack);
        totAnswer.append(temp); // stack에 있는 걸 sb로 다 옮겨담기
        System.out.println(totAnswer.toString());
        sc.close();
    }

    public static String popAll(Stack<Character> stack) {
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()) {
            temp.append(stack.pop());
        }

        return temp.toString();
    }
}