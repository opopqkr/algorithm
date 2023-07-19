package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 무인도여행 {

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        // String[] maps = {"XXX", "XXX", "XXX"};

        for (int i : solution(maps)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();

        char[][] map = new char[maps.length][maps[0].length()];
        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].toCharArray()[j];
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int sum = check(i, j, map, visit);
                if (sum > 0) {
                    answer.add(sum);
                }
            }
        }

        Collections.sort(answer);
        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int check(int x, int y, char[][] map, boolean[][] visit) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
            return 0;
        } else if (map[x][y] == 'X' || visit[x][y]) {
            return 0;
        } else {
            visit[x][y] = true;

            int sum = Character.getNumericValue(map[x][y]);

            sum += check(x + 1, y, map, visit);
            sum += check(x - 1, y, map, visit);
            sum += check(x, y + 1, map, visit);
            sum += check(x, y - 1, map, visit);

            return sum;
        }
    }
}
