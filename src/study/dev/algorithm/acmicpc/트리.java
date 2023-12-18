package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] preorder = new int[N], inorder = new int[N];

            String[] temp;

            temp = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                preorder[i] = Integer.parseInt(temp[i]);
            }

            temp = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                inorder[i] = Integer.parseInt(temp[i]);
            }

            Node node = addNode(0, preorder, inorder, N);
            if (node != null) {
                node.printPostorder();
                System.out.println();
            }
        }
    }

    private static class Node {

        int value;

        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void printPostorder() {
            if (this.left != null) this.left.printPostorder();
            if (this.right != null) this.right.printPostorder();
            System.out.print(this.value + " ");
        }
    }

    private static Node addNode(int index, int[] preorder, int[] inorder, int N) {
        if (index >= N) {
            return null;
        }

        // 1. 전위 순회의 맨 앞이 루트 노드, 따라서 전위 순회 배열의 0번째가 root 노드.
        // ex) 전위 순회 배열 [ 3 6 5 4 8 7 1 2 ]
        //     중위 순회 배열 [ 5 6 8 4 3 1 2 7 ]
        //     root 노드는 3.
        //
        // 3. 왼쪽 노드의 경우 - 전위 순회 배열에서 찾은 이전 root 노드의 index + 1이
        //                    이전 root 노드의 왼쪽 자식 노드가 되며 왼쪽 노드의 root 노드가 됨.
        // ex) 전위 순회 배열 [ 3 6 5 4 8 7 1 2 ]
        //     중위 순회 배열 [ 5 6 8 4 3 1 2 7 ]
        //     이전 root 노드가 3일 경우 >> 이전 root 노드(3)의 index + 1
        //                               = 0 + 1
        //                               = 1
        //                               그러므로, 전위 순회 배열[1] = 6이 이전 root 노드(3)의 왼쪽 자식 노드가 되며 왼쪽 노드의 root 노드.
        //
        //                                    3
        //                                 6     ?
        //                               ?   ?     ? 인 상태.
        //
        // 4. 오른쪽 노드의 경우 - 전위 순회 배열에서 찾은 이전 root 노드의 index + 1 + (중위 순회 배열에서 찾은 이전 root 노드의 index)가
        //                     이전 root 노드의 오른쪽 자식 노드가 되며 오른쪽 노드의 root 노드가 됨.
        // ex) 전위 순회 배열 [ 3 6 5 4 8 7 1 2 ]
        //     중위 순회 배열 [ 5 6 8 4 3 1 2 7 ]
        //     이전 root 노드가 3일 경우 >> 이전 root 노드(3)의 index + 1 + (중위 순회 배열에서 찾은 이전 root 노드의 index)
        //                               = 0 + 1 + 4
        //                               = 5
        //                               그러므로, 전위 순회 배열[5] = 7이 이전 root 노드(3)의 오른쪽 자식 노드가 되며 오른쪽 노드의 root 노드.
        //
        //                                    3
        //                                 6     7
        //                               ?   ?     ? 인 상태.
        //
        int root = preorder[index];

        Node node = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                node = new Node(root);

                // 2-1. 중위 순회 배열에서 root 노드 기준으로 왼쪽이 왼쪽 노드.
                // ex) 전위 순회 배열 [ 3 6 5 4 8 7 1 2 ]
                //     중위 순회 배열 [ 5 6 8 4 3 1 2 7 ]
                //     root 노드가 3일 경우, 왼쪽 노드는 [ 5 6 8 4 ]
                int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
                node.left = addNode(index + 1, preorder, leftInorder, N);

                // 2-2. 중위 순회 배열에서 root 노드 기준으로 오른쪽이 오른쪽 노드.
                // ex) 전위 순회 배열 [ 3 6 5 4 8 7 1 2 ]
                //     중위 순회 배열 [ 5 6 8 4 3 1 2 7 ]
                //     root 노드가 3일 경우, 오른쪽 노드는 [ 1 2 7 ]
                int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                node.right = addNode(index + i + 1, preorder, rightInorder, N);
            }
        }

        return node;
    }
}
