package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 영어끝말잇기 {

    public static void main(String[] args) {
        Arrays.stream(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        ArrayList<String> wordList = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            for (int i = 0; i < n; i++) {
                if (wordList.isEmpty()) {
                    wordList.add(words[index++]);
                    continue;
                }

                if (wordList.contains(words[index])) {
                    answer[0] = i + 1;
                    answer[1] = (index / n) + 1;
                    return answer;
                }

                String before = wordList.get(wordList.size() - 1);
                if (!before.substring(before.length() - 1).equals(words[index].substring(0, 1))) {
                    answer[0] = i + 1;
                    answer[1] = (index / n) + 1;
                    return answer;
                }

                wordList.add(words[index++]);
            }
        }

        return answer;
    }
}
