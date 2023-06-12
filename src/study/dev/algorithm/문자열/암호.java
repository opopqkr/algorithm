package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 암호 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String inputs = in.next();
        System.out.println(solution1(n, inputs));
        System.out.println(solution2(n, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static String solution1(int n, String inputs) {
        String answer = "";
        inputs = inputs.replaceAll("[^#]", "0").replaceAll("#", "1");

        for (int i = 0; i < n; i++) {
            String word = inputs.substring((i * 7), (i + 1) * 7);

            int result = 0;
            // 뒤의 인덱스 부터 / StringBuilder reverse 하여 풀어도 무관할듯..
            for (int j = word.length() - 1; j >= 0; j--) {
                int temp = 1 * Integer.parseInt(String.valueOf(word.charAt(j)));
                for (int x = word.length() - 1; x > j; x--) {
                    temp = temp * 2;
                }
                result += temp;
            }
            answer += (char) result;
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static String solution2(int n, String inputs) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String temp = inputs.substring(0, 7)
                    .replace('#', '1')
                    .replace('*', '0');
            // parseInt()의 인자값의 마지막 인자값으로 2를 넣을 경우 2진수를 10 진수로 바꾸어줌
            int number = Integer.parseInt(temp, 2);
            answer += (char) number;

            // 0~6 까지 자른 후, inputs 문자열을 substring 한 이후의 나머지 문자열로 갱신 해주어야 함.
            inputs = inputs.substring(7);
        }

        return answer;
    }
}
