package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 문장속단어 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 단어가 아닌 문장은 nextLine()
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
    public static String solution1(String input) {
        String[] array = input.split(" ");
        String answer = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i + 1].length();

            if (answer.length() < temp) {
                answer = array[i + 1];
            } else {
                continue;
            }
        }
        return answer;
    }

    /**
     * 강의 풀이
     * <p>
     * 최대값 구하기
     * split(),
     * indexOf()
     *
     * @param input
     * @return
     */
    public static String solution2(String input) {
        String answer = "";
        int minimum = Integer.MIN_VALUE;// 가장 작은 값

        /** 첫 번째 풀이 */
        // String[] array = input.split(" ");
        // for (String word : array) {
        //     int wordLength = word.length();
        //     if (wordLength > minimum) {
        //         minimum = wordLength;
        //         answer = word;
        //     }
        // }

        /** 두 번째 풀이 */
        int pos;
        while ((pos = input.indexOf(' ')) != -1) {
            String word = input.substring(0, pos);

            int wordLength = word.length();
            if (wordLength > minimum) {
                minimum = wordLength;
                answer = word;
            }

            input = input.substring(pos + 1);
        }

        // 마지막 단어 처리
        if (input.length() > minimum) {
            answer = input;
        }

        return answer;
    }
}
