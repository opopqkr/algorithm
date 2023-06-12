package study.dev.algorithm.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        // System.out.println(solution1(n, m, inputs));
        System.out.println(solution2(n, m, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param m
     * @param inputs
     * @return
     */
    private static int solution1(int n, int m, int[] inputs) {
        int answer = 0;
        int min = inputs[n - 1];
        int max = Arrays.stream(inputs).sum();

        while (min < max) {
            int center = (min + max) / 2;
            if (isAble(center, m, inputs)) {
                max = center;
            } else {
                min = center + 1;
            }
        }

        answer = (min + max) / 2;
        return answer;
    }

    private static boolean isAble(int volume, int m, int[] inputs) {
        boolean isAble = true;

        int temp = 0;
        for (int i = 0; i < inputs.length; i++) {
            temp = temp + inputs[i];
            if (temp > volume) {
                m--;
                if (m == 0) {
                    isAble = false;
                    break;
                }
                temp = inputs[i];
            }
        }

        return isAble;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param m
     * @param inputs
     * @return
     */
    private static int solution2(int n, int m, int[] inputs) {
        int answer = 0;

        int start = Arrays.stream(inputs).max().getAsInt();
        int end = Arrays.stream(inputs).sum();

        while (start <= end) {
            int center = (start + end) / 2;
            if (count(center, inputs) <= m) {
                answer = center;
                end = center - 1;
            } else {
                start = center + 1;
            }
        }

        return answer;
    }

    private static int count(int capacity, int[] inputs) {
        int count = 1, sum = 0;

        for (int i : inputs) {
            if (sum + i > capacity) {
                count++;
                sum = i;
            } else {
                sum += i;
            }
        }

        return count;
    }
}
