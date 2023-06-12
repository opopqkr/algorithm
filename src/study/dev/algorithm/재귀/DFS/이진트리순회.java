package study.dev.algorithm.재귀.DFS;

/**
 * 깊이 우선 탐색
 * <p>
 * 전위 순회 : 부모 노드 - 왼쪽 자식 노드 - 오른쪽 자식 노드 <br>
 * 중위 순회 : 왼쪽 자식 노드 - 부모 노드 - 오른쪽 자식 노드 <br>
 * 후위 순회 : 왼쪽 자식 노드 - 오른쪽 자식 노드 - 부모 노드 (병합 정렬) <br>
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

        dfs(rootNode);
    }

    private static void dfs(Node node) {
        if (node == null) {
            return;
        } else {
            // System.out.print(node.data + " "); // 전위 순회
            dfs(node.leftNode);
            // System.out.print(node.data + " "); // 중위 순회
            dfs(node.rightNode);
            System.out.print(node.data + " "); // 후위 순회
        }
    }

}

/**
 * Node 객체
 */
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
