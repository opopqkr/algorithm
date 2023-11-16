package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 압축 {

    public static void main(String[] args) {
        Arrays.stream(solution("KAKAO")).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("TOBEORNOTTOBEORTOBEORNOT")).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution("ABABABABABABABAB")).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();

        int dictIndex = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            dict.put(String.valueOf((char) i), dictIndex++);
        }

        int index = 0;
        while (index < msg.length()) {
            String newWord = "";

            while (index < msg.length()) {
                if (!dict.containsKey(newWord + msg.charAt(index))) {
                    dict.put(newWord + msg.charAt(index), dictIndex++);
                    break;
                } else {
                    newWord += msg.charAt(index);
                }
                index++;
            }

            answer.add(dict.get(newWord));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
