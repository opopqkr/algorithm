package study.dev.algorithm.programmers;

public class 모음사전 {

    public static void main(String[] args) {
        // System.out.println(solution("AAAAE"));
        // System.out.println(solution("AAAE"));
        // System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    private static int answer = 0;
    private static boolean stop = false;

    public static int solution(String word) {
        dfs(word, "", new char[]{'A', 'E', 'I', 'O', 'U'});
        return answer;
    }

    private static void dfs(String word, String target, char[] vowel) {
        if (target.length() > vowel.length) {
            return;
        }

        if (word.equals(target)) {
            stop = true;
        }

        if (stop) {
            return;
        }

        answer++;
        for (int i = 0; i < vowel.length; i++) {
            dfs(word, target + vowel[i], vowel);
        }
    }
}
