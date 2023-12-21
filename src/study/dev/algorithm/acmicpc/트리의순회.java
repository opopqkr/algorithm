package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 트리의순회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Node node = dfs(0, n - 1, 0, n - 1, inorder, postorder);
        if (node != null) {
            node.printPreorder();
        }
    }

    private static Node dfs(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, int[] inorder, int[] postorder) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        int root = postorder[postorderEnd];
        Node node = null;

        for (int i = inorderEnd - 1; i >= inorderStart; i--) {
            if (inorder[i] == root) {
                node = new Node(root);
                node.left = dfs(inorderStart, i, postorderStart, postorderStart + i - inorderStart - 1, inorder, postorder);
                node.right = dfs(i + 1, inorderEnd, postorderStart, postorderEnd - 1, inorder, postorder);
            }
        }

        return node;
    }

    private static class Node {
        int value;

        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void printPreorder() {
            System.out.print(this.value + " ");
            if (this.left != null) this.left.printPreorder();
            if (this.right != null) this.right.printPreorder();
        }
    }
}
