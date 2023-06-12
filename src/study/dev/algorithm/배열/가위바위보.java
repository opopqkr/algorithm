package study.dev.algorithm.배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가위바위보 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] aInfos = new int[n];
        int[] bInfos = new int[n];

        for (int i = 0; i < n; i++) {
            aInfos[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            bInfos[i] = in.nextInt();
        }

        for (String winner : solution1(n, aInfos, bInfos)) {
            System.out.println(winner);
        }

        for (char winner : solution2(n, aInfos, bInfos).toCharArray()) {
            System.out.println(winner);
        }
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param aInfos
     * @param bInfos
     * @return
     */
    private static List<String> solution1(int n, int[] aInfos, int[] bInfos) {
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (aInfos[i] == bInfos[i]) {
                answers.add("D");
            } else if (aInfos[i] > bInfos[i]) {
                if (aInfos[i] - bInfos[i] == 1) {
                    answers.add("A");
                } else {
                    answers.add("B");
                }
            } else {
                if (bInfos[i] - aInfos[i] == 1) {
                    answers.add("B");
                } else {
                    answers.add("A");
                }
            }
        }
        return answers;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param aInfos
     * @param bInfos
     * @return
     */
    private static String solution2(int n, int[] aInfos, int[] bInfos) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (aInfos[i] == bInfos[i]) {
                answer += "D";
            } else if (aInfos[i] == 1 && bInfos[i] == 3) {
                answer += "A";
            } else if (aInfos[i] == 2 && bInfos[i] == 1) {
                answer += "A";
            } else if (aInfos[i] == 3 && bInfos[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
            }
        }
        return answer;
    }

}
