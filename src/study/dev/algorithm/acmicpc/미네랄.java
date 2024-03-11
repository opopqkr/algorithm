package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄 {

    /**
     * INPUT
     * <p>
     * 5 6
     * ......
     * ..xx..
     * ..x...
     * ..xx..
     * .xxxx.
     * 1
     * 3
     * <p>
     * 8 8
     * ........
     * ........
     * ...x.xx.
     * ...xxx..
     * ..xxx...
     * ..x.xxx.
     * ..x...x.
     * .xxx..x.
     * 5
     * 6 6 4 3 1
     * <p>
     * 7 6
     * ......
     * ......
     * xx....
     * .xx...
     * ..xx..
     * ...xx.
     * ....x.
     * 2
     * 6 4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int N = Integer.parseInt(br.readLine());

        heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    private static int R, C;
    private static char[][] map;
    private static int[] heights;
    private final static int[] dx = {-1, 0, 1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    private static void solution() {
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            // 파괴된 미네랄이 없으면 continue
            boolean isDestroyed = destroy(height, i % 2 == 0 ? "left" : "right");
            if (!isDestroyed) continue;

            // 클러스터 찾기
            ArrayList<Coordinate> clusters = findCluster();
            if (!clusters.isEmpty())
                moveDown(map, clusters);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean destroy(int height, String order) {
        if (order.equals("left")) {
            for (int i = 0; i < C; i++) {
                if (map[R - height][i] == 'x') {
                    map[R - height][i] = '.';
                    return true;
                }
            }
        } else {
            for (int i = C - 1; i >= 0; i--) {
                if (map[R - height][i] == 'x') {
                    map[R - height][i] = '.';
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<Coordinate> findCluster() {
        boolean[][] visited = new boolean[R][C];

        // 바닥에 붙어 있는 클러스터 방문 처리
        for (int j = 0; j < C; j++) {
            if (map[R - 1][j] == 'x' && !visited[R - 1][j])
                visitBottomWithBFS(visited, new Coordinate(R - 1, j));
        }

        // 바닥에서 부터 떨어져 있는 클러스터
        ArrayList<Coordinate> clusters = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    clusters.add(new Coordinate(i, j));
                }
            }
        }

        return clusters;
    }

    private static void visitBottomWithBFS(boolean[][] visited, Coordinate start) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);

        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isRange(nx, ny) && map[nx][ny] == 'x' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Coordinate(nx, ny));
                }
            }
        }
    }

    private static void moveDown(char[][] map, ArrayList<Coordinate> clusters) {
        for (Coordinate cluster : clusters) {
            map[cluster.x][cluster.y] = '.';
        }

        boolean down = true;
        while (down) {
            for (Coordinate cluster : clusters) {
                int nx = cluster.x + 1;

                if (!isRange(nx, cluster.y) || map[nx][cluster.y] == 'x') {
                    down = false;
                    break;
                }
            }
            if (down) {
                for (Coordinate cluster : clusters) {
                    cluster.x++;
                }
            }
        }

        for (Coordinate cluster : clusters) {
            map[cluster.x][cluster.y] = 'x';
        }
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
