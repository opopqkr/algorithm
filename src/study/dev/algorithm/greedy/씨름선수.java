package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * greedy 란?
 * 현재 시점에서 최선의 선택하는 것
 * 반대는 dynamic 계획법
 */
public class 씨름선수 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<Body> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i, new Body(in.nextInt(), in.nextInt()));
        }

        System.out.println(solution(list));
    }

    private static int solution(ArrayList<Body> list) {
        Collections.sort(list);
        int answer = 0, max = Integer.MIN_VALUE;

        for (Body body : list) {
            if (max < body.weight) {
                max = body.weight;
                answer++;
            }
        }
        return answer;
    }

    private static class Body implements Comparable<Body> {
        int height;
        int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        /**
         * 내림차순
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Body o) {
            if (this.height == o.height) {
                return o.weight - this.weight;
            } else {
                return o.height - this.height;
            }
        }
    }
}
