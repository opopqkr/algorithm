package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 시소짝꿍 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 180, 360, 100, 270}));
    }

    public static long solution(int[] weights) {
        long answer = 0;

        List<Integer> list = Arrays.stream(weights).boxed().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int weight : list) {
            double weight1 = (weight * 1.0);
            double weight2 = (weight * 2.0) / 1.0;
            double weight3 = (weight * 3.0) / 2.0;
            double weight4 = (weight * 4.0) / 3.0;

            if (map.containsKey(weight1)) answer += map.get(weight1);
            if (map.containsKey(weight2)) answer += map.get(weight2);
            if (map.containsKey(weight3)) answer += map.get(weight3);
            if (map.containsKey(weight4)) answer += map.get(weight4);

            map.put(weight1, map.getOrDefault(weight1, 0) + 1);
        }

        return answer;
    }
}
