package study.dev.algorithm.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] pi = new int[n];
        for (int i = 0; i < n; i++) {
            pi[i] = in.nextInt();
        }

        System.out.println(solution(pi));
    }

    private static int solution(int[] pi) {
        Arrays.sort(pi);

        int answer = 0, temp = 0;

        for (int i : pi) {
            temp += i;
            answer += temp;
        }

        return answer;
    }
}
