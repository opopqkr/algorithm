package study.dev.algorithm.재귀.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리 {

    private static int answer = Integer.MAX_VALUE;
    private static int[] combination;
    private static ArrayList<Coordinate> house, pizzaHouse;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        house = new ArrayList<>();
        pizzaHouse = new ArrayList<>();

        int n = in.nextInt();
        int m = in.nextInt();
        combination = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                if (temp == 1) {
                    house.add(new Coordinate(i, j));
                }
                if (temp == 2) {
                    pizzaHouse.add(new Coordinate(i, j));
                }
            }
        }

        dfs(m, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int m, int index, int startPoint) {
        if (index == m) {
            int distanceSum = 0;
            for (Coordinate nowHouse : house) {
                int distance = Integer.MAX_VALUE;
                for (int i : combination) {
                    distance = Math.min(distance, Math.abs(nowHouse.x - pizzaHouse.get(i).x)
                            + Math.abs(nowHouse.y - pizzaHouse.get(i).y));
                }
                distanceSum = distanceSum + distance;
            }
            answer = Math.min(answer, distanceSum);
        } else {
            for (int i = startPoint; i < pizzaHouse.size(); i++) {
                combination[index] = i;
                dfs(m, index + 1, i + 1);
            }
        }
    }

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
