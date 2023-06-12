package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 대소문자변환 {

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
    public static String solution1(String input) {
        String answer = "";
        for (char c : input.toCharArray())
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * ASCII 이용
     * <p>
     * 대문자 : 65 ~ 90
     * 소문자 : 97 ~ 122
     * <p>
     * 소문자 minus 대문자 = 32
     * 소문자에서 32를 빼면 대문자
     * 대문자에서 32를 더하면 소문자
     *
     * @param input
     * @return
     */
    public static String solution2(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (c >= 97 && c <= 122) {
                answer += (char) (c - 32);
            } else {
                answer += (char) (c + 32);
            }
        }

        return answer;
    }
}
