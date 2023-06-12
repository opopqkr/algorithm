package study.dev.algorithm.배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 큰수출력하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n + 1];

        // 내 풀이
        // 첫 번째에 0을 임의로 넣음.
        for (int i = 1; i <= n; i++) {
            inputs[i] = in.nextInt();
        }
        System.out.println(solution1(inputs));

        int[] inputs2 = new int[n];
        for (int i = 0; i < n; i++) {
            inputs2[i] = in.nextInt();
        }
        for (int x : solution2(n, inputs2)) {
            System.out.print(x + " ");
        }
    }

    /**
     * 내 풀이
     *
     * @param inputs
     * @return
     */
    private static String solution1(int[] inputs) {
        String answer = "";

        for (int i = 0; i < inputs.length - 1; i++) {
            if (inputs[i] < inputs[i + 1]) {
                answer = answer + inputs[i + 1] + " ";
            }
        }
        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param inputs
     * @return
     */
    private static List<Integer> solution2(int n, int[] inputs) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 첫 번째 숫자는 무조건 출력됨으로 add().
        answer.add(inputs[0]);
        for (int i = 1; i < n; i++) {
            if (inputs[i] > inputs[i - 1]) {
                answer.add(inputs[i]);
            }
        }
        return answer;
    }
}
