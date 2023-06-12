package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 문자열압축 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputs = in.next();
        System.out.println(solution1(inputs));
        System.out.println(solution2(inputs));
    }

    /**
     * 내 풀이
     *
     * @param inputs
     * @return
     */
    private static String solution1(String inputs) {
        String answer = "";

        char[] wordArray = inputs.toCharArray();

        int i = 0;
        while (i < wordArray.length) {
            int count = 1;
            int compareIndex = i + 1;
            for (int j = compareIndex; j < wordArray.length; j++) {
                if (wordArray[i] == wordArray[j]) {
                    count++;
                    wordArray[j] = ' ';
                    wordArray[compareIndex] = Integer.toString(count).charAt(0);
                } else {
                    break;
                }
            }
            // 이미 검색한 index 는 건너 뜀.
            i += count;
        }

        for (char c : wordArray) {
            answer += c;
        }

        return answer.replaceAll(" ", "");
    }

    /**
     * 강의 풀이
     *
     * @param inputs
     * @return
     */
    private static String solution2(String inputs) {
        String answer = "";
        // 인덱스 범위 에러 방지를 위해서 빈 문자열 추가
        inputs = inputs + " ";

        int count = 1;
        // 빈 문자열 전 까지
        for (int i = 0; i < inputs.length() - 1; i++) {
            if (inputs.charAt(i) == inputs.charAt(i + 1)) {
                count++;
            } else {
                answer += inputs.charAt(i);
                if (count > 1) {
                    answer += String.valueOf(count);
                    count = 1;
                }
            }
        }
        return answer;
    }
}
