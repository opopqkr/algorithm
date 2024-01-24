package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href="https://www.acmicpc.net/problem/12865">평범한 배낭 12865번</a>
 * 냅색(Knapsack) 알고리즘
 */
public class 평범한배낭 {

    /**
     * INPUT
     * <p>
     * 4 7
     * 6 13
     * 4 8
     * 3 6
     * 5 12
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(N, K, items));
    }

    private static int solution(int N, int K, Item[] items) {
        // 최대 가치 저장.
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            // j는 무게
            for (int j = 1; j <= K; j++) {
                if (items[i].weight > j) { // 현재 넣으려는 물건이 j무게 보다 크면 가방에 넣을 수 없기 때문에 이전까지의 최대 가치 값 저장.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 현재 넣으려는 물건이 j 무게 보다 작으면, 이전까지의 최대 가치 값 or
                    //                                   j무게 - 현재 넣으려는 물건의 무게를 뺀 가치 값 + 현재 물건 가치 중 Maximum.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].weight] + items[i].value);
                }
            }
        }

        return dp[N][K];
    }

    private static class Item {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
