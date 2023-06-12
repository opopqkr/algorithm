package study.dev.algorithm.재귀.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 넓이 우선 탐색 (레벨 탐색), 최단 거리
 * <p>
 */
public class 이진트리순회 {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.leftNode = new Node(2);
        rootNode.rightNode = new Node(3);
        rootNode.leftNode.leftNode = new Node(4);
        rootNode.leftNode.rightNode = new Node(5);
        rootNode.rightNode.leftNode = new Node(6);
        rootNode.rightNode.rightNode = new Node(7);

        bfs(rootNode);
    }

    /**
     * Queue 를 활용
     *
     * @param node
     */
    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        int level = 1;
        while (!queue.isEmpty()) {
            System.out.print("Level : " + level + ", data : ");

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.leftNode != null) {
                    queue.offer(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    queue.offer(currentNode.rightNode);
                }
            }
            level++;
            System.out.println();
        }
    }
}

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}
