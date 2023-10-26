package study.dev.algorithm.programmers;

public class 네트워크DFS {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i, check, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int current, boolean[] check, int[][] computers) {
        check[current] = true;

        for (int i = 0; i < computers[current].length; i++) {
            if (!check[i] && computers[current][i] == 1) {
                dfs(i, check, computers);
            }
        }
    }
}
