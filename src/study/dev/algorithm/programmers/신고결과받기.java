package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class 신고결과받기 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2)).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                2)).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> reportInfo = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();

        // 신고 정보 세팅
        for (String reportDetail : report) {
            String reporter = reportDetail.split(" ")[0];
            String badUser = reportDetail.split(" ")[1];

            HashSet<String> set = reportInfo.getOrDefault(reporter, new HashSet<>());
            set.add(badUser);
            reportInfo.put(reporter, set);
        }

        // 신고 카운트 세팅
        reportInfo.values().forEach(badUsers ->
                badUsers.forEach(badUser ->
                        reportCount.put(badUser, reportCount.getOrDefault(badUser, 0) + 1)
                )
        );

        // k 이상 건에 대해 정지할 user list 세팅
        List<String> stopUser = reportCount.keySet()
                .stream().filter(s -> reportCount.get(s) >= k).collect(Collectors.toList());

        for (int i = 0; i < id_list.length; i++) {
            for (String badUser : reportInfo.getOrDefault(id_list[i], new HashSet<>())) {
                if (stopUser.contains(badUser)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
