package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 수찾기 {

    /**
     * INPUT
     * <p>
     * 5
     * 4 1 5 2 3
     * 5
     * 1 3 7 9 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solutionWithBinarySearch(number, targets));
        // System.out.print(solutionWithHashSet(number, targets));
    }

    /**
     * 이분탐색 이용
     *
     * @param number  - 정수
     * @param targets - 존재 여부 대상
     * @return - answer
     */
    private static String solutionWithBinarySearch(int[] number, int[] targets) {
        Arrays.sort(number);

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            boolean isExist = false;
            int start = 0, medium, end = number.length - 1;

            while (start <= end) {
                medium = (start + end) / 2;
                if (target == number[medium]) {
                    isExist = true;
                    break;
                } else if (target > number[medium]) {
                    start = medium + 1;
                } else {
                    end = medium - 1;
                }
            }

            if (isExist) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * HashSet 이용
     *
     * @param number  - 정수
     * @param targets - 존재 여부 대상
     * @return - answer
     */
    private static String solutionWithHashSet(int[] number, int[] targets) {
        HashSet<Integer> set = Arrays.stream(number)
                .boxed().collect(Collectors.toCollection(HashSet::new));

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            if (set.contains(target)) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }

        return sb.toString();
    }
}
