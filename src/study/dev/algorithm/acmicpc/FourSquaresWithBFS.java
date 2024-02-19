package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FourSquaresWithBFS {

    /**
     * INPUT
     * <p>
     * 25
     * <p>
     * 26
     * <p>
     * 11339
     * <p>
     * 34567
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int sqrt = (int) Math.sqrt(n);

        // 루트 n 이전까지의 제곱근 초기화.
        int[] powNumbers = new int[sqrt + 1];
        for (int i = 1; i < powNumbers.length; i++) {
            powNumbers[i] = (int) Math.pow(i, 2);
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == 0) {
                    return answer;
                }

                for (int powNumber : powNumbers) {
                    int next = current - powNumber;

                    if (next > n) break;
                    if (next < 0) continue;

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            answer++;
        }

        return answer;
    }
}
