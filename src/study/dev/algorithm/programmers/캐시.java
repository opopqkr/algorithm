package study.dev.algorithm.programmers;

import java.util.ArrayList;

public class 캐시 {

    public static void main(String[] args) {
        System.out.println(solution(3,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));

        System.out.println(solution(3,
                new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));

        System.out.println(solution(2,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));

        System.out.println(solution(5,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));

        System.out.println(solution(2,
                new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));

        System.out.println(solution(0,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        ArrayList<String> cache = new ArrayList<>();
        for (String temp : cities) {
            String city = temp.toLowerCase();
            answer += offer(cache, cacheSize, city);
        }

        return answer;
    }

    private static int offer(ArrayList<String> cache, int cacheSize, String city) {
        if (cache.contains(city)) {
            cache.remove(city);
            cache.add(city);
            return 1;
        } else {
            if (cache.size() < cacheSize) {
                cache.add(city);
            } else {
                cache.remove(0);
                cache.add(city);
            }
            return 5;
        }
    }
}
