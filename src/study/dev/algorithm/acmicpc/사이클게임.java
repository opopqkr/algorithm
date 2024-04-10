package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임 {

    /**
     * INPUT
     * <p>
     * 6 5
     * 0 1
     * 1 2
     * 2 3
     * 5 4
     * 0 4
     * <p>
     * 6 5
     * 0 1
     * 1 2
     * 1 3
     * 0 3
     * 4 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        disjointSet = new int[N];
        for (int i = 0; i < N; i++) {
            disjointSet[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());

            if (find(start) == find(end)) {
                System.out.println(i);
                System.exit(0);
            } else {
                union(start, end);
            }
        }

        System.out.println(0);
    }

    private static int N, M;

    private static int[] disjointSet;

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y)
            disjointSet[x] = y;
        else
            disjointSet[y] = x;
    }

    private static int find(int x) {
        if (disjointSet[x] == x)
            return x;
        else
            return disjointSet[x] = find(disjointSet[x]);
    }
}
