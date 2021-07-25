import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution7272 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA/7272/s_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] pre = sc.next().toCharArray();
            char[] post = sc.next().toCharArray();
            String result;
            for (int i = 0; i < pre.length; i++) {
                pre[i] = shiftC(pre[i]);
            }
            for (int i = 0; i < post.length; i++) {
                post[i] = shiftC(post[i]);
            }
            if (Arrays.equals(pre, post)) {
                result = "SAME";
            } else result = "DIFF";
            System.out.printf("#%d %s\n", test_case, result);
        }
    }

    public static char shiftC(char c) {
        String sc = Character.toString(c);
        String noneHole = "CEFGHIJKLMNSTUVWXYZ";
        String oneHole = "ADOPQR";
        if (noneHole.contains(sc)) return 'C';
        else if (oneHole.contains(sc)) return 'A';
        else return 'B';
    }
}
