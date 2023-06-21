package study.dev.algorithm.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int h = in.nextInt();

        Queue<Coordinate> queue = new LinkedList<>();

        int[][][] box = new int[h][n][m], days = new int[h][n][m];

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int input = in.nextInt();
                    box[z][y][x] = input;
                    if (input == 1) {
                        queue.offer(new Coordinate(x, y, z));
                    }
                }
            }
        }

        int answer = solution(queue, box, days, m, n, h);
        System.out.println(answer);
    }

    private static int solution(Queue<Coordinate> queue, int[][][] box, int[][][] days, int m, int n, int h) {
        int day = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nh = current.z + dh[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && nh >= 0 && nh < h) {
                    if (box[nh][ny][nx] == 0) {
                        box[nh][ny][nx] = 1;
                        queue.offer(new Coordinate(nx, ny, nh));
                        days[nh][ny][nx] = days[current.z][current.y][current.x] + 1;
                    }
                }
            }
        }

        // 모두 익지 못하는 상황
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (box[z][y][x] == 0) {
                        return -1;
                    }
                }
            }
        }

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (day < days[z][y][x]) {
                        day = Math.max(day, days[z][y][x]);
                    }
                }
            }
        }

        return day;
    }

    private static class Coordinate {
        int x, y, z;

        public Coordinate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
