package study.dev.algorithm.재귀.DFS;

/**
 * DFS 방식 풀이
 * 최단 거리 문제이니 BFS 방식으로 푸는 것이 좋음
 * <p>
 * DFS 방식 풀이로는 한계가 있는데, 자식 노드가 한 쪽만 있으면 풀이가 어려움.
 * 자식 노드가 둘 다 있을 경우 풀 수 있음.
 */
public class 말단노드까지의가장짧은경로 {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.leftNode = new Node(2);
        rootNode.rightNode = new Node(3);
        rootNode.leftNode.leftNode = new Node(4);
        rootNode.leftNode.rightNode = new Node(5);

        System.out.println(dfs(0, rootNode));
    }

    private static int dfs(int level, Node node) {
        if (node.leftNode == null && node.rightNode == null) {
            return level;
        } else {
            return Math.min(dfs(level + 1, node.leftNode),
                            dfs(level + 1, node.rightNode));
        }
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

