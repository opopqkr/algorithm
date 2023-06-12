package study.dev.algorithm.배열;

import java.util.ArrayList;
import java.util.Scanner;

public class 등수구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        for (int x : solution1(n, inputs)) {
            System.out.print(x + " ");
        }
    }

    /**
     * 내 풀이 & 강의 풀이 동일
     *
     * @param n
     * @param inputs
     * @return
     */
    private static ArrayList<Integer> solution1(int n, int[] inputs) {
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (inputs[i] < inputs[j]) {
                    rank++;
                }
            }
            answers.add(rank);
        }

        return answers;
    }
}
