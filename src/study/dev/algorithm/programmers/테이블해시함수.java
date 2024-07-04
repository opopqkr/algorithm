package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 테이블해시함수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}},
                2, 2, 3));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // col - 1 기준으로 정렬, 같을 경우 0번째 기준으로 내림차순
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1])
                return o2[0] - o1[0];
            return o1[col - 1] - o2[col - 1];
        });

        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            answer ^= sum;
        }

        return answer;
    }
}
