package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {

    /**
     * INPUT
     * <p>
     * 10
     * 1 5 2 1 4 3 4 5 2 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrays = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arrays[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arrays));
    }

    private static int solution(int N, int[] arrays) {
        // LIS(Longest Increasing Sequence) & LDS(Longest Decreasing Sequence) 값 저장.
        int[] lis = new int[N + 1], lds = new int[N + 1];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // LIS
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arrays[i] > arrays[j]) {
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
        }

        // LDS, LIS 반대로 뒤에서 부터 값을 구함.
        for (int i = N; i > 0; i--) {
            for (int j = N; j >= i; j--) {
                if (arrays[i] > arrays[j]) {
                    lds[i] = Math.max(lds[j] + 1, lds[i]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            // 각 index 별로 LIS, LDS 합을 구한 후 - 1 (각 LIS, LDS 값들이 1부터 카운트 되기 때문에 중복 카운트 값 1 제거)
            answer = Math.max(answer, (lis[i] + lds[i]) - 1);
        }

        return answer;
    }
}
