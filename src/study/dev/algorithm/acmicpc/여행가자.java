package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {

    /**
     * INPUT
     * <p>
     * 3
     * 3
     * 0 1 0
     * 1 0 1
     * 0 1 0
     * 1 2 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) continue;
                union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] route = new int[M];
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(route));
    }

    private static String solution(int[] route) {
        int start = route[0];
        for (int i = 1; i < route.length; i++) {
            if (parent[start] != parent[route[i]]) {
                return "NO";
            }
        }
        return "YES";
    }

    private static int[] parent;

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) parent[x] = y;
        else parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
