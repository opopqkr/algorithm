package study.dev.algorithm.programmers;

public class n진수게임 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int number = 0;
        int index = 0;
        StringBuilder play = new StringBuilder();
        while (t > 0) {
            for (int turn = 1; turn <= m; turn++) {
                play.append(Integer.toString(number++, n)); // n 진수 기록
                if (turn == p) {
                    answer.append(play.charAt(index));
                    t--;
                }
                index++;
            }
        }

        return answer.toString().toUpperCase();
    }
}
