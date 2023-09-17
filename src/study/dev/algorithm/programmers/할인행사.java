package study.dev.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap;
        for (int day = 0; day <= discount.length - 10; day++) {
            discountMap = new HashMap<>();
            for (int j = day; j < 10 + day; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            boolean membershipAvailability = true;
            for (String goods : wantMap.keySet()) {
                if (wantMap.get(goods) != discountMap.get(goods)) {
                    membershipAvailability = false;
                    break;
                }
            }
            if (membershipAvailability) {
                answer++;
            }
        }

        return answer;
    }
}
