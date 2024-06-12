package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 후보추천하기 {

    /**
     * INPUT
     * <p>
     * 3
     * 9
     * 2 1 4 3 5 6 2 7 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), count = Integer.parseInt(br.readLine());

        int[] students = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, students));
    }

    private static String solution(int N, int[] students) {
        ArrayList<Candidate> candidates = new ArrayList<>();

        outer:
        for (int i = 0; i < students.length; i++) {
            int student = students[i];

            for (Candidate candidate : candidates) {
                if (student == candidate.student) {
                    candidate.like++;
                    continue outer;
                }
            }

            if (candidates.size() < N) {
                candidates.add(new Candidate(students[i], i));
            } else {
                Collections.sort(candidates); // 정렬
                candidates.remove(0);
                candidates.add(new Candidate(student, i));
            }
        }

        StringBuilder sb = new StringBuilder();
        candidates.sort(Comparator.comparingInt(o -> o.student)); // 학생 번호로 sorting
        candidates.forEach(o -> sb.append(o.student).append(" "));
        return sb.toString();
    }

    private static class Candidate implements Comparable<Candidate> {
        int student, order, like;

        public Candidate(int student, int order) {
            this.student = student; // 학생 번호
            this.order = order; // 순서
            this.like = 0; // 추천 수
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.like == o.like) {
                return this.order - o.order;
            }
            return this.like - o.like;
        }
    }
}
