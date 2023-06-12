package study.dev.algorithm.문자열;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.next();
        }

        // solution1(inputs);

        // for (String answer : solution2(inputs)) {
        //     System.out.println(answer);
        // }

        for (String answer : solution3(inputs)) {
            System.out.println(answer);
        }
    }

    /**
     * 내 풀이
     *
     * @param inputs
     */
    public static void solution1(String[] inputs) {
        for (String word : inputs) {
            String answer = "";
            char[] wordArray = word.toCharArray();

            for (int i = wordArray.length - 1; i >= 0; i--) {
                answer += wordArray[i];
            }

            System.out.println(answer);
        }
    }

    /**
     * 강의 풀이 1
     * <p>
     * StringBuilderClass 이용
     * String 자체로 변경 시 새로 객체가 생성됨.
     * StringBuilder 이용 시, 기존의 객체로 사용.
     *
     * @param inputs
     */
    public static ArrayList<String> solution2(String[] inputs) {
        ArrayList<String> answers = new ArrayList<>();
        for (String word : inputs) {
            String answer = new StringBuilder(word).reverse().toString();
            answers.add(answer);
        }
        return answers;
    }

    /**
     * 강의 풀이 2
     *
     * @param inputs
     * @return
     */
    public static ArrayList<String> solution3(String[] inputs) {
        ArrayList<String> answers = new ArrayList<>();
        for (String word : inputs) {

            char[] wordArray = word.toCharArray();
            int startIdx = 0;
            int endIdx = word.length() - 1;

            while (startIdx < endIdx) {
                char temp = wordArray[startIdx];
                wordArray[startIdx] = wordArray[endIdx];
                wordArray[endIdx] = temp;

                startIdx++;
                endIdx--;
            }

            String answer = String.valueOf(wordArray);
            answers.add(answer);
        }

        return answers;
    }
}
