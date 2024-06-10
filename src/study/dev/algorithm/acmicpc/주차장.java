package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 주차장 {

    /**
     * INPUT
     * <p>
     * 3 4
     * 2
     * 3
     * 5
     * 200
     * 100
     * 300
     * 800
     * 3
     * 2
     * -3
     * 1
     * 4
     * -4
     * -2
     * -1
     * <p>
     * 2 4
     * 5
     * 2
     * 100
     * 500
     * 1000
     * 2000
     * 3
     * 1
     * 2
     * 4
     * -1
     * -3
     * -2
     * -4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = temp[0], M = temp[1];

        int[] Rs = new int[N]; // 주차 공간 s의 단위 무게당 요금
        int[] parkingInfo = new int[N]; // 주차 정보 (주차 공간 크기 만큼)
        for (int i = 0; i < N; i++) {
            Rs[i] = Integer.parseInt(br.readLine());
        }

        int[] Wk = new int[M + 1]; // 차량 k의 무게
        for (int i = 1; i <= M; i++) {
            Wk[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> queue = new LinkedList<>(); // 대기 장소
        int cost = 0;

        outer:
        for (int i = 0; i < M * 2; i++) {
            int car = Integer.parseInt(br.readLine());

            if (car > 0) { // 입차
                for (int j = 0; j < N; j++) {
                    if (parkingInfo[j] == 0) { // 주차 공간이 있는 경우
                        parkingInfo[j] = car;
                        continue outer;
                    }
                }

                // 빈자리가 없을 경우
                queue.offer(car);
            } else { // 출차
                for (int j = 0; j < N; j++) {
                    if (parkingInfo[j] == Math.abs(car)) { // 주차가 이미 되어 있는 경우
                        cost += Rs[j] * Wk[Math.abs(car)]; // 출차 시 계산
                        parkingInfo[j] = 0;

                        if (!queue.isEmpty()) parkingInfo[j] = queue.poll();

                        break;
                    }
                }
            }
        }

        System.out.println(cost);
    }
}
