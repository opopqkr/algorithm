package study.dev.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] temp : clothes) {
            map.put(temp[1], map.getOrDefault(temp[1], 0) + 1);
        }

        for (int i : map.values()) {
            // 각 의상 별 종류 수에 의상 미착용의 경우인 1을 더해서 곱함 (조합)
            answer *= (i + 1);
        }

        // 아무것도 착용하지 않은 경우의 수를 빼서 return
        return answer - 1;
    }
}
