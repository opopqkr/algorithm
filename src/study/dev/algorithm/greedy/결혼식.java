package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 결혼식 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<Attend> attends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            attends.add(new Attend('s', in.nextInt()));
            attends.add(new Attend('e', in.nextInt()));
        }

        System.out.println(solution(attends));
    }

    private static int solution(ArrayList<Attend> attends) {
        Collections.sort(attends);
        int count = 0, answer = 0;

        for (Attend attend : attends) {
            if (attend.status == 's') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }

    private static class Attend implements Comparable<Attend> {
        char status;
        int time;

        public Attend(char status, int time) {
            this.status = status;
            this.time = time;
        }

        @Override
        public int compareTo(Attend o) {
            if (this.time == o.time) {
                return this.status - o.status;
            } else {
                return this.time - o.time;
            }
        }
    }
}
