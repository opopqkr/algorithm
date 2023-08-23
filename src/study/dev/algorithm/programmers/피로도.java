package study.dev.algorithm.programmers;

public class 피로도 {

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}})); // 3
        // System.out.println(solution(100, new int[][]{{100, 1}, {99, 1}, {99, 1}, {99, 1}, {99, 1}, {99, 1}, {99, 1}})); // 반례 2
        // System.out.println(solution(8, new int[][]{{7, 3}, {5, 1}, {1, 1}})); // 반례 3
        // System.out.println(solution(10, new int[][]{{10, 3}, {9, 2}, {7, 3}, {5, 4}, {1, 1}})); // 반례 4
    }

    private static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        recursive(k, dungeons, 1, visited);
        return answer;
    }

    private static void recursive(int k, int[][] dungeons, int count, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            // 던전에 방문하지 않고 최소필요피로도를 충족해야 함.
            if (!visited[i] && k >= dungeons[i][0]) {
                answer = Math.max(answer, count);
                visited[i] = true;
                recursive(k - dungeons[i][1], dungeons, count + 1, visited);
                visited[i] = false;
            }
        }
    }
}
