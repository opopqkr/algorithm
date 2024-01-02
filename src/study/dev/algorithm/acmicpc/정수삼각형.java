package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {

    /**
     * INPUT
     * <p>
     * 5
     * 7
     * 3 8
     * 8 1
     * 2 7 4 4
     * 4 5 2 6 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 1;
            while (st.hasMoreElements()) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        System.out.println(solution(triangle));
    }

    private static int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle.length; j++) {
                triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
                answer = Math.max(triangle[i][j], answer);
            }
        }

        return answer;
    }
}
