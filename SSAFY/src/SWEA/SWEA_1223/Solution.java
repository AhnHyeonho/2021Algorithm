package SWEA.SWEA_1223;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            Stack<Integer> operandStack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>();
            int answer=0;
            int N = sc.nextInt();
            char[] ch = sc.next().toCharArray();
            for (int i = 0; i < N; i++) {
                if ((int) (ch[i] - 48) >= 0 && (int) (ch[i] - 48) < 10) {
                    // operand
                    operandStack.push(ch[i]-48);
                } else {
                    // operator
                    if (!operatorStack.isEmpty() && isPossible(ch[i], operatorStack.peek())) {
                        while (!operatorStack.isEmpty()){
                            Integer op2 = operandStack.pop();
                            Integer op1 = operandStack.pop();
                            Integer result = 0;
                            switch(operatorStack.pop()){
                                case '+':
                                    result = op1 + op2;
                                    break;
                                case '-':
                                    result = op1 - op2;
                                    break;
                                case '*':
                                    result = op1 * op2;
                                    break;
                                case '/':
                                    result = op1 / op2;
                                    break;
                            }
                            operandStack.push(result);
                        }
                    }
                    operatorStack.push(ch[i]);
                }


            }
            Integer result = 0;
            while (!operatorStack.isEmpty()){
                Integer op2 = operandStack.pop();
                Integer op1 = operandStack.pop();
                switch(operatorStack.pop()){
                    case '+':
                        result = op1 + op2;
                        break;
                    case '-':
                        result = op1 - op2;
                        break;
                    case '*':
                        result = op1 * op2;
                        break;
                    case '/':
                        result = op1 / op2;
                        break;
                }
                operandStack.push(result);
            }
            answer = result;
            System.out.printf("#%d %d\n", test_case, answer);

        }
        sc.close();
    }

    private static boolean isPossible(char ch, Character peek) {
        if ((ch=='+' || ch=='-') && (peek=='*' || peek =='/')){
            return true;
        } else return false;
    }
}
