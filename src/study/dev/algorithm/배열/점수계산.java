package study.dev.algorithm.배열;

import java.util.Scanner;

public class 점수계산 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        System.out.println(solution1(n, inputs));
        System.out.println(solution2(n, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int solution1(int n, int[] inputs) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int score = 0;
            if (inputs[i] == 1) {
                score++;
                for (int j = i + 1; j < n; j++) {
                    if (inputs[j] == 1) {
                        score++;
                    } else {
                        break;
                    }
                }
            } else {
                score = 0;
            }
            answer += score;
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int solution2(int n, int[] inputs) {
        int answer = 0, score = 0;
        for (int i = 0; i < n; i++) {
            if (inputs[i] == 1) {
                score++;
                answer += score;
            } else {
                score = 0;
            }
        }
        return answer;
    }
}
