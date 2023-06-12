package study.dev.algorithm.재귀.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리통로 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] distance = new int[8][8];
        int[][] miro = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                miro[i][j] = in.nextInt();
            }
        }
        int[][] result = bfs(1, 1, miro, distance);
        if (result[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result[7][7]);
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int[][] bfs(int x, int y, int[][] miro, int[][] distance) {
        Queue<Coordinate> queue = new LinkedList();
        queue.offer(new Coordinate(x, y));

        miro[x][y] = 1;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7) {
                    if (miro[nx][ny] == 0) {
                        miro[nx][ny] = 1;
                        queue.offer(new Coordinate(nx, ny));
                        distance[nx][ny] = distance[current.x][current.y] + 1;
                    }
                }
            }
        }

        return distance;
    }

    /**
     * 좌표
     */
    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
