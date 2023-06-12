package study.dev.algorithm.재귀.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 말단노드까지의가장짧은경로 {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.leftNode = new Node(2);
        rootNode.rightNode = new Node(3);
        rootNode.leftNode.leftNode = new Node(4);
        rootNode.leftNode.rightNode = new Node(5);

        // System.out.println(bfs1(rootNode));
        System.out.println(bfs2(rootNode));
    }

    /**
     * 내 풀이
     *
     * @param node
     * @return
     */
    private static int bfs1(Node node) {
        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                if (currentNode.leftNode != null) {
                    queue.offer(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    queue.offer(currentNode.rightNode);
                }
            }
            level++;
            answer = Math.min(answer, level);
        }
        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param rootNode
     * @return
     */
    private static int bfs2(Node rootNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(rootNode);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                if (currentNode.leftNode == null && currentNode.rightNode == null) {
                    return level;
                } else {
                    if (currentNode.leftNode != null) {
                        queue.offer(currentNode.leftNode);
                    }
                    if (currentNode.rightNode != null) {
                        queue.offer(currentNode.rightNode);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
}
