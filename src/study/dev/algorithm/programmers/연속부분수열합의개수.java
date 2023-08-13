package study.dev.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
    }

    public static int solution(int[] elements) {
        int size = 1;
        Set<Integer> set = new HashSet<>();

        while (size <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = 0; j < size; j++) {
                    int idx = i + j;
                    // 연속 수열이기 때문에 index 가 배열을 넘어가는 case 발생.
                    // ArrayIndexOutOfBoundException 이 발생하지 않도록 index 를 순환하도록 조정.
                    if (idx >= elements.length) {
                        idx = i - elements.length + j;
                    }
                    // size 만큼 sum 에 elements 를 누적하여 더해줌.
                    sum += elements[idx];
                }
                set.add(sum);
            }
            size++;
        }

        return set.size();
    }
}
