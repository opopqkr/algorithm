package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    /**
     * INPUT
     * <p>
     * 7 7
     * 2 0 0 0 1 1 0
     * 0 0 1 0 1 2 0
     * 0 1 1 0 1 0 0
     * 0 1 0 0 0 0 0
     * 0 0 0 0 0 1 1
     * 0 1 0 0 0 0 0
     * 0 1 0 0 0 0 0
     * <p>
     * 4 6
     * 0 0 0 0 0 0
     * 1 0 0 0 0 2
     * 1 1 1 0 0 2
     * 0 0 0 0 0 2
     * <p>
     * 8 8
     * 2 0 0 0 0 0 0 2
     * 2 0 0 0 0 0 0 2
     * 2 0 0 0 0 0 0 2
     * 2 0 0 0 0 0 0 2
     * 2 0 0 0 0 0 0 2
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virus = new ArrayList<>();

        safeZoneCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) safeZoneCount++;
                if (map[i][j] == 2) virus.add(new Coordinate(i, j));
            }
        }

        answer = Integer.MIN_VALUE;
        makeWall(0, new boolean[N][M]);
        System.out.println(answer);
    }

    private static int answer;

    private static int N, M;

    private static int[][] map;

    private static int safeZoneCount;

    private static ArrayList<Coordinate> virus;

    /**
     * 벽 만들기 (DFS)
     *
     * @param count - 만들 벽의 갯수 (최대 3개)
     */
    private static void makeWall(int count, boolean[][] visited) {
        // 벽이 3개가 만들어지면 안전 영역 최대값 비교
        if (count == 3) {
            answer = Math.max(answer, infection(new boolean[N][M]));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    map[i][j] = 1;
                    makeWall(count + 1, visited);
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    private static final int[] dx = {-1, 0, 1, 0};

    private static final int[] dy = {0, 1, 0, -1};

    /**
     * 전염병 확산 (BFS)
     *
     * @param spread - 전염병 확산 여부
     * @return count - 안전 구역 갯수 (새로운 벽 3개를 제외)
     */
    private static int infection(boolean[][] spread) {
        int[][] copyMap = copyMap();
        // 새로 만들어진 벽 3개를 제외한 기존의 안전 영역의 갯수
        int count = safeZoneCount - 3;

        Queue<Coordinate> queue = new LinkedList<>(virus);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 밖이거나, 이미 확산되었거나, 안전 영역이 아니면 continue
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || spread[nx][ny] || copyMap[nx][ny] != 0) continue;

                if (!spread[nx][ny] && copyMap[nx][ny] == 0) {
                    spread[nx][ny] = true;
                    copyMap[nx][ny] = 2;
                    count--;
                    queue.offer(new Coordinate(nx, ny));
                }
            }
        }

        return count;
    }

    private static int[][] copyMap() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
