package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 책페이지 {

    /**
     * INPUT
     * <p>
     * 11
     * <p>
     * 7
     * <p>
     * 19
     * <p>
     * 999
     * <p>
     * 543212345
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Arrays.stream(solution(N)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] solution(int N) {
        int[] counts = new int[10];

        int start = 1, end = N, digit = 1;

        while (start <= N) {
            while (start % 10 != 0 && start <= end) {
                calc(counts, start, digit);
                start++;
            }

            while (end % 10 != 9 && start <= end) {
                calc(counts, end, digit);
                end--;
            }

            if (start > end) break;

            start /= 10;
            end /= 10;

            for (int i = 0; i < counts.length; i++) {
                counts[i] += (end - start + 1) * digit;
            }

            digit *= 10;
        }

        return counts;
    }

    private static void calc(int[] counts, int number, int digit) {
        while (number > 0) {
            counts[number % 10] += digit;
            number /= 10;
        }
    }
}
