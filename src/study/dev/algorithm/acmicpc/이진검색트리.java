package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리 {

    /**
     * INPUT
     * <p>
     * 50
     * 30
     * 24
     * 5
     * 28
     * 45
     * 98
     * 52
     * 60
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node node = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.equals("")) {
                break;
            }
            node.addNode(Integer.parseInt(temp));
        }
        node.printPostorder();
    }

    private static class Node {
        int value;

        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void addNode(int value) {
            if (this.value > value) {
                if (this.left == null) this.left = new Node(value);
                else this.left.addNode(value);
            } else {
                if (this.right == null) this.right = new Node(value);
                else this.right.addNode(value);
            }
        }

        public void printPostorder() {
            if (this.left != null) this.left.printPostorder();
            if (this.right != null) this.right.printPostorder();
            System.out.println(this.value);
        }
    }
}
