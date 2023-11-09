package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (String info : operations) {
            String calc = info.split(" ")[0];
            int n = Integer.parseInt(info.split(" ")[1]);

            if (calc.equals("I")) {
                priorityQueue.offer(n);
            } else {
                if (!priorityQueue.isEmpty()) {
                    if (n == 1) {
                        int max = priorityQueue.stream().max(Integer::compareTo).orElse(0);
                        priorityQueue.remove(max);
                    } else {
                        priorityQueue.poll();
                    }
                }
            }
        }

        answer[0] = priorityQueue.stream().max(Integer::compareTo).orElse(0);
        answer[1] = priorityQueue.stream().min(Integer::compareTo).orElse(0);
        return answer;
    }
}
