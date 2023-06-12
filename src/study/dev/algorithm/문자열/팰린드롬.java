package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 팰린드롬 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
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
        String answer = "YES";
        String temp = "";
        for (char word : input.toCharArray()) {
            if (Character.isAlphabetic(word)) {
                temp += word;
            }
        }
        temp = temp.toUpperCase();
        // int len = temp.length();
        // for (int i = 0; i < len; i++) {
        //     if (temp.charAt(i) != temp.charAt(len - i - 1))
        //         return "NO";
        // }
        if (!temp.equals(new StringBuilder(temp).reverse().toString())) {
            return "NO";
        }

        return answer;
    }

    /**
     * 강의 풀이
     * <p>
     * replaceAll(정규식 이용)
     *
     * @param input
     * @return
     */
    private static String solution2(String input) {
        String answer = "NO";
        input = input.toUpperCase().replaceAll("[^A-Z]", "");

        String temp = new StringBuilder(input).reverse().toString();
        if (input.equals(temp))
            return "YES";

        return answer;
    }
}
