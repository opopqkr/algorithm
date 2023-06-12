package study.dev.algorithm.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solution1(n, k));
        System.out.println(solution2(n, k));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param k
     * @return
     */
    private static int solution1(int n, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int temp = 0;
        while (queue.size() != 1) {
            temp++;
            if (temp == k) {
                temp = 0;
                queue.poll();
            } else {
                queue.offer(queue.poll());
            }
        }

        answer = queue.poll();
        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param k
     * @return
     */
    private static int solution2(int n, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.poll();
            }
        }

        return answer;
    }
}
