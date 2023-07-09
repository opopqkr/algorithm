package study.dev.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 가장높은탑쌓기 {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new int[n];

        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bricks.add(new Brick(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        System.out.println(solution2(bricks));
    }

    /**
     * 내 풀이
     *
     * @param bricks
     * @return
     */
    private static int solution1(ArrayList<Brick> bricks) {
        Collections.sort(bricks);

        for (int i = 0; i < bricks.size(); i++) {
            int height = bricks.get(i).height;
            dp[i] = height;
            for (int j = 0; j < i; j++) {
                if (bricks.get(j).weight > bricks.get(i).weight) {
                    dp[i] = Math.max(dp[i], dp[j] + height);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 강의 풀이
     *
     * @param bricks
     * @return
     */
    private static int solution2(ArrayList<Brick> bricks) {
        Collections.sort(bricks);

        int answer = 0;
        dp[0] = bricks.get(0).height;
        answer = dp[0];

        for (int i = 1; i < bricks.size(); i++) {
            int heightMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(j).weight > bricks.get(i).weight && dp[j] > heightMax) {
                    heightMax = dp[j];
                }
            }
            dp[i] = heightMax + bricks.get(i).height;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    private static class Brick implements Comparable<Brick> {

        int underside, height, weight;

        public Brick(int underside, int height, int weight) {
            this.underside = underside;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            if (o.underside == this.underside) {
                return o.weight - this.weight;
            }
            return o.underside - this.underside;
        }
    }
}
