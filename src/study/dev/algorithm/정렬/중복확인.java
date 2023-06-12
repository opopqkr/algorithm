package study.dev.algorithm.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 중복확인 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        // System.out.println(solution1(n, inputs));
        System.out.println(solution2(n, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static String solution1(int n, int[] inputs) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (inputs[i] == inputs[j]) {
                    return "D";
                }
            }
        }

        return "U";
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static String solution2(int n, int[] inputs) {
        String answer = "U";
        Arrays.sort(inputs);

        for (int i = 0; i < n - 1; i++) {
            if (inputs[i] == inputs[i + 1]) {
                return "D";
            }
        }

        return answer;
    }
}
