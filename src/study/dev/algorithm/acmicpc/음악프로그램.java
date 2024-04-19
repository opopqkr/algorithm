package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {

    /**
     * INPUT
     * <p>
     * 6 3
     * 3 1 4 3
     * 4 6 2 5 4
     * 2 2 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        entryLevel = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken()), before = 0;
            for (int j = 0; j < count; j++) {
                int current = Integer.parseInt(st.nextToken());

                if (before != 0) { // 첫 번째 순서는 생략
                    entryLevel[current]++; // 진입 차수 증가.
                    graph.get(before).add(current); // 이전 노드 -> 현재 노드 방향으로 연결.
                }

                before = current;
            }
        }

        System.out.println(solutionByTopologicalSort());
    }

    private static int N, M;

    private static int[] entryLevel;

    private static ArrayList<ArrayList<Integer>> graph;

    /**
     * 위상 정렬(Topological sorting) 유형
     * <p>
     * 순서가 정해져 있는 작업을 차례로 수행해야 할 떄 그 순서를 결정해주기 위한 알고리즘.
     *
     * @return - 위상 정렬 이후 순서
     */
    private static String solutionByTopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        // 노드로 들어오는 간선의 갯수가 0인 노드를 queue offer
        // 어떠한 노드가 먼저 들어가든 상관 없음.
        for (int i = 1; i <= N; i++) {
            if (entryLevel[i] == 0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            // queue 에서 poll.
            int current = queue.poll();

            sb.append(current).append("\n");

            // 큐에서 꺼낸 노드와 간선으로 연결된 노드들의 진입 차수를 감소.
            // 진입 차수 감소 후, 노드의 진입차수가 0이 되면 queue offer.
            for (int next : graph.get(current)) {
                entryLevel[next]--; // 진입차수 감소.
                if (entryLevel[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 모든 노드 확인 이후에, 진입 차수가 0이 아닌 노드가 있으면 순환 존재, 위상 정렬 불가.
        for (int i = 1; i <= N; i++) {
            if (entryLevel[i] != 0) return "0";
        }

        return sb.toString();
    }
}
