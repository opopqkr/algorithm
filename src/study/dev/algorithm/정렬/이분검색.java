package study.dev.algorithm.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {

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
     * 내 강의
     *
     * @param n
     * @param m
     * @param inputs
     * @return
     */
    private static int solution1(int n, int m, int[] inputs) {
        int answer = 1;
        // 삽입 정렬
        for (int i = 1; i < n; i++) {
            int temp = inputs[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (inputs[j] > temp) {
                    inputs[j + 1] = inputs[j];
                } else {
                    break;
                }
            }
            inputs[j + 1] = temp;
        }

        answer = answer + binarySearch(m, 0, inputs.length, inputs);
        return answer;
    }

    private static int binarySearch(int target, int start, int end, int[] array) {
        int center = (start + end) / 2;

        if (start > end) {
            return -1;
        }

        if (array[center] == target) {
            return center;
        } else if (array[center] < target) {
            return binarySearch(target, center + 1, end, array);
        } else {
            return binarySearch(target, start, end - 1, array);
        }
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

        Arrays.sort(inputs);
        int start = 0, end = inputs.length - 1;

        while (start <= end) {
            int center = (start + end) / 2;
            if (inputs[center] == m) {
                answer = center + 1;
                break;
            } else if (inputs[center] < m) {
                start = center + 1;
            } else {
                end = center - 1;
            }
        }

        return answer;
    }
}
