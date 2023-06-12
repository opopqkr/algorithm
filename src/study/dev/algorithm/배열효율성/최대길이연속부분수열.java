package study.dev.algorithm.배열효율성;

import java.util.Scanner;

public class 최대길이연속부분수열 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        System.out.println(solution1(n, k, inputs));
        System.out.println(solution2(n, k, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param k
     * @param inputs
     * @return
     */
    private static int solution1(int n, int k, int[] inputs) {
        int answer = 0, count = 0;

        int sp = 0;
        for (int ep = 0; ep < n; ep++) {
            if (inputs[ep] == 0) {
                count++;
                if (count > k) {
                    while (true) {
                        if (inputs[sp++] == 0)
                            break;
                    }
                    count--;
                }
            }
            answer = Math.max(answer, ep - sp + 1);
        }
        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param k
     * @param inputs
     * @return
     */
    private static int solution2(int n, int k, int[] inputs) {
        int answer = 0, count = 0;

        int sp = 0;
        for (int ep = 0; ep < n; ep++) {
            if (inputs[ep] == 0) {
                count++;
                while (count > k) {
                    if (inputs[sp] == 0) {
                        count--;
                    }
                    sp++;
                }
            }
            answer = Math.max(answer, ep - sp + 1);
        }
        return answer;
    }
}
