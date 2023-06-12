package study.dev.algorithm.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        // solution1(n, inputs);

        System.out.println();

        for (int i : solution2(n, inputs)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static void solution1(int n, int[] inputs) {
        int i, j = 0;

        boolean find = false;

        for (i = 0; i < n - 1; i++) {
            for (j = n - 1; j > i; j--) {
                if (inputs[i] > inputs[j]) {
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        System.out.print((i + 1) + " " + (j + 1));
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static ArrayList<Integer> solution2(int n, int[] inputs) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] temp = inputs.clone();
        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            if (inputs[i] != temp[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
}
