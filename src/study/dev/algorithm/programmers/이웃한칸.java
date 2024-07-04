package study.dev.algorithm.programmers;

public class 이웃한칸 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1));

        System.out.println(solution(new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}}, 0, 1));
    }

    private static int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            if (isRange(nx, ny, board.length) && board[h][w].equals(board[nx][ny]))
                answer++;
        }

        return answer;
    }

    private static boolean isRange(int x, int y, int length) {
        return (x >= 0 && x < length && y >= 0 && y < length);
    }
}
