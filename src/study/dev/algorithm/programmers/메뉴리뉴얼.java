package study.dev.algorithm.programmers;

import java.util.*;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})).forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.stream(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> courseMenu = new HashMap<>();

        // 새로 만들 코스 메뉴의 메뉴 가지 수에 대한 반복문
        for (int menuCount : course) {

            // 각 주문 메뉴 조합
            for (String order : orders) {
                char[] orderMenu = order.toCharArray();
                Arrays.sort(orderMenu);
                boolean[] check = new boolean[orderMenu.length];
                dfs("", 0, orderMenu, menuCount, check, courseMenu);
            }

            int max = Integer.MIN_VALUE;
            for (String newMenu : courseMenu.keySet()) {
                // 가장 많이 주문한 코스 메뉴의 주문 횟수 구하기
                max = Math.max(max, courseMenu.get(newMenu));
            }

            for (String newMenu : courseMenu.keySet()) {
                // 최소 한 번 이상 주문한 코스 메뉴와 가장 많이 주문한 코스 메뉴
                if (courseMenu.get(newMenu) > 1 && courseMenu.get(newMenu) == max) {
                    answer.add(newMenu);
                }
            }

            courseMenu.clear();
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    /**
     * 메뉴 조합 구하기
     *
     * @param newCourseMenu
     * @param index
     * @param orderMenu
     * @param menuCount
     * @param check
     * @param courseMenu
     */
    private static void dfs(String newCourseMenu, int index, char[] orderMenu, int menuCount, boolean[] check, Map<String, Integer> courseMenu) {
        if (newCourseMenu.length() == menuCount) {
            courseMenu.put(newCourseMenu, courseMenu.getOrDefault(newCourseMenu, 0) + 1);
        }

        for (int i = index; i < orderMenu.length; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(newCourseMenu + orderMenu[i], i + 1, orderMenu, menuCount, check, courseMenu);
                check[i] = false;
            }
        }
    }
}
