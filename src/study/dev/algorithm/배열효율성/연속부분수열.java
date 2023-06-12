package study.dev.algorithm.배열효율성;

import java.util.Scanner;

public class 연속부분수열 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        System.out.println(solution1(n, m, inputs));
        System.out.println(solution2(n, m, inputs));
    }

    /**
     * 내 풀이 (Runtime error)
     *
     * @param n
     * @param m
     * @param inputs
     * @return
     */
    private static int solution1(int n, int m, int[] inputs) {
        int answer = 0;

        int sum = 0, sp = 0, ep = 0;
        sum += inputs[ep++];
        while (true) {
            if (ep == n && sum < m) {
                break;
            }
            if (sum == m) {
                answer++;
                sum -= inputs[sp++];
                // 원래 내 풀이에서는 sp 와 ep 둘 다 한칸씩 움직였는데 그럴 경우 runtime error 발생
                // sum += (inputs[ep++] - inputs[sp++]);
            } else if (sum < m) {
                sum += inputs[ep++];
            } else {
                sum -= inputs[sp++];
            }
        }
        return answer;
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

        int sum = 0, sp = 0;
        for (int ep = 0; ep < n; ep++) {
            // sum 이 m 보다 크거나 작을 때까지 ep 를 늘려주며 sum 에 더함
            sum += inputs[ep];
            if (sum == m) {
                answer++;
            }
            // sum 이 m 보다 크거나 같아지는 시점에서 sp 를 빼면서 반복 작업
            while (sum >= m) {
                sum -= inputs[sp++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
