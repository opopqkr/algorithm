package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 회문문자열 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(solution1(input));
        System.out.println(solution2(input));
    }

    /**
     * 내 풀이
     *
     * @param input
     * @return
     */
    private static String solution1(String input) {
        int startIndex = 0;
        int endIndex = input.length() - 1;

        while (startIndex < endIndex) {
            if (Character.toLowerCase(input.charAt(startIndex)) == Character.toLowerCase(input.charAt(endIndex))) {
                startIndex++;
                endIndex--;
            } else {
                return "NO";
            }
        }
        return "YES";
    }

    /**
     * 강의 풀이
     * <p>
     * 1. 문자열 길이 / 2 까지 반복문
     * 2. StringBuilder 이용
     *
     * @param input
     * @return
     */
    private static String solution2(String input) {
        String answer = "YES";

        /** 첫 번째 풀이 */
        // input = input.toUpperCase();
        // int len = input.length();
        // for (int i = 0; i < len / 2; i++) {
        //    if (input.charAt(i) != input.charAt(len - i - 1)) {
        //        return "NO";
        //    }
        // }

        /** 두 번째 풀이 */
        String temp = new StringBuilder(input).reverse().toString();
        if (!input.equalsIgnoreCase(temp)) {
            return "NO";
        }
        return answer;
    }
}
