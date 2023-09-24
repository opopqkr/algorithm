package study.dev.algorithm.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 기능개발 {

    public static void main(String[] args) {
        Arrays.stream(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = Arrays.stream(progresses).boxed().collect(Collectors.toCollection(LinkedList::new));

        int index = 0;
        while (!queue.isEmpty()) {
            int count = 1;
            int remainTime = calculateRemainTime(queue.poll(), speeds[index++]);

            while (!queue.isEmpty() && calculateRemainTime(queue.peek(), speeds[index]) <= remainTime) {
                index++;
                count++;
                queue.poll();
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int calculateRemainTime(int progress, int speed) {
        return (int) Math.ceil(((double) 100 - progress) / speed);
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int daysRemaining = (int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]);
            queue.offer(daysRemaining);
        }

        while (!queue.isEmpty()) {
            int deployDay = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= deployDay) {
                count++;
                queue.poll();
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
