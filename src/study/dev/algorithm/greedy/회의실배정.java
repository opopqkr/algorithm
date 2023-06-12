package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 회의실배정 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(in.nextInt(), in.nextInt()));
        }

        System.out.println(solution(meetings));
    }

    private static int solution(ArrayList<Meeting> meetings) {
        Collections.sort(meetings);
        int answer = 0, beforeEndTime = 0;

        for (Meeting meeting : meetings) {
            if (meeting.startTime >= beforeEndTime) {
                answer++;
                beforeEndTime = meeting.endTime;
            }
        }

        return answer;
    }

    private static class Meeting implements Comparable<Meeting> {
        int startTime, endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.endTime == o.endTime) {
                return this.startTime - o.startTime;
            } else {
                return this.endTime - o.endTime;
            }
        }
    }
}
