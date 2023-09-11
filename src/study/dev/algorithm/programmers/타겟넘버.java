package study.dev.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        // int answer = dfs(0, 0, numbers, target);
        int answer = bfs(numbers, target);
        return answer;
    }

    /**
     * dfs 활용
     *
     * @param index
     * @param sum
     * @param numbers
     * @param target
     * @return
     */
    public static int dfs(int index, int sum, int[] numbers, int target) {
        if (numbers.length == index) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += dfs(index + 1, sum + numbers[index], numbers, target);
        count += dfs(index + 1, sum - numbers[index], numbers, target);

        return count;
    }

    /**
     * bfs 활용
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int bfs(int[] numbers, int target) {
        class NumberInfo {
            int number, index;

            public NumberInfo(int number, int index) {
                this.number = number;
                this.index = index;
            }
        }

        Queue<NumberInfo> queue = new LinkedList<>();
        queue.offer(new NumberInfo(numbers[0], 0));
        queue.offer(new NumberInfo(-numbers[0], 0));

        int count = 0;

        while (!queue.isEmpty()) {
            NumberInfo numberInfo = queue.poll();
            int currentNumber = numberInfo.number;
            int currentIndex = numberInfo.index;

            if (numbers.length - 1 == currentIndex) {
                if (target == currentNumber) {
                    count++;
                }
                continue;
            }

            int nextIndex = currentIndex + 1;
            int sum1 = currentNumber + numbers[nextIndex];
            int sum2 = currentNumber - numbers[nextIndex];

            queue.offer(new NumberInfo(sum1, nextIndex));
            queue.offer(new NumberInfo(sum2, nextIndex));
        }

        return count;
    }
}
