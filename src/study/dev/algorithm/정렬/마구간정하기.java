package study.dev.algorithm.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int c = in.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        // System.out.println(solution1(n, c, inputs));
        System.out.println(solution2(n, c, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param c
     * @param inputs
     * @return
     */
    private static int solution1(int n, int c, int[] inputs) {
        int answer = 0;
        Arrays.sort(inputs);

        int start = 1;
        int end = inputs[n - 1];

        while (start <= end) {
            int center = (start + end) / 2;
            if (count1(center, inputs) < c) {
                end = center - 1;
            } else {
                answer = center;
                start = center + 1;
            }
        }
        return answer;
    }

    private static int count1(int distance, int[] inputs) {
        int count = 1;
        int endPoint = inputs[0];
        for (int i : inputs) {
            if (distance <= i - endPoint) {
                count++;
                endPoint = i;
            }
        }
        return count;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param c
     * @param inputs
     * @return
     */
    private static int solution2(int n, int c, int[] inputs) {
        int answer = 0;
        Arrays.sort(inputs);

        int start = 1;
        int end = inputs[n - 1];
        while (start <= end) {
            int center = (start + end) / 2;
            if (count2(center, inputs) >= c) {
                answer = center;
                start = center + 1;
            } else {
                end = center - 1;
            }
        }

        return answer;
    }

    private static int count2(int distance, int[] inputs) {
        int count = 1;
        int endPosition = inputs[0];

        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] - endPosition >= distance) {
                count++;
                endPosition = inputs[i];
            }
        }

        return count;
    }
}
