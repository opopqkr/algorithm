package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 보석쇼핑 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"XYZ", "XYZ", "XYZ"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 반례
        Arrays.stream(solution(new String[]{"DIA", "EM", "EM", "RUB", "DIA"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[]{0, 0};

        int totalSize = Arrays.stream(gems).collect(Collectors.toSet()).size();
        int minLength = Integer.MAX_VALUE;

        HashMap<String, Integer> map = new HashMap<>();

        int start = 0;
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            // 끝까지 비교 하여 가장 짧은 길이로 해야 함
            if (map.size() == totalSize && minLength > (end - start)) {
                answer[0] = start + 1;
                answer[1] = end + 1;
                minLength = end - start;
            }
        }

        return answer;
    }
}
