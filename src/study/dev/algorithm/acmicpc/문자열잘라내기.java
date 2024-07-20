package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 문자열잘라내기 {

    /**
     * INPUT
     * <p>
     * 2 6
     * dobarz
     * adatak
     * <p>
     * 3 4
     * alfa
     * zeta
     * <p>
     * 4 6
     * mrvica
     * mrvica
     * marica
     * mateja
     */
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = temp[0];
        C = temp[1];

        table = new char[R][C];

        for (int i = 0; i < R; i++) {
            if (C >= 0) System.arraycopy(br.readLine().toCharArray(), 0, table[i], 0, C);
        }

        System.out.println(solution());
    }

    private static int solution() {
        int start = 0, end = R - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (!isDuplicated(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private static boolean isDuplicated(int start) {
        HashSet<String> set = new HashSet<>();

        StringBuilder sb;
        for (int j = 0; j < C; j++) {
            sb = new StringBuilder();
            for (int i = start + 1; i < R; i++)
                sb.append(table[i][j]);

            if (set.contains(sb.toString()))
                return true;
            else
                set.add(sb.toString());
        }

        return false;
    }

    private static int R, C;

    private static char[][] table;

}
