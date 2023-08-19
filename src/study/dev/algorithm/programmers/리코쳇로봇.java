package study.dev.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static int solution(String[] board) {
        int answer = 0;

        Coordinate start = null;
        Coordinate end = null;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new Coordinate(i, j, answer);
                } else if (board[i].charAt(j) == 'G') {
                    end = new Coordinate(i, j, answer);
                }
            }
        }

        answer = bfs(board, start, end);
        return answer;
    }

    private static int bfs(String[] board, Coordinate start, Coordinate end) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);

        // 방문 여부 체크하는 이유는 다시 제자리로 올 경우, 무한 루프에 빠질 수 있음.
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                return current.directionCount;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x;
                int ny = current.y;

                while (nx >= 0 && nx < board.length
                        && ny >= 0 && ny < board[nx].length()
                        && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 범위를 벗어나거나 한칸 더 움직이기 때문에 -dx[i], -dy[i]
                nx -= dx[i];
                ny -= dy[i];

                // 방문 하지 않았고, 현재의 좌표값과 다음 좌표가 다를 경우만 queue.offer()
                if (!visited[nx][ny] && !(current.x == nx && current.y == ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new Coordinate(nx, ny, current.directionCount + 1));
                }
            }
        }

        return -1;
    }

    private static class Coordinate {
        int x, y, directionCount;

        public Coordinate(int x, int y, int directionCount) {
            this.x = x;
            this.y = y;
            this.directionCount = directionCount;
        }
    }
}
