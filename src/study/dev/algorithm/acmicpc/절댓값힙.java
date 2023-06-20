package study.dev.algorithm.acmicpc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값힙 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        solution(array);
    }

    private static void solution(int[] array) {
        PriorityQueue<AbsInteger> priorityQueue = new PriorityQueue<>();

        for (int x : array) {
            if (x != 0) {
                priorityQueue.offer(new AbsInteger(x));
            } else {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll().x);
                }
            }
        }
    }

    private static class AbsInteger implements Comparable<AbsInteger> {
        int x;
        int abs;

        public AbsInteger(int x) {
            this.x = x;
            this.abs = Math.abs(x);
        }

        @Override
        public int compareTo(AbsInteger o) {
            if (this.abs == o.abs) {
                return this.x - o.x;
            } else {
                return this.abs - o.abs;
            }
        }
    }
}
