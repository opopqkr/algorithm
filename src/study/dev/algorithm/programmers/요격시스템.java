package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int answer = 0, before = 0;
        for (int[] target : targets) {
            if (before <= target[0]) {
                before = target[1];
                answer++;
            }
        }

        return answer;
    }
}
