package study.dev.algorithm.programmers;

/**
 * runtime error
 */
public class 큰수만들기DFS {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    private static String answer;

    public static String solution(String number, int k) {
        answer = "0";

        dfs("", 0, number, k);
        return answer;
    }

    private static void dfs(String makeNumber, int index, String number, int k) {
        if (makeNumber.length() == number.length() - k) {
            answer = String.valueOf(Math.max(Integer.parseInt(answer), Integer.parseInt(makeNumber)));
        } else {
            for (int i = index; i < number.length(); i++) {
                dfs(makeNumber + number.charAt(i), i + 1, number, k);
            }
        }
    }
}
