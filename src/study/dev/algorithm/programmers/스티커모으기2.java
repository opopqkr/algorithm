package study.dev.algorithm.programmers;

public class 스티커모으기2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
        System.out.println(solution(new int[]{4, 3, 2, 9, 4})); // 반례
    }

    private static int solution(int[] sticker) {
        int answer = 0, len = sticker.length;

        if (len == 1)
            return sticker[0];

        int[] dp = new int[len];

        dp[0] = sticker[0];
        dp[1] = dp[0];
        for (int i = 2; i < len - 1; i++) { // 첫 번째 스티커부터 때는 경우 마지막은 사용하지 못함, 원형으로 연결되어 있기 때문
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        answer = Math.max(answer, dp[len - 2]);

        dp[0] = 0; // 두 번째 스티커부터 때는 경우는 첫 번째 스티커를 사용하지 못함, 마지막은 사용 가능
        dp[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        answer = Math.max(answer, dp[len - 1]);
        return answer;
    }
}
