package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 최소신장트리 : 크루스칼 알고리즘 (Union & Find)
 * 모든 간선의 가중치 값을 최소의 트리로 만들어 내는 것
 * 그래프와는 다르게 회전성(회로)이 존재 하지 않음
 * 그러므로 트리 간선의 개수는 n-1 개
 * <p>
 * <p>
 * 풀이법
 * 1. 가중치 기준으로 정렬
 * 2. find 를 이용하여 같은 집합이 아니면 union
 */
public class 원더랜드1 {

    private static int[] disjointSet;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        disjointSet = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            disjointSet[i] = i;
        }

        ArrayList<WonderLand> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            list.add(new WonderLand(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        System.out.println(solution(v, list));
    }

    private static int solution(int v, ArrayList<WonderLand> list) {
        int answer = 0, count = 0;

        // 가중치 기준으로 정렬
        Collections.sort(list);

        for (WonderLand wonderLand : list) {
            if (find(wonderLand.city1) != find(wonderLand.city2)) {
                union(wonderLand.city1, wonderLand.city2);
                answer += wonderLand.cost;
                count++;
            }
            // 트리 간선의 갯수는 n - 1 임으로,
            // 트리가 완성 되면 find 할 필요 없음 (시간 단축)
            if (count == v - 1) {
                break;
            }
        }

        return answer;
    }

    private static void union(int x, int y) {
        int dx = find(x);
        int dy = find(y);

        if (dx != dy) {
            disjointSet[dy] = dx;
        }
    }

    private static int find(int x) {
        if (disjointSet[x] == x) {
            return x;
        } else {
            return disjointSet[x] = find(disjointSet[x]);
        }
    }

    /**
     * Greedy 이기 때문에 순간 순간의 가중치가 작은 값을 선택하기 위해
     * 가중치가 작은 값 부터 정렬 될 수 있도록 compareTo Method Override
     */
    private static class WonderLand implements Comparable<WonderLand> {
        int city1, city2, cost;

        public WonderLand(int city1, int city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }

        @Override
        public int compareTo(WonderLand o) {
            return this.cost - o.cost;
        }
    }
}
