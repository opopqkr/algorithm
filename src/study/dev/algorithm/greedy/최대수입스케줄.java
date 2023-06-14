package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대수입스케줄 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        ArrayList<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int d = in.nextInt();
            lectures.add(new Lecture(m, d));
        }

        System.out.println(solution(lectures));
    }

    private static int solution(ArrayList<Lecture> lectures) {
        Collections.sort(lectures);
        int answer = 0, maxDay = lectures.get(0).date;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for (; j < lectures.size(); j++) {
                if (lectures.get(j).date < i) {
                    break;
                } else {
                    priorityQueue.offer(lectures.get(j).money);
                }
            }
            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll();
            }
        }

        return answer;
    }

    private static class Lecture implements Comparable<Lecture> {
        int money, date;

        public Lecture(int money, int date) {
            this.money = money;
            this.date = date;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.date - this.date;
        }
    }
}
