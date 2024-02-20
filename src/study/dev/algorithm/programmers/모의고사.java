package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    public static void main(String[] args) {
        Arrays.stream(solution(new int[]{1, 2, 3, 4, 5})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(solution(new int[]{1, 3, 2, 4, 2})).forEach(System.out::print);
        System.out.println();
    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> results = new ArrayList<>();
        int[] pattern1 = {1, 2, 3, 4, 5}, pattern2 = {2, 1, 2, 3, 2, 4, 2, 5}, pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int index1 = 0, index2 = 0, index3 = 0;
        int count1 = 0, count2 = 0, count3 = 0;

        int max = 0;
        for (int answer : answers) {
            if (index1 >= pattern1.length) index1 = 0;
            if (index2 >= pattern2.length) index2 = 0;
            if (index3 >= pattern3.length) index3 = 0;

            if (answer == pattern1[index1]) count1++;
            index1++;
            max = Math.max(count1, max);

            if (answer == pattern2[index2]) count2++;
            index2++;
            max = Math.max(count2, max);

            if (answer == pattern3[index3]) count3++;
            index3++;
            max = Math.max(count3, max);
        }

        if (max == count1) results.add(1);
        if (max == count2) results.add(2);
        if (max == count3) results.add(3);

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
