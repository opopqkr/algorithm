package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 중복문자제거 {

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
        String answer = "";

        for (char word : input.toCharArray()) {
            if (!answer.contains(String.valueOf(word))) {
                answer += word;
            }
        }
        return answer;
    }

    /**
     * 강의 풀이
     * <p>
     * indexOf(param) : 처음으로 발견된 문자 위치
     *
     * @param input
     * @return
     */
    private static String solution2(String input) {
        String answer = "";

        for (int i = 0; i < input.length(); i++) {
            if (i == input.indexOf(input.charAt(i)))
                answer += input.charAt(i);
        }
        return answer;
    }
}
