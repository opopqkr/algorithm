package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 개인정보수집유효기간 {

    public static void main(String[] args) {
        Arrays.stream(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 반례
        Arrays.stream(solution("2020.05.15", new String[]{"A 1"}, new String[]{"2001.01.10 A", "2001.01.10 A"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("2020.01.02", new String[]{"A 1", "B 11"}, new String[]{"2019.12.01 A", "2020.01.01 B"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("2020.01.02", new String[]{"A 1"}, new String[]{"2020.01.02 A"}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> termsInfoMap = new HashMap<>();
        for (String termsInfo : terms) {
            String name = termsInfo.split(" ")[0];
            int period = Integer.parseInt(termsInfo.split(" ")[1]) * 28;

            termsInfoMap.put(name, period);
        }

        int calToday = calculateDate(today);
        for (int i = 0; i < privacies.length; i++) {
            String name = privacies[i].split(" ")[1];
            String agreeDate = privacies[i].split(" ")[0];

            int calExpirationDate = calculateDate(agreeDate) + termsInfoMap.get(name) - 1;
            if (calToday > calExpirationDate) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int calculateDate(String date) {
        String[] temp = date.split("\\.");
        int year = Integer.parseInt(temp[0]) * 336;
        int month = Integer.parseInt(temp[1]) * 28;
        int day = Integer.parseInt(temp[2]);

        return year + month + day;
    }
}
