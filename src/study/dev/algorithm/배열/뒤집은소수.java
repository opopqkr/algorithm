package study.dev.algorithm.배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 뒤집은소수 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n];

//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int inputNumber = Integer.parseInt(new StringBuilder(in.next()).reverse().toString());
//            inputs[i] = inputNumber;
//            if (inputNumber > max) {
//                max = inputNumber;
//            }
//        }
//
//        for (int x : solution1(max, inputs)) {
//            System.out.print(x + " ");
//        }

        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        for (int x : solution2(n, inputs)) {
            System.out.print(x + " ");
        }

    }

    /**
     * 내 풀이 (에라토스테네스의 체 이용)
     *
     * @param maxValue
     * @param inputs
     * @return
     */
    private static List<Integer> solution1(int maxValue, int[] inputs) {
        List<Integer> answers = new ArrayList<>();

        int[] temp = new int[maxValue + 1];
        for (int i = 2; i <= maxValue; i++) {
            if (temp[i] == 0) {
                temp[i] = i;
                for (int j = i; j <= maxValue; j += i) {
                    if (i == j) {
                        continue;
                    }
                    temp[j] = Integer.MIN_VALUE;
                }
            }
        }


        for (int i = 0; i < inputs.length; i++) {
            for (int j = 2; j < temp.length; j++) {
                if (inputs[i] == temp[j]) {
                    answers.add(inputs[i]);
                }
            }
        }
        return answers;
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
        /** 숫자 뒤집기 */
        for (int i = 0; i < n; i++) {
            int temp = inputs[i]; // 32
            int reverse = 0; // 0

            while (temp > 0) {
                int t = temp % 10; // t = 32 % 10 = 2  -> t = 3 % 10 = 3
                reverse = reverse * 10 + t; // reverse = 0 * 10 + 2 = 2 -> reverse = 2 * 10 + 3 = 23
                temp = temp / 10; // temp = 32 / 10 = 3 -> temp = 3 / 10 = 0 이므로 while 종료.
            }

            if (isPrime(reverse)) {
                answer.add(reverse);
            }
        }
        return answer;
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
