package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 대충만든자판 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCZD"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[]{"AA"}, new String[]{"B"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int totalCount = 0;

            for (char word : targets[i].toCharArray()) {
                int count = Integer.MAX_VALUE;

                for (String keyboard : keymap) {
                    int temp = keyboard.indexOf(word);
                    if (temp != -1) {
                        count = Math.min(count, temp + 1);
                    }
                }

                if (count == Integer.MAX_VALUE) {
                    totalCount = -1;
                    break;
                } else {
                    totalCount += count;
                }
            }

            answer[i] = totalCount;
        }

        return answer;
    }
}
