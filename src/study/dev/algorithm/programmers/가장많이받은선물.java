package study.dev.algorithm.programmers;

import java.util.HashMap;

public class 가장많이받은선물 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));

        System.out.println(solution(new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));

        System.out.println(solution(new String[]{"a", "b", "c"},
                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        HashMap<String, HashMap<String, Integer>> records = new HashMap<>(); // 선물 정보
        HashMap<String, Integer> score = new HashMap<>(); // 선물 지수

        for (String friend : friends) {
            records.put(friend, new HashMap<>());
            score.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            String from = temp[0]; // 선물을 준 사람
            String to = temp[1]; // 선물을 받은 사람

            HashMap<String, Integer> toInfo = records.get(from);
            toInfo.put(to, toInfo.getOrDefault(to, 0) + 1);
            records.put(from, toInfo); // 기록 저장

            score.put(from, score.getOrDefault(from, 0) + 1); // 선물을 준 사람의 지수 + 1
            score.put(to, score.getOrDefault(to, 0) - 1); // 선물을 받은 사람의 지수 - 1
        }

        for (String from : friends) {
            int count = 0;
            for (String to : friends) {
                if (from.equals(to)) continue;

                int fromCount = records.get(from).getOrDefault(to, 0);
                int toCount = records.get(to).getOrDefault(from, 0);

                if (fromCount > toCount) {
                    count++;
                } else if (fromCount == toCount && score.get(from) > score.get(to)) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
