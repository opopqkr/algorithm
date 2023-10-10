package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 여행경로DFS {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 1, 2번 케이스 반례 (모든 경로 탐색)
        Arrays.stream(solution(new String[][]{{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static ArrayList<String> routeList;

    public static String[] solution(String[][] tickets) {
        routeList = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        dfs("ICN", "ICN", 0, visited, tickets);
        Collections.sort(routeList);

        return routeList.get(0).split("/");
    }

    public static void dfs(String start, String route, int numberOfVisit, boolean[] visited, String[][] tickets) {
        if (numberOfVisit == tickets.length) {
            routeList.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route + "/" + tickets[i][1], numberOfVisit + 1, visited, tickets);
                visited[i] = false;
            }
        }
    }
}
