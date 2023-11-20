package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 행렬테두리회전하기 {

    public static void main(String[] args) {
        Arrays.stream(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(100, 97, new int[][]{{1, 1, 100, 97}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static int[][] map;

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int index = 1;
        map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = index++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    private static int rotate(int[] query) {
        int min = Integer.MAX_VALUE;

        int x1 = query[0] - 1, y1 = query[1] - 1, x2 = query[2] - 1, y2 = query[3] - 1;

        int temp = map[x1][y2];
        for (int j = y2; j > y1; j--) {
            map[x1][j] = map[x1][j - 1];
            min = Math.min(map[x1][j], min);
        }

        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(map[i][y1], min);
        }

        for (int j = y1; j < y2; j++) {
            map[x2][j] = map[x2][j + 1];
            min = Math.min(map[x2][j], min);
        }

        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(map[i][y2], min);
        }

        map[x1 + 1][y2] = temp;
        min = Math.min(temp, min);

        return min;
    }
}
