package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 하노이의탑 {

    public static void main(String[] args) {
        Arrays.stream(solution(2)).forEach(arr -> {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.print("\t");
        });
        System.out.println();

        Arrays.stream(solution(3)).forEach(arr -> {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.print("\t");
        });
        System.out.println();
    }

    private static int[][] solution(int n) {
        ArrayList<int[]> list = new ArrayList<>();
        recursive(list, n, 1, 2, 3);
        return list.toArray(int[][]::new);
    }

    private static void recursive(ArrayList<int[]> list, int n, int from, int via, int to) {
        if (n == 0)
            return;

        recursive(list, n - 1, from, to, via); // 출발지에 있는 n - 1개의 원판을 경유지로 옮김
        list.add(new int[]{from, to}); // 출발지에 있는 마지막 한개의 원판을 도착지로 옮김
        recursive(list, n - 1, via, from, to); // 경유지에 있는 n - 1개의 원판을 도착지로 옮김
    }
}
