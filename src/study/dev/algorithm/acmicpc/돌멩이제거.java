package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 돌멩이제거 {

    /**
     * INPUT
     * <p>
     * 3 4
     * 1 1
     * 1 3
     * 2 2
     * 3 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        matched = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }

        System.out.println(solution());
    }

    private static int n, k;

    private static int[] matched;

    private static ArrayList<ArrayList<Integer>> graph;

    private static int solution() {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dfs(new boolean[n + 1], i))
                answer++;
        }

        return answer;
    }

    private static boolean dfs(boolean[] visited, int current) {
        for (int edge : graph.get(current)) {
            if (!visited[edge]) {
                visited[edge] = true;
                if (matched[edge] == 0 || dfs(visited, matched[edge])) {
                    matched[edge] = current;
                    return true;
                }
            }
        }

        return false;
    }
}
