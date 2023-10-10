package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        long start = 1, end = (long) Arrays.stream(times).max().orElse(0) * n;

        while (start <= end) {
            long mid = (start + end) / 2;

            long pass = 0;
            for (int time : times) {
                pass += mid / time;
            }

            if (pass >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
