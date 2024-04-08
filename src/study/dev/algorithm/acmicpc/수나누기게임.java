package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 수나누기게임 {

    /**
     * INPUT
     * <p>
     * 3
     * 3 4 12
     * <p>
     * 4
     * 7 23 8 6
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE;

        int[] players = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(max, temp); // 가장 큰 값 구하기
            players[i] = temp;
        }

        // player 중 가장 큰 값의 크기로 배열 생성
        boolean[] available = new boolean[max + 1];
        // player를 index로 하여 true로 check.
        for (int i : players)
            available[i] = true;

        System.out.println(solution(max, players, available));
    }

    private static String solution(int max, int[] players, boolean[] available) {
        int[] score = new int[max + 1];

        for (int i : players) {
            // 각 player의 배수를 체크하여 있을 경우(true인 경우) 점수 처리.
            for (int j = i * 2; j <= max; j += i) {
                if (available[j]) {
                    score[i]++;
                    score[j]--;
                }
            }
        }

        return Arrays.stream(players).mapToObj(i -> score[i] + " ").collect(Collectors.joining());
    }
}
