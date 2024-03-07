package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를말해요 {

    /**
     * INPUT
     * <p>
     * 7
     * 1
     * 5
     * 2
     * 10
     * -99
     * 7
     * 5
     * <p>
     * 반례
     * 6
     * 10
     * 8
     * 5
     * 3
     * 5
     * -1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 작은 값들을 저장하여 가장 큰 값을 가져옴.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 큰 값들을 저장하여 가장 작은 값을 가져옴.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // System.out.println() 바로 출력 시, 시간초과.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            // 각각의 힙의 크기를 같게 함으로 중간 값을 도출해 낼 수 있음.
            if (maxHeap.size() == minHeap.size()) maxHeap.offer(number);
            else minHeap.offer(number);

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.offer(maxHeap.peek());
                    maxHeap.offer(minHeap.poll());
                    maxHeap.poll();
                }
            }

            // maxHeap.peek() 값이 항상 중간 값이 됨.
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
