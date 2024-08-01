package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 삼각달팽이 {

    public static void main(String[] args) {
        Arrays.stream(solution(4)).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(5)).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(6)).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(int n) {
        int[][] triangle = new int[n][n];

        // -1부터 시작하는 이유는 처음 i % 3 == 0 조건에 x++이 수행되므로 1부터 시작하지 않기 위해
        int x = -1, y = 0, number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 삼각형의 성질을 이용하여 방향을 바꿈
                if (i % 3 == 0) { // 0 일때 아래, 3 일때 아래, 6 일때 아래 ...
                    x++;
                } else if (i % 3 == 1) { // 1 일때 우측, 4 일때 우측, 7 일때 아래 ...
                    y++;
                } else if (i % 3 == 2) { // 2 일때 대각선 좌측, 5 일때 대각선 좌측, 8 일때 대각선 좌측 ...
                    x--;
                    y--;
                }

                triangle[x][y] = number++;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        outer:
        for (int[] arr : triangle) {
            for (int i : arr) {
                if (i == 0) continue outer;
                answer.add(i);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
