package study.dev.algorithm.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자구슬 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        solution1(n, m, inputs);
    }

    private static void solution1(int n, int m, int[] inputs) {
        int answer = Integer.MAX_VALUE;
        int start = Arrays.stream(inputs).min().getAsInt();
        int end = Arrays.stream(inputs).sum();

        while (start <= end) {
            int center = (start + end) / 2;
            if (groupCount(center, inputs) <= m) {
                answer = center;
                end = center - 1;
            } else {
                start = center + 1;
            }
        }

        answerPrint(answer, m, inputs);
    }

    private static int groupCount(int center, int[] inputs) {
        int count = 1, sum = 0;

        for (int i : inputs) {
            if (sum + i > center) {
                count++;
                sum = i;
            } else {
                sum += i;
            }
        }

        return count;
    }

    private static void answerPrint(int answer, int m, int[] inputs) {
        System.out.println(answer);

        int count = 0;
        int sum = 0;
        for (int j = 0; j < inputs.length; j++) {
            if (sum + inputs[j] > answer) {
                System.out.print(count + " ");
                sum = inputs[j];
                count = 0;
            } else {
                sum += inputs[j];
            }
            count++;
        }
        System.out.print(count);
    }
}
