package study.dev.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    private static final int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
    private static final char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int score = choices[i];

            char type;
            if (score < 4) {
                type = survey[i].charAt(0);
            } else {
                type = survey[i].charAt(1);
            }

            map.put(type, map.getOrDefault(type, 0) + scores[score]);
        }

        for (char[] type : types) {
            int type1Score = map.getOrDefault(type[0], 0);
            int type2Score = map.getOrDefault(type[1], 0);

            if (type1Score >= type2Score) {
                answer.append(type[0]);
            } else {
                answer.append(type[1]);
            }
        }

        return answer.toString();
    }
}
