package study.dev.algorithm.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input1 = in.next();
        String input2 = in.next();

        System.out.println(solution1(input1, input2));
        System.out.println(solution2(input1, input2));
    }

    /**
     * 내 풀이
     *
     * @param input1
     * @param input2
     * @return
     */
    private static String solution1(String input1, String input2) {
        String answer = "YES";

        Queue<Character> queue = new LinkedList<>();
        for (char word : input1.toCharArray()) {
            queue.offer(word);
        }

        for (char word : input2.toCharArray()) {
            if (!queue.isEmpty() && word == queue.peek()) {
                queue.poll();
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param input1
     * @param input2
     * @return
     */
    private static String solution2(String input1, String input2) {
        String answer = "YES";

        Queue<Character> queue = new LinkedList<>();
        for (char need : input1.toCharArray()) {
            queue.offer(need);
        }

        for (char plan : input2.toCharArray()) {
            if (queue.contains(plan)) {
                if (plan != queue.poll()) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return answer;
    }
}
