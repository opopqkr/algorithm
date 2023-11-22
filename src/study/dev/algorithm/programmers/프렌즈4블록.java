package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 프렌즈4블록 {

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    private static char[][] map;

    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            if (findFourBlock()) {
                dropBlock();
            } else {
                break;
            }
        }

        return countRemovedBlocks();
    }

    private static boolean findFourBlock() {
        boolean fourBlockExists = false;

        // map deep copy
        char[][] temp = Arrays.stream(map).map(char[]::clone).toArray(char[][]::new);

        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[i].length - 1; j++) {
                if (map[i][j] != '-' && is2x2(i, j)) {
                    removeBlock(temp, i, j);
                    fourBlockExists = true;
                }
            }
        }

        if (fourBlockExists) map = temp;
        return fourBlockExists;
    }

    private static boolean is2x2(int x, int y) {
        if (x + 1 < map.length && y + 1 < map[x][y]) {
            char targetBlock = map[x][y];
            return targetBlock == map[x][y + 1] &&
                    targetBlock == map[x + 1][y] &&
                    targetBlock == map[x + 1][y + 1];
        }
        return false;
    }

    private static void removeBlock(char[][] temp, int x, int y) {
        temp[x][y] = '-';
        temp[x][y + 1] = '-';
        temp[x + 1][y] = '-';
        temp[x + 1][y + 1] = '-';
    }

    private static void dropBlock() {
        for (int i = map.length - 1; i > 0; i--) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '-') {
                    for (int index = i - 1; index >= 0; index--) {
                        if (map[index][j] != '-') {
                            map[i][j] = map[index][j];
                            map[index][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static int countRemovedBlocks() {
        int count = 0;
        for (char[] blocks : map) {
            for (char block : blocks) {
                if (block == '-') count++;
            }
        }
        return count;
    }
}
