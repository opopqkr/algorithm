package study.dev.algorithm.programmers;

public class 양궁대회 {

    public static void main(String[] args) {
//        for (int i : solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})) {
//            System.out.print(i + " ");
//        }
//        for (int i : solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})) {
//            System.out.print(i + " ");
//        }
//        for (int i : solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})) {
//            System.out.print(i + " ");
//        }
        for (int i : solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})) {
            System.out.print(i + " ");
        }
    }

    private static int[] answer = {-1};
    private static int[] lionScores;
    private static int maxScore = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info) {
        lionScores = new int[info.length];
        dfs(n, info, 0);
        return answer;
    }

    private static void dfs(int n, int[] info, int count) {
        if (n == count) {
            int lionTotalScore = calculation(info);
            if (maxScore <= lionTotalScore && -1 < lionTotalScore) {
                maxScore = lionTotalScore;
                answer = lionScores.clone();
            }
            return;
        }

        for (int i = 0; i < info.length && lionScores[i] <= info[i]; i++) {
            lionScores[i]++;
            dfs(n, info, count + 1);
            lionScores[i]--;
        }
    }

    private static int calculation(int[] info) {
        int apeachScore = 0, lionScore = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0 || lionScores[i] != 0) {
                if (info[i] >= lionScores[i]) {
                    apeachScore += 10 - i;
                } else {
                    lionScore += 10 - i;
                }
            }
        }

        if (apeachScore >= lionScore) {
            return -1;
        }
        return lionScore - apeachScore;
    }
}
