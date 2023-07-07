package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 연속된부분수열의합 {

    public static void main(String[] args) {
        // int[] sequence = {1, 2, 3, 4, 5};
        // int k = 7;

        // int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        // int k = 5;

        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        int[] answer = solution(sequence, k);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[] sequence, int k) {
        int left = 0, sum = 0;

        ArrayList<Answer> answerList = new ArrayList<>();
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            if (sum == k) {
                answerList.add(new Answer(left, right));
            }

            while (sum >= k) {
                sum -= sequence[left++];
                if (sum == k) {
                    answerList.add(new Answer(left, right));
                }
            }
        }

        Collections.sort(answerList);
        return new int[]{answerList.get(0).left, answerList.get(0).right};
    }

    static class Answer implements Comparable<Answer> {
        int left, right, size;

        public Answer(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        @Override
        public int compareTo(Answer o) {
            if (this.size == o.size) {
                return this.left - o.left;
            }
            return this.size - o.size;
        }
    }
}
