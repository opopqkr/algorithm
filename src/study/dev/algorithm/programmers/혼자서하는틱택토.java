package study.dev.algorithm.programmers;

public class 혼자서하는틱택토 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(solution(new String[]{"...", ".X.", "..."}));
        System.out.println(solution(new String[]{"...", "...", "..."}));
    }

    public static int solution(String[] board) {
        int oCount = 0, xCount = 0;

        for (String tickTackTo : board) {
            for (char word : tickTackTo.toCharArray()) {
                if (word == 'O') oCount++;
                else if (word == 'X') xCount++;
            }
        }

        boolean oWin = isWin('O', board), xWin = isWin('X', board);

        // 후공 'X'의 갯수가 더 많거나, 선공 'O'의 갯수가 후공 'X'의 갯수 + 1개 보다 더 많을 경우 잘못된 게임.
        if (oCount < xCount || oCount > xCount + 1) {
            return 0;
        } else {
            if (oWin && xWin) { // 둘 다 이겼다고 나올 경우 잘못된 게임.
                return 0;
            } else if (oWin && oCount != xCount + 1) { // 선공 'O'가 이겼는데 'O'의 갯수가 'X'의 갯수보다 한개만 더 많지 않을 경우 잘못된 게임.
                return 0;
            } else if (xWin && oCount != xCount) { // 후공 'X'가 이겼는데 'O'의 갯수와 'X'의 갯수가 같지 않을 경우 잘못된 게임.
                return 0;
            }
        }

        return 1;
    }

    private static boolean isWin(char word, String[] board) {
        for (int i = 0; i < board.length; i++) {
            // 가로, 세로 확인.
            if (board[i].charAt(0) == word && board[i].charAt(1) == word && board[i].charAt(2) == word) return true;
            if (board[0].charAt(i) == word && board[1].charAt(i) == word && board[2].charAt(i) == word) return true;
        }

        // 대각선 확인.
        if (board[0].charAt(0) == word && board[1].charAt(1) == word && board[2].charAt(2) == word) return true;
        if (board[0].charAt(2) == word && board[1].charAt(1) == word && board[2].charAt(0) == word) return true;

        return false;
    }
}
