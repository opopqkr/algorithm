package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isKeepingSuccess(createSeatingChart(places[i]), places[i]) ? answer[i] + 1 : answer[i];
        }

        return answer;
    }

    private static class Seat {
        int x, y;

        public Seat(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Queue<Seat> createSeatingChart(String[] place) {
        Queue<Seat> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    queue.offer(new Seat(i, j));
                }
            }
        }

        return queue;
    }

    private final static int[] d1x = {-1, 0, 1, 0}, d1y = {0, 1, 0, -1};
    private final static int[] d2x = {-2, 0, 2, 0}, d2y = {0, 2, 0, -2};
    private final static int[] dgx = {-1, 1, 1, -1}, dgy = {1, 1, -1, -1};

    private static boolean isKeepingSuccess(Queue<Seat> queue, String[] place) {
        while (!queue.isEmpty()) {
            Seat current = queue.poll();

            for (int i = 0; i < 4; i++) {
                // 위, 아래, 왼쪽, 오른쪽 확인
                int nx = current.x + d1x[i];
                int ny = current.y + d1y[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5
                        && place[nx].charAt(ny) == 'P') {
                    return false;
                }

                // 위, 아래, 왼쪽, 오른쪽 두 칸씩 확인
                int n2x = current.x + d2x[i];
                int n2y = current.y + d2y[i];

                if (n2x >= 0 && n2x < 5 && n2y >= 0 && n2y < 5
                        && place[nx].charAt(ny) == 'O' && place[n2x].charAt(n2y) == 'P') {
                    return false;
                }

                // 대각선 확인
                int ngx = current.x + dgx[i];
                int ngy = current.y + dgy[i];

                if (ngx >= 0 && ngx < 5 && ngy >= 0 && ngy < 5
                        && place[ngx].charAt(ngy) == 'P'
                        && (place[ngx].charAt(current.y) == 'O' || place[current.x].charAt(current.y) == 'O')) {
                    return false;
                }
            }
        }

        return true;
    }
}
