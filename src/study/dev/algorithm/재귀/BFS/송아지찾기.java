package study.dev.algorithm.재귀.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int e = in.nextInt();

        // System.out.println(bfs1(s, e));
        System.out.println(bfs2(s, e));
    }

    /**
     * 내 풀이
     * Time limit
     *
     * @param s
     * @param e
     * @return
     */
    private static int bfs1(int s, int e) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                if (current != e) {
                    if (current > e) {
                        queue.offer(current - 1);
                    } else {
                        queue.offer(current + 1);
                        queue.offer(current + 5);
                    }
                } else {
                    return answer;
                }
            }
            answer++;
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param s
     * @param e
     * @return
     */
    private static int bfs2(int s, int e) {
        int answer = 0;

        int[] directionArray = {-1, 1, 5};
        int[] check = new int[10001];
        check[s] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int currentLocation = queue.poll();

                for (int direction : directionArray) {
                    // 다음 위치
                    int nextLocation = currentLocation + direction;
                    if (nextLocation == e) {
                        return answer + 1;
                    }
                    // 다음 위치가 이미 있는지 체크, 다음 위치가 없으면 queue.offer();
                    if (check[nextLocation] == 0 && nextLocation >= 1 && nextLocation <= 10000) {
                        check[nextLocation] = 1;
                        queue.offer(nextLocation);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}
