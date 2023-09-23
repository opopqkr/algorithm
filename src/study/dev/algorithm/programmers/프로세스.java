package study.dev.algorithm.programmers;


import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            int firstPriority = findPriority(queue);

            Process currentProcess = queue.poll();
            if (currentProcess.priority == firstPriority) {
                answer++;
                if (currentProcess.index == location) {
                    return answer;
                }
            } else {
                queue.offer(currentProcess);
            }
        }

        return answer;
    }

    private static int findPriority(Queue<Process> queue) {
        int priority = Integer.MIN_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            Process process = queue.poll();
            priority = Math.max(process.priority, priority);
            queue.offer(process);
        }
        return priority;
    }

    private static class Process {
        int priority, index;

        public Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}
