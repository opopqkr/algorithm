package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    /**
     * INPUT
     * <p>
     * 7
     * 1 6
     * 6 3
     * 3 5
     * 4 1
     * 2 4
     * 4 7
     * <p>
     * 12
     * 1 2
     * 1 3
     * 2 4
     * 3 5
     * 3 6
     * 4 7
     * 4 8
     * 5 9
     * 5 10
     * 6 11
     * 6 12
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int edge1 = Integer.parseInt(st.nextToken()), edge2 = Integer.parseInt(st.nextToken());
            tree.get(edge1).add(edge2);
            tree.get(edge2).add(edge1);
        }

        int[] answer = bfs(tree);
        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    private static int[] bfs(ArrayList<ArrayList<Integer>> tree) {
        int[] parent = new int[tree.size()];

        boolean[] visited = new boolean[tree.size()];
        visited[1] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree.get(current)) {
                // 트리의 특성 이용.
                // 현재 노드와 연결된 노드 중, 이미 방문한 노드는 다른 노드의 자식 노드기 때문에 체크 하지 않음.
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    // 방문 하지 않은 노드는 현재 노드의 자식 노드가 됨.
                    parent[next] = current;
                }
            }
        }

        return parent;
    }
}
