package study.dev.algorithm.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
        }

        System.out.println(solution1(n, m, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param m
     * @param inputs
     * @return
     */
    private static int solution1(int n, int m, int[] inputs) {
        int answer = 0;

        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < inputs.length; i++) {
            queue.offer(new Person(i, inputs[i]));
        }

        while (!queue.isEmpty()) {
            Person targetPatient = queue.poll();
            for (Person waitPatient : queue) {
                if (targetPatient.getPriority() < waitPatient.getPriority()) {
                    queue.offer(targetPatient);
                    targetPatient = null;
                    break;
                }
            }
            if (targetPatient != null) {
                answer++;
                if (targetPatient.getIndex() == m) {
                    return answer;
                }
            }
        }
        return answer;
    }
}

class Person {
    private final int index;
    private final int priority;

    public Person(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}