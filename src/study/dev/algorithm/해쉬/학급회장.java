package study.dev.algorithm.해쉬;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String input = in.next();

        System.out.println(solution1(n, input));
        System.out.println(solution2(n, input));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param input
     * @return
     */
    private static char solution1(int n, String input) {
        Map<Character, Integer> answerMap = new HashMap<>();
        char[] charArray = input.toCharArray();

        for (Character word : charArray) {
            if (answerMap.containsKey(word)) {
                int val = answerMap.get(word);
                val++;
                answerMap.put(word, val);
            } else {
                answerMap.put(word, 1);
            }
        }

        int maxVal = 0;
        char answer = ' ';

        for (char word : answerMap.keySet()) {
            if (maxVal < answerMap.get(word)) {
                answer = word;
                maxVal = answerMap.get(word);
            }
        }

        return answer;
    }

    /**
     * 강의 풀이
     * <p>
     * map.getOrDefault(key, defaultValue) : map 의 key 에 해당하는 값이 있으면 get 하고 없으면 default 세팅
     *
     * @param n
     * @param input
     * @return
     */
    private static char solution2(int n, String input) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char word : input.toCharArray()) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
