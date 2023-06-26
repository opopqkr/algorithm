package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘과 다른것은 무방향 트리
 * 다익스트라는 방향을 갖고 있음
 * 최소신장트리 : 프림 (우선순위 큐)
 */
public class 원더랜드2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        ArrayList<ArrayList<City>> wonderLand = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            wonderLand.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            // 양방향으로 연결
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int c = in.nextInt();
            wonderLand.get(v1).add(new City(v2, c));
            wonderLand.get(v2).add(new City(v1, c));
        }

        System.out.println(solution(v, wonderLand));
    }

    private static int solution(int v, ArrayList<ArrayList<City>> wonderLand) {
        int answer = 0;

        // 정점만큼의 배열 필요
        boolean[] check = new boolean[v + 1];

        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new City(1, 0));

        while (!priorityQueue.isEmpty()) {
            City currentCity = priorityQueue.poll();
            int currentRoad = currentCity.road;
            int currentCost = currentCity.cost;

            // 체크 되지 않은 정점만 
            if (!check[currentRoad]) {
                check[currentRoad] = true;
                answer += currentCost;

                for (City otherCity : wonderLand.get(currentRoad)) {
                    if (!check[otherCity.road]) { // 체크되지 않은 정점만 큐에 넣음
                        priorityQueue.offer(otherCity);
                    }
                }
            }
        }

        return answer;
    }

    private static class City implements Comparable<City> {
        int road, cost;

        public City(int road, int cost) {
            this.road = road;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }
    }
}
