package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N과M9 {

    /**
     * INPUT
     * <p>
     * 4 2
     * 9 7 9 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        dfs(M, 0, "", input, new boolean[N], new LinkedHashSet<>()).forEach(System.out::println);
    }

    private static LinkedHashSet<String> dfs(int M, int depth, String output, int[] input, boolean[] visited, LinkedHashSet<String> set) {
        if (depth == M) {
            set.add(output.trim());
        } else {
            for (int i = 0; i < input.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(M, depth + 1, output + " " + input[i], input, visited, set);
                    visited[i] = false;
                }
            }
        }

        return set;
    }
}
