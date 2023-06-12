package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 숫자만추출 {

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
        input = input.replaceAll("[^0-9]", "");
        return Integer.valueOf(input).toString();
    }

    /**
     * 강의 풀이
     * <p>
     * character 는 정수형, ASCII 번호가 48 ~ 56 이면 문자형 숫자.
     * 곱하기 10을 이용하여 자릿수 누적
     * <p>
     * 대문자 ASCII : 65 ~ 90
     * 소문자 ASCII : 97 ~ 122
     * 문자형 숫자 ASCII : 48 ~ 56
     *
     * @param inputs
     * @return
     */
    private static int solution2(String inputs) {
        int answer = 0;
        for (char input : inputs.toCharArray()) {
            /** 첫 번째 풀이 */
            // if (input >= 48 && input <= 57) {
            //     // 자릿수를 늘리기 위한 곱하기 10
            //     answer = answer * 10 + (input - 48);
            // }

            /** 두 번째 풀이 */
            if (Character.isDigit(input)) {
                // input 값 그대로 연산 시, 문자열 0의 정수값인 48로 계산이 됨, 주의!
                answer = answer * 10 + Integer.parseInt(String.valueOf(input));
            }
        }
        return answer;
    }
}
