package study.dev.algorithm.programmers;

import java.util.*;

public class 혼자놀기의달인 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }

    // union & find 사용
    private static int[] disjointSet;

    public static int solution(int[] cards) {
        int length = cards.length;
        disjointSet = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            disjointSet[i] = i;
        }

        // 1 부터 배열의 끝까지 cards[i - 1]과 union
        for (int i = 1; i <= length; i++) {
            union(i, cards[i - 1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            int root = find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        // 그룹이 1개만 있을 경우 0 return
        if (map.size() == 1) {
            return 0;
        }

        List<Integer> candidates = new ArrayList<>(map.values());
        candidates.sort(Collections.reverseOrder());
        return candidates.get(0) * candidates.get(1);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            disjointSet[x] = y;
        }
    }

    private static int find(int x) {
        if (disjointSet[x] == x) {
            return x;
        } else {
            return find(disjointSet[x]);
        }
    }
}
