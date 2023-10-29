package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 양과늑대 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));
        System.out.println(solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}));
    }

    private static int answer;

    public static int solution(int[] info, int[][] edges) {
        answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        // 단 방향 그래프 생성
        Arrays.stream(edges).forEach(edge -> graph.get(edge[0]).add(edge[1]));

        // 루트 노드는 항상 양
        boolean[] check = new boolean[info.length];
        check[0] = true;
        dfs(1, 0, check, info, graph);

        return answer;
    }

    private static void dfs(int sheepCount, int wolfCount, boolean[] check, int[] info, ArrayList<ArrayList<Integer>> graph) {
        if (sheepCount <= wolfCount) {
            return;
        } else {
            answer = Math.max(answer, sheepCount);
        }

        for (int parent = 0; parent < info.length; parent++) {
            for (int child : graph.get(parent)) {
                // 부모 노드가 check 되어 있으면서 자식 노드가 check 되어 있지 않아야 함.
                // 부모 노드 check 조건이 빠질 경우, 부모 노드로 부터 왔다는 보장 없이 양을 카운트 할 수 있기 때문에 오답 발생.
                if (check[parent] && !check[child]) {
                    check[child] = true;
                    if (info[child] == 0) dfs(sheepCount + 1, wolfCount, check, info, graph);
                    else dfs(sheepCount, wolfCount + 1, check, info, graph);
                    check[child] = false;
                }
            }
        }
    }
}
