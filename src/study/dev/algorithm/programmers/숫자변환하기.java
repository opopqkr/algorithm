package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {

    public static void main(String[] args) {
        int x = 10, y = 40, n = 30;

        System.out.println(solution(x, y, n));
    }

    public static int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[y + 1];

        visit[x] = true;
        queue.offer(x);

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp == y) {
                    return answer;
                }

                if (temp * 2 <= y && !visit[temp * 2]) {
                    visit[temp * 2] = true;
                    queue.offer(temp * 2);
                }

                if (temp * 3 <= y && !visit[temp * 3]) {
                    visit[temp * 3] = true;
                    queue.offer(temp * 3);
                }

                if (temp + n <= y && !visit[temp + n]) {
                    visit[temp + n] = true;
                    queue.offer(temp + n);
                }
            }
            answer++;
        }

        return -1;
    }

    /**
     * 타임아웃
     *
     * @param x
     * @param y
     * @param n
     * @return
     */
    public static int solutionByDfs(int x, int y, int n) {
        answerList = new ArrayList<>();

        dfs(x, y, n, 0);

        if (answerList.isEmpty()) {
            return -1;
        } else {
            answerList.sort((o1, o2) -> o1 - o2);
            return answerList.get(0);
        }
    }

    private static ArrayList<Integer> answerList;

    private static void dfs(int x, int y, int n, int count) {
        if (x > y) {
            return;
        } else if (x == y) {
            answerList.add(count);
            return;
        } else {
            dfs(x * 3, y, n, count + 1);
            dfs(x * 2, y, n, count + 1);
            dfs(x + n, y, n, count + 1);
        }
    }
}
