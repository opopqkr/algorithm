package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 완전이진트리 {

    /**
     * INPUT
     * <p>
     * 2
     * 2 1 3
     * <p>
     * 3
     * 1 6 4 3 5 2 7
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] visited = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            tree.add(i, new ArrayList<>());
        }

        dfs(0, tree, K, visited);

        for (ArrayList<Integer> nodes : tree) {
            for (int node : nodes) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int depth, ArrayList<ArrayList<Integer>> tree, int K, int[] visited) {
        if (depth >= K) {
            return;
        }

        int mid = visited.length / 2;
        tree.get(depth).add(visited[mid]);

        int[] left = Arrays.copyOfRange(visited, 0, mid);
        dfs(depth + 1, tree, K, left);

        int[] right = Arrays.copyOfRange(visited, mid + 1, visited.length);
        dfs(depth + 1, tree, K, right);
    }
}
