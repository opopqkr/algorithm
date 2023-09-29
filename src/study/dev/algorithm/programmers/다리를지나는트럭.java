package study.dev.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();

        int totalWeight = 0;
        for (int truck : truck_weights) {
            totalWeight += truck;

            while (true) {
                if (bridge.size() < bridge_length) {
                    answer++;
                    if (totalWeight > weight) {
                        bridge.offer(0);
                    } else {
                        bridge.offer(truck);
                        break;
                    }
                } else {
                    totalWeight -= bridge.poll();
                }
            }
        }

        // 걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return answer + bridge_length;
    }
}
