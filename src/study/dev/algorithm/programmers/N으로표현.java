package study.dev.algorithm.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N으로표현 {

    /**
     * INPUT
     * <p>
     * 5 12
     * <p>
     * 2 11
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), number = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, number));
    }

    private static int solution(int N, int number) {
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        // 초기화, i개를 이용하여 만들 수 있는 수를 dp에 저장.
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N으로 만들 수 있는 최솟값이 8을 넘어가면 -1을 리턴해야 하기 때문에 i <= 8
        for (int i = 1; i <= 8; i++) {
            // N을 i개 만큼 이어서 만들 수 있는 수
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // i개로 만들 수 있는 수는, j(j < i)개, i-j개의 수들을 각각 사칙연산하여 만들 수 있음.
            for (int j = 1; j < i; j++) {
                HashSet<Integer> numberCount1 = dp.get(j);
                HashSet<Integer> numberCount2 = dp.get(i - j);

                for (int number1 : numberCount1) {
                    for (int number2 : numberCount2) {
                        dp.get(i).add(number1 + number2);
                        dp.get(i).add(number1 - number2);
                        dp.get(i).add(number1 * number2);
                        if (number2 != 0) dp.get(i).add(number1 / number2);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}
