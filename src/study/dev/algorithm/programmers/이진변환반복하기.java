package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        Arrays.stream(solution("110010101001")).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("01110")).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("1111111")).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static int[] solution(String s) {
        int[] answer = new int[2];

        while (!"1".equals(s)) {
            int count = 0;
            for (char num : s.toCharArray()) {
                if (num == '0') answer[1]++;
                else count++;
            }

            s = toBinaryString(count);
            // s = Integer.toBinaryString(count);
            answer[0]++;
        }

        return answer;
    }

    private static String toBinaryString(int number) {
        StringBuilder sb = new StringBuilder();

        while (number != 0) {
            sb.append(number % 2);
            number /= 2;
        }

        return sb.reverse().toString();
    }
}
