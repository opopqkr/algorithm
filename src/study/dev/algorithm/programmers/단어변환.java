package study.dev.algorithm.programmers;

public class 단어변환 {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        boolean[] check = new boolean[words.length];
        dfs(0, check, begin, target, words);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static int answer;

    private static void dfs(int count, boolean[] check, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!check[i] && convertible(begin, words[i])) {
                check[i] = true;
                dfs(count + 1, check, words[i], target, words);
                check[i] = false;
            }
        }
    }

    private static boolean convertible(String word, String target) {
        int count = 0;

        for (int i = 0; i < target.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
