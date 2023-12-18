package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.acmicpc.net/problem/1068">트리 1068번</a>
 * Binary Tree 아님 주의!
 */
public class 트리2 {

    /**
     * INPUT
     * <p>
     * 5
     * -1 0 0 1 1
     * 2
     * <p>
     * 5
     * -1 0 0 1 1
     * 1
     * <p>
     * 5
     * -1 0 0 1 1
     * 0
     * <p>
     * 9
     * -1 0 0 2 2 4 4 6 6
     * 4
     * <p>
     * 반례 1
     * 9
     * -1 0 0 5 2 4 4 6 6
     * 4
     * 반례 2
     * 2
     * -1 0
     * 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(i, new ArrayList<>());
        }

        String[] parents = br.readLine().split(" ");
        for (int child = 0; child < parents.length; child++) {
            int parent = Integer.parseInt(parents[child]);
            if (parent == -1) {
                queue.offer(child);
            } else {
                tree.get(parent).add(child);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());
        System.out.println(bfs(deleteNode, queue, tree));
    }

    private static int bfs(int deleteNode, Queue<Integer> queue, ArrayList<ArrayList<Integer>> tree) {
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == deleteNode) {
                continue;
            }

            // 리프 노드 체크
            if (isLeafNode(deleteNode, tree.get(current))) {
                count++;
                continue;
            }

            for (int child : tree.get(current)) {
                queue.offer(child);
            }
        }

        return count;
    }

    /**
     * 1. 자식 노드가 없으면 리프 노드
     * 2. 자식 노드 중, 삭제할 노드가 있고 삭제할 노드를 제외 했을 때 자식 노드의 크기가 0이면 리프 노드
     *
     * @param deleteNode - 삭제할 노드
     * @param childNodes - 자식 노드
     */
    private static boolean isLeafNode(int deleteNode, ArrayList<Integer> childNodes) {
        return childNodes.isEmpty() || (childNodes.contains(deleteNode) && childNodes.size() - 1 == 0);
    }
}
