package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 도넛과막대그래프 {

    public static void main(String[] args) {
        Arrays.stream(solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})).forEach(o -> System.out.print(o + " "));
        System.out.println();

        Arrays.stream(
                solution(new int[][]{{4, 11}, {1, 12}, {8, 3},
                        {12, 7}, {4, 2}, {7, 11}, {4, 8},
                        {9, 6}, {10, 11}, {6, 10}, {3, 5},
                        {11, 1}, {5, 3}, {11, 9}, {3, 8}})).forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    private static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int max = Integer.MIN_VALUE; // 가장 높은 Edge 번호
        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }

        ArrayList<Edge> graph = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            graph.add(new Edge(i)); // Edge 생성
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).connect(graph.get(edge[1])); // Edge 연결
        }

        // 시작 Edge, 들어오는 간선 없이 나가는 간선이 2개 이상인 것
        Edge createEdge = graph.stream().filter(o -> o.in == 0 && o.out >= 2)
                .findFirst().get();
        answer[0] = createEdge.number;

        for (Edge edge : createEdge.connected) {
            answer[edge.getShape()]++;
        }

        return answer;
    }

    private static class Edge {
        int number, in, out;

        boolean visited;

        ArrayList<Edge> connected;

        public Edge(int number) {
            this.number = number;
            this.in = 0;
            this.out = 0;
            this.connected = new ArrayList<>();
        }

        public void connect(Edge other) {
            this.out++;
            other.in++;
            connected.add(other);
        }

        public int getShape() {
            Queue<Edge> queue = new LinkedList<>();
            queue.offer(this);

            while (!queue.isEmpty()) {
                Edge current = queue.poll();

                // 나가는 간선이 0이거나 연결된 edge가 없을 경우 막대그래프
                if (current.out == 0 || current.connected.isEmpty())
                    return 2;

                // 나가는 간선과 들어오는 간선이 2개 이상일 경우, 8모양 그래프
                if (current.out >= 2 && current.in >= 2)
                    return 3;

                for (Edge next : current.connected) {
                    if (!next.visited) {
                        next.visited = true;
                        queue.offer(next);
                    }
                }
            }

            // 그 외의 경우 도넛 모양 그래프
            return 1;
        }
    }
}
