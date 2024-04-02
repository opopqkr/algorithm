package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href="https://www.acmicpc.net/problem/16953">A → B 16953번</a>
 */
public class A에서B만들기 {

    /**
     * INPUT
     * <p>
     * 2 162
     * <p>
     * 4 42
     * <p>
     * 100 40021
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B));
    }

    private static int answer;

    private static boolean stop;

    private static int solution(long A, long B) {
        answer = Integer.MAX_VALUE;
        stop = false;

        dfs(1, A, B);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void dfs(int count, long A, long B) {
        if (stop) {
            return;
        }
        if (A > B) {
            return;
        }
        if (A == B) {
            answer = Math.min(answer, count);
            stop = true;
        }

        dfs(count + 1, A * 2, B);
        dfs(count + 1, Long.parseLong(A + "1"), B);
    }
}
