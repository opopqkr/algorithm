package study.dev.algorithm.정렬;

import java.util.Scanner;

public class LRU {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int n = in.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        for (int i : solution1(size, n, inputs)) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : solution2(size, n, inputs)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 내 풀이
     *
     * @param size
     * @param n
     * @param inputs
     * @return
     */
    private static int[] solution1(int size, int n, int[] inputs) {
        int[] cache = new int[size];

        for (int i = 0; i < n; i++) {
            int job = inputs[i];

            int index = existsCheck(job, cache);
            if (index == -1) {
                for (int j = size - 1; j > 0; j--) {
                    cache[j] = cache[j - 1];
                }
            } else {
                for (int j = index; j > 0; j--) {
                    cache[j] = cache[j - 1];
                }
            }

            cache[0] = job;
        }

        return cache;
    }

    private static int existsCheck(int job, int[] cache) {
        int index = -1;

        for (int i = 0; i < cache.length; i++) {
            if (job == cache[i]) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * 강의 풀이
     *
     * @param size
     * @param n
     * @param inputs
     * @return
     */
    private static int[] solution2(int size, int n, int[] inputs) {
        int cache[] = new int[size];

        for (int job : inputs) {
            int hitYn = -1;
            for (int i = 0; i < size; i++) {
                if (job == cache[i]) {
                    hitYn = i;
                }
            }

            if (hitYn == -1) {
                for (int i = size - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = hitYn; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = job;
        }
        
        return cache;
    }
}
