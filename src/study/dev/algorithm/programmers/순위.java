package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 순위 {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public static int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<PlayerRecord> playerRecords = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            playerRecords.add(new PlayerRecord());
        }

        for (int[] result : results) {
            graph.get(result[0]).add(result[1]);
        }

        for (int player = 1; player <= n; player++) {
            bfs(player, n, playerRecords, graph);
        }

        int answer = 0;
        for (PlayerRecord player : playerRecords) {
            answer = player.hasRanked(n - 1) ? answer + 1 : answer;
        }

        return answer;
    }

    private static void bfs(int player, int n, ArrayList<PlayerRecord> playerRecords, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];

        queue.offer(player);
        check[player] = true;

        while (!queue.isEmpty()) {
            int winner = queue.poll();

            for (int loser : graph.get(winner)) {
                if (!check[loser]) {
                    check[loser] = true;
                    queue.offer(loser);
                    playerRecords.get(player).win++;
                    playerRecords.get(loser).lose++;
                }
            }
        }
    }

    private static class PlayerRecord {
        int win, lose;

        public boolean hasRanked(int numberOfMatches) {
            return this.win + this.lose == numberOfMatches;
        }
    }
}
