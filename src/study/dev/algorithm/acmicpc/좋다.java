package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {

    /**
     * INPUT
     * <p>
     * 10
     * 1 2 3 4 5 6 7 8 9 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static int solution() {
        Arrays.sort(inputs);
        int answer = 0;

        for (int i = 0; i < N; i++) {
            // left = i + 1 or right = i - 1 설정 시 틀림.
            // 음수가 존재하기 때문에 inputs[i]보다 작은 수 혹은 큰 수에 대한 합을 고려해야 함.
            int left = 0, right = N - 1;

            while (true) {
                if (left == i) left++;
                if (right == i) right--;

                if (left >= right) break;

                if (inputs[left] + inputs[right] < inputs[i]) {
                    left++;
                } else if (inputs[left] + inputs[right] > inputs[i]) {
                    right--;
                } else {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    private static int N;

    private static int[] inputs;
}
