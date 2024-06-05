package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터큐 {

    /**
     * INPUT
     * <p>
     * 3
     * 1 0
     * 5
     * 4 2
     * 1 2 3 4
     * 6 0
     * 1 1 9 1 1 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N, M;
        int[] temp;
        Queue<Info> queue;
        while (T-- > 0) {
            temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = temp[0];
            M = temp[1];
            temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.offer(new Info(i, temp[i]));
            }
            System.out.println(solution(M, queue));
        }
    }

    private static int solution(int M, Queue<Info> queue) {
        int count = 0;

        while (!queue.isEmpty()) {
            Info max = queue.stream().max(Comparator.comparingInt(o -> o.priority)).get();
            Info current = queue.poll();

            if (max.priority > current.priority) {
                queue.offer(current);
            } else {
                count++;
                if (current.index == M) break;
            }
        }

        return count;
    }

    private static class Info {
        int index, priority;

        public Info(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
