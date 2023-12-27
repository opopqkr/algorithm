package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

    /**
     * INPUT
     * <p>
     * 2 4
     * CAAB
     * ADCB
     * <p>
     * 3 6
     * HFDFFB
     * AJHGDH
     * DGAGEH
     * <p>
     * 5 5
     * IEFCJ
     * FHFKC
     * FFALF
     * HFGCF
     * HMCHH
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp[j];
            }
        }

        System.out.println(solution(board));
    }

    private static int solution(char[][] board) {
        answer = 1;

        boolean[] checkAlphabet = new boolean[26];
        checkAlphabet[board[0][0] - 65] = true;

        dfs(0, 0, 1, checkAlphabet, board);
        return answer;
    }

    private static int answer;

    private final static int[] dx = {-1, 0, 1, 0};

    private final static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y, int count, boolean[] checkAlphabet, char[][] board) {
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;

            if (!checkAlphabet[board[nx][ny] - 65]) {
                checkAlphabet[board[nx][ny] - 65] = true;
                dfs(nx, ny, count + 1, checkAlphabet, board);
                checkAlphabet[board[nx][ny] - 65] = false;
            }
        }
    }
}
