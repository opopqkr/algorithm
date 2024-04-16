package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 서강그라운드 {

    /**
     * INPUT
     * <p>
     * 5 5 4
     * 5 7 8 2 3
     * 1 4 5
     * 5 2 4
     * 3 2 3
     * 1 2 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        itemCount = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }

        edgeInfo = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edgeInfo.add(new ArrayList<>());
        }

        for (int i = 1; i <= r; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int vertex1 = temp[0], vertex2 = temp[1], distance = temp[2];

            edgeInfo.get(vertex1).add(new Edge(vertex2, distance));
            edgeInfo.get(vertex2).add(new Edge(vertex1, distance));
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        return answer;
    }

    private static int dijkstra(int start) {
        int count = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(start, 0));

        boolean[] visited = new boolean[n + 1];

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();

            if (visited[current.vertex]) continue;

            visited[current.vertex] = true;
            count += itemCount[current.vertex];

            for (Edge next : edgeInfo.get(current.vertex)) {
                int totalDistance = current.distance + next.distance;
                if (!visited[next.vertex] && totalDistance <= m) {
                    // visit[next.vertex] = true;
                    // count += itemCount[next.vertex];
                    // 위와 같이 해당 조건문 내에서 방문 처리 및 item 갯수에 대한 연산을 하면 틀림.
                    // 다익스트라(우선순위 큐)이기 때문에 offer() 이전,
                    // 방문 처리 및 item 갯수 연산처리를 하면 단순 list 순서대로 수행 되기 때문에 짧은 거리순으로 연산이 처리되지 않음.
                    priorityQueue.offer(new Edge(next.vertex, totalDistance));
                }
            }
        }

        return count;
    }

    private static int n, m, r;

    private static int[] itemCount;

    private static ArrayList<ArrayList<Edge>> edgeInfo;

    private static class Edge implements Comparable<Edge> {

        int vertex, distance;

        public Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}
