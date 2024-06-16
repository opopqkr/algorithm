package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 오목 {

    /**
     * INPUT
     * <p>
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0
     * 0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution());
    }

    private static int[][] board;

    private static final int[] dx = {-1, 0, 1, 1}; // 우측 대각선 상, 우, 우측 대각선 하, 하 (맨 왼쪽에 있는 바둑돌을 출력하기 위해)

    private static final int[] dy = {1, 1, 1, 0}; // 우측 대각선 상, 우, 우측 대각선 하, 하 (맨 왼쪽에 있는 바둑돌을 출력하기 위해)

    private static String solution() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0 && isWin(i, j, board[i][j])) {
                    sb.append(board[i][j])
                            .append("\n")
                            .append(i + 1)
                            .append(" ")
                            .append(j + 1);
                    return sb.toString();
                }
            }
        }

        return "0";
    }

    private static boolean isWin(int x, int y, int piece) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited;

        for (int direction = 0; direction < 4; direction++) {
            queue.offer(new Coordinate(x, y));
            visited = new boolean[19][19];
            int count = 0;

            while (!queue.isEmpty()) {
                Coordinate current = queue.poll();

                if (visited[current.x][current.y]) continue;
                visited[current.x][current.y] = true;
                count++;

                int nx = current.x + dx[direction];
                int ny = current.y + dy[direction];
                if (isRange(nx, ny) && piece == board[nx][ny])
                    queue.offer(new Coordinate(nx, ny));
            }

            if (count == 5) { // 5목이 되었을 경우, 6목 확인을 위해 반대 방향 체크.
                int rnx = x + (dx[direction] * -1);
                int rny = y + (dy[direction] * -1);
                return !(isRange(rnx, rny) && piece == board[rnx][rny]);
            }
        }

        return false;
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
