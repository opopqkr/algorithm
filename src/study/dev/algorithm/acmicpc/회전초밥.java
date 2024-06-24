package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 회전초밥 {

    /**
     * INPUT
     * <p>
     * 8 30 4 30
     * 7
     * 9
     * 7
     * 30
     * 2
     * 7
     * 9
     * 25
     * <p>
     * 8 50 4 7
     * 2
     * 7
     * 9
     * 25
     * 7
     * 9
     * 7
     * 30
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = temp[0]; // 접시 수
        d = temp[1]; // 초밥 가짓 수
        k = temp[2]; // 연속해서 먹는 접시의 수
        c = temp[3]; // 쿠폰번호

        belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 1;

        // 회전을 하기 때문에 N * 2
        for (int i = 0; i <= (N * 2) - k; i++) {
            boolean[] isEats = new boolean[d + 1]; // 먹은 초밥 종류
            isEats[c] = true; // 쿠폰에 나온 것은 이미 먹었다고 가정
            int count = 1; // 쿠폰에 나온 것은 이미 먹었다고 가정하여 갯수 1로 초기화

            for (int j = i; j < i + k; j++) {
                if (!isEats[belt[j % N]]) { // IndexOutOf 방지를 위해 j % N (즉, 회전을 하기 위함)
                    isEats[belt[j % N]] = true;
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private static int N, d, k, c;

    private static int[] belt;

}
