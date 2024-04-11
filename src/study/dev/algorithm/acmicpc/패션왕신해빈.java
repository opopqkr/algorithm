package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 패션왕신해빈 {

    /**
     * INPUT
     * <p>
     * 2
     * 3
     * hat headgear
     * sunglasses eyewear
     * turban headgear
     * 3
     * mask face
     * sunglasses face
     * makeup face
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        combination = new int[91][91]; // 0 <= n <= 30;

        HashMap<String, Integer> map;
        while (T-- > 0) {
            map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String type = br.readLine().split(" ")[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            System.out.println(solution(map));
        }
    }

    private static int[][] combination;

    private static int solution(HashMap<String, Integer> map) {
        int answer = 1;

        for (int count : map.values()) {
            // 입지 않는 것(null)을 포함하여 각 의상의 종류별 조합 구하기
            // ex) headgear = [hat, turban, null] = 3C1
            //     eye wear = [sunglasses, null] = 2C1
            //     3C1 * 2C1
            answer *= getCombination(count + 1, 1); // count + 1의 의미는 입지 않는 것(null)을 포함
        }

        // headgear, eye wear 둘 다 null 인 경우, 즉 입지 않은 것을 제외하여 -1하여 return
        return answer - 1;
    }

    /**
     * 조합 구하기 nCr
     *
     * @param n - n개 중
     * @param r - r개를 뽑을 수 있는
     * @return - 조합 경우의 수
     */
    private static int getCombination(int n, int r) {
        if (combination[n][r] > 0) {
            return combination[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return combination[n][r] = getCombination(n - 1, r - 1) + getCombination(n - 1, r);
        }
    }
}
