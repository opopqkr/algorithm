package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        Arrays.stream(info).forEach(detailInfo -> dfs(0, "", detailInfo.split(" "), map));

        map.keySet().forEach(key -> Collections.sort(map.get(key)));

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");

            String condition = query[i].split(" ")[0];
            int score = Integer.parseInt(query[i].split(" ")[1]);

            answer[i] = map.containsKey(condition) ? binarySearch(map.get(condition), score) : 0;
        }

        return answer;
    }

    private static int binarySearch(ArrayList<Integer> userScores, int score) {
        int left = 0, right = userScores.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (userScores.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return userScores.size() - left;
    }

    private static void dfs(int depth, String key, String[] detailInfo, HashMap<String, ArrayList<Integer>> map) {
        if (depth == 4) {
            ArrayList<Integer> scores = map.getOrDefault(key, new ArrayList<>());
            scores.add(Integer.parseInt(detailInfo[4]));
            map.put(key, scores);
            return;
        }

        dfs(depth + 1, key + detailInfo[depth], detailInfo, map);
        dfs(depth + 1, key + "-", detailInfo, map);
    }
}
