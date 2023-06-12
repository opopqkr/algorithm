package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 특정문자뒤집기 {

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
        char[] wordArray = input.toCharArray();

        int startIndex = 0;
        int endIndex = wordArray.length - 1;

        while (startIndex < endIndex) {
            if (Character.isAlphabetic(wordArray[startIndex])) {
                char temp = wordArray[startIndex];
                if (Character.isAlphabetic(wordArray[endIndex])) {
                    wordArray[startIndex] = wordArray[endIndex];
                    wordArray[endIndex] = temp;
                    startIndex++;
                }
                endIndex--;
            } else {
                startIndex++;
            }
        }

        return String.valueOf(wordArray);
    }

    /**
     * 강의 풀이
     *
     * @param input
     * @return
     */
    public static String solution2(String input) {
        char[] wordArray = input.toCharArray();

        int startIndex = 0;
        int endIndex = wordArray.length - 1;

        while (startIndex < endIndex) {
            if (!Character.isAlphabetic(wordArray[startIndex])) {
                startIndex++;
            } else if (!Character.isAlphabetic(wordArray[endIndex])) {
                endIndex--;
            } else {
                char temp = wordArray[startIndex];
                wordArray[startIndex] = wordArray[endIndex];
                wordArray[endIndex] = temp;

                startIndex++;
                endIndex--;
            }
        }

        return String.valueOf(wordArray);
    }
}
