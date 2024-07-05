package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 데이터분석 {

    public static void main(String[] args) {
        Arrays.stream(solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
                        "date", 20300501, "remain"))
                .forEach(data -> {
                    Arrays.stream(data).forEach(row -> System.out.print(row + " "));
                    System.out.println();
                });
    }

    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extCol = decideColNum(ext), sortCol = decideColNum(sort_by);

        return Arrays.stream(data)
                .filter(row -> row[extCol] < val_ext)
                .sorted(Comparator.comparingInt(row -> row[sortCol]))
                .toArray(int[][]::new);
    }

    private static int decideColNum(String standard) {
        return standard.equals("code") ? 0 : standard.equals("date") ? 1 :
                standard.equals("maximum") ? 2 : standard.equals("remain") ? 3 : 0;
    }
}
