package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {

    /**
     * INPUT
     * <p>
     * 7
     * A B C
     * B D .
     * C E F
     * E . .
     * F . G
     * D . .
     * G . .
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node node = new Node('A');
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            node.add(parent, left, right);
        }

        solution(node);
    }

    private static void solution(Node node) {
        node.printPreorder();
        System.out.println();

        node.printInorder();
        System.out.println();

        node.printPostorder();
        System.out.println();
    }

    private static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
        }

        public void add(char parent, char left, char right) {
            if (this.value == parent) {
                if (left != '.') this.left = new Node(left);
                if (right != '.') this.right = new Node(right);
            } else {
                if (this.left != null) this.left.add(parent, left, right);
                if (this.right != null) this.right.add(parent, left, right);
            }
        }

        public void printPreorder() {
            System.out.print(this.value);
            if (this.left != null) this.left.printPreorder();
            if (this.right != null) this.right.printPreorder();
        }

        public void printInorder() {
            if (this.left != null) this.left.printInorder();
            System.out.print(this.value);
            if (this.right != null) this.right.printInorder();
        }

        public void printPostorder() {
            if (this.left != null) this.left.printPostorder();
            if (this.right != null) this.right.printPostorder();
            System.out.print(this.value);
        }
    }
}
