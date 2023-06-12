package study.dev.algorithm.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        // System.out.println(solution1(n, board, m, moves));
        System.out.println(solution2(board, moves));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param board
     * @param m
     * @param moves
     * @return
     */
    private static int solution1(int n, int[][] board, int m, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();

        for (int i = 0; i < m; i++) {
            int sp = 0;
            while (sp < n) {
                if (board[sp][moves[i] - 1] == 0) {
                    sp++;
                } else {
                    break;
                }
            }

            if (sp >= n) {
                continue;
            }

            int doll = board[sp][moves[i] - 1];

            if (bucket.isEmpty()) {
                bucket.push(doll);
            } else {
                int bucketInDoll = bucket.pop();
                if (doll == bucketInDoll) {
                    answer += 2;
                } else {
                    bucket.push(bucketInDoll);
                    bucket.push(doll);
                }
            }
            board[sp][moves[i] - 1] = 0;
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param board
     * @param moves
     * @return
     */
    private static int solution2(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();

        for (int position : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][position - 1] != 0) {
                    int doll = board[i][position - 1];
                    board[i][position - 1] = 0;
                    /* stack.pop()은 최상단의 값을 꺼내지만 stack.peek()은 최상단의 값만 확인 */
                    if (!bucket.isEmpty() && doll == bucket.peek()) {
                        answer += 2;
                        bucket.pop();
                    } else {
                        bucket.push(doll);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
