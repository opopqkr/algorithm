package study.dev.algorithm.acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트리의지름2 {

    private static int answer = 0, furthestEdge = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();

        ArrayList<ArrayList<Edge>> tree = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            tree.add(i, new ArrayList<>());
        }

        for (int i = 1; i <= v; i++) {
            int index = in.nextInt();
            while (true) {
                int temp = in.nextInt();
                if (temp != -1) {
                    tree.get(index).add(new Edge(temp, in.nextInt()));
                } else {
                    break;
                }
            }
        }

        bfs(tree, 1);
        bfs(tree, furthestEdge);

        System.out.println(answer);
    }

    private static void bfs(ArrayList<ArrayList<Edge>> tree, int startPoint) {
        boolean[] check = new boolean[tree.size()];

        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(startPoint, 0));
        check[startPoint] = true;

        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            int currentVertex = currentEdge.vertex;
            int currentDistance = currentEdge.distance;

            if (answer < currentDistance) {
                answer = currentDistance;
                furthestEdge = currentVertex;
            }

            for (Edge otherEdge : tree.get(currentVertex)) {
                if (!check[otherEdge.vertex]) {
                    check[otherEdge.vertex] = true;
                    queue.offer(new Edge(otherEdge.vertex, currentDistance + otherEdge.distance));
                }
            }
        }
    }

    private static class Edge {
        int vertex, distance;

        public Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
