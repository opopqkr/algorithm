package study.dev.algorithm.programmers;

public class 붕대감기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));

        // 반례 (초당 회복량 관련)
        System.out.println(solution(new int[]{3, 10, 1}, 100, new int[][]{{1, 5}, {3, 5}}));
    }

    private static int solution(int[] bandage, int health, int[][] attacks) {
        // 최대 시간, 현재 체력, 연속 붕대 감기 횟수, 공격 번호
        int maxTime = attacks[attacks.length - 1][0], currentHealth = health, healthCount = 0, attackNumber = 0;

        for (int time = 1; time <= maxTime; time++) {
            // 공격 번호가 총 공격 횟수 보다 작고 && 현재 시간이 공격 시간 일경우
            if (attackNumber < attacks.length && time == attacks[attackNumber][0]) {
                currentHealth -= attacks[attackNumber][1]; // 피해량 차감
                attackNumber++; // 공격 번호 증가
                healthCount = 0; // 연송 붕대 감기 횟수 초기화
                if (currentHealth <= 0)
                    return -1;

                continue;
            }

            currentHealth = Math.min(currentHealth + bandage[1], health); // 초당 회복량 만큼 회복(최대체력을 넘지 못하게)
            healthCount++; // 연송 붕대 감기 횟수 증가

            if (healthCount == bandage[0]) {
                healthCount = 0; // 연송 붕대 감기 횟수 초기화
                currentHealth = Math.min(currentHealth + bandage[2], health); // 추가 회복량 회복(최대체력을 넘지 못하게)
            }
        }

        return currentHealth <= 0 ? -1 : currentHealth;
    }
}
