package study.dev.algorithm.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class 치킨배달 {

    public static void main(String[] args) {
        /*
        5 3
        0 0 1 0 0
        0 0 2 0 1
        0 1 2 0 0
        0 0 1 0 0
        0 0 0 0 2
        */
        System.out.println(solution());
    }

    private static int answer;
    private static ArrayList<Coordinate> chickens, homes;

    public static int solution() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        answer = Integer.MAX_VALUE;
        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                if (temp == 1) homes.add(new Coordinate(i, j));
                if (temp == 2) chickens.add(new Coordinate(i, j));
            }
        }

        dfs(0, 0, new boolean[chickens.size()], new ArrayList<>(), m);

        return answer;
    }

    private static void dfs(int depth, int index, boolean[] check, ArrayList<Coordinate> candidates, int m) {
        if (depth == m) {
            answer = Math.min(answer, calcDistance(candidates));
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                candidates.add(chickens.get(i));
                dfs(depth + 1, i + 1, check, candidates, m);
                candidates.remove(chickens.get(i));
                check[i] = false;
            }
        }
    }

    private static int calcDistance(ArrayList<Coordinate> candidates) {
        int totalDistance = 0;

        for (Coordinate home : homes) {
            int distance = Integer.MAX_VALUE;
            for (Coordinate candidate : candidates) {
                // 집과 치킨 집의 최소 거리
                distance = Math.min(Math.abs(home.x - candidate.x) + Math.abs(home.y - candidate.y), distance);
            }
            totalDistance += distance;
        }

        return totalDistance;
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
