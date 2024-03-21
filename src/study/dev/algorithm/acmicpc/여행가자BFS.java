package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 여행가자BFS {

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

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new HashSet<>());
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) continue;

                map.get(i).add(j);
                map.get(j).add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        route = new int[M];
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static ArrayList<HashSet<Integer>> map;

    private static int[] route;

    private static String solution() {
        for (int i = 0; i < route.length - 1; i++) {
            if (!bfs(route[i], route[i + 1])) {
                return "NO";
            }
        }
        return "YES";
    }

    private static boolean bfs(int start, int end) {
        if (start == end) return true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[map.size()];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : map.get(current)) {
                if (next == end) return true;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }
}
