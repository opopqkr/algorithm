package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 두큐합같게만들기 {

    public static void main(String[] args) {
        // int[] queue1 = {3, 2, 7, 2};
        // int[] queue2 = {4, 6, 5, 1};

        // int[] queue1 = {1, 2, 1, 2};
        // int[] queue2 = {1, 10, 1, 2};

        // int[] queue1 = {1, 1};
        // int[] queue2 = {1, 5};

        int[] queue1 = {1, 1, 1, 1, 1};
        int[] queue2 = {1, 1, 1, 9, 1};

        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        int[] copy_queue1 = new int[queue1.length + queue2.length];
        for (int i = 0; i < copy_queue1.length; i++) {
            if (i < queue1.length) {
                copy_queue1[i] = queue1[i];
            } else {
                copy_queue1[i] = queue2[i - queue1.length];
            }
        }

        int[] copy_queue2 = new int[queue1.length + queue2.length];
        for (int i = 0; i < copy_queue2.length; i++) {
            if (i < queue2.length) {
                copy_queue2[i] = queue2[i];
            } else {
                copy_queue2[i] = queue1[i - queue2.length];
            }
        }

        int pointer1 = 0, pointer2 = 0;

        while (true) {
            if (pointer1 >= copy_queue1.length || pointer2 >= copy_queue2.length) {
                return -1;
            }

            if (sum1 == sum2) {
                break;
            } else if (sum1 > sum2) {
                sum2 += copy_queue1[pointer1];
                sum1 -= copy_queue1[pointer1];
                pointer1++;
            } else {
                sum1 += copy_queue2[pointer2];
                sum2 -= copy_queue2[pointer2];
                pointer2++;
            }
        }

        return pointer1 + pointer2;
    }
}