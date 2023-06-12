package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 문자찾기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        char input2 = in.next().charAt(0);
        int answer1 = solution1(input1, input2);
        int answer2 = solution2(input1, input2);
        System.out.println(answer1);
        System.out.println(answer2);
    }

    /**
     * 내 풀이
     *
     * @param input1
     * @param input2
     * @return
     */
    public static int solution1(String input1, char input2) {
        int count = 0;
        input2 = Character.toLowerCase(input2);
        for (char t : input1.toLowerCase().toCharArray()) {
            if (t == input2) {
                count++;
            }
        }
        return count;
    }

    /**
     * 강의 풀이
     *
     * @param input1
     * @param input2
     * @return
     */
    public static int solution2(String input1, char input2) {
        int count = 0;
        input1 = input1.toLowerCase();
        input2 = Character.toLowerCase(input2);
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2) {
                count++;
            }
        }
        return count;
    }
}
