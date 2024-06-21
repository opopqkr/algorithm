package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 강의실 {

    /**
     * INPUT
     * <p>
     * 8
     * 6 15 21
     * 7 20 25
     * 1 3 8
     * 3 2 14
     * 8 6 27
     * 2 7 13
     * 4 12 18
     * 5 6 20
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lectures[i] = new Lecture(temp[0], temp[1], temp[2]);
        }

        System.out.println(solution());
    }

    private static int solution() {
        // 시작시간으로 정렬
        Arrays.sort(lectures, Comparator.comparingInt(o -> o.start));

        PriorityQueue<Lecture> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // queue 의 강의 종료시간이 현재 강의의 시작시간보다 작을 경우 poll
            if (!priorityQueue.isEmpty() && priorityQueue.peek().end <= lectures[i].start) {
                priorityQueue.poll();
            }

            priorityQueue.offer(lectures[i]);
        }

        return priorityQueue.size();
    }

    private static int N;

    private static Lecture[] lectures;

    private static class Lecture implements Comparable<Lecture> {
        int number, start, end;

        public Lecture(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.end - o.end;
        }
    }
}
