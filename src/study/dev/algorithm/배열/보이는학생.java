package study.dev.algorithm.배열;

import java.util.Scanner;

public class 보이는학생 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
        }
        System.out.println(solution1(inputs));
    }

    /**
     * 내 풀이 & 강의 풀이 동일
     *
     * @param inputs
     * @return
     */
    private static int solution1(int[] inputs) {
        int min = Integer.MIN_VALUE;

        int count = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] > min) {
                count++;
                min = inputs[i];
            }
        }
        return count;
    }
}
