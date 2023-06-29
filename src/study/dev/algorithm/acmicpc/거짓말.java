package study.dev.algorithm.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class 거짓말 {

    private static int[] disjointSet;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        disjointSet = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            disjointSet[i] = i;
        }

        int m = in.nextInt();

        ArrayList<Integer> knownPeople = new ArrayList<>();
        int knownCount = in.nextInt();
        for (int i = 0; i < knownCount; i++) {
            knownPeople.add(in.nextInt());
        }

        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> party = new ArrayList<>();
            int joinCount = in.nextInt();
            for (int j = 0; j < joinCount; j++) {
                party.add(in.nextInt());
            }
            parties.add(party);
        }

        System.out.println(solution(knownPeople, parties));
    }

    private static int solution(ArrayList<Integer> knownPeople, ArrayList<ArrayList<Integer>> parties) {
        // disjointSet[0] 활용
        for (int knownPerson : knownPeople) {
            union(disjointSet[0], find(knownPerson));
        }

        for (ArrayList<Integer> party : parties) {
            if (party.size() > 1) {
                for (int j = 0; j < party.size(); j++) {
                    if (find(party.get(0)) != find(party.get(j))) {
                        union(find(party.get(0)), find(party.get(j)));
                    }
                }
            }

            boolean addKnownPerson = false;
            for (int person : party) {
                if (knownPeople.contains(person)) {
                    addKnownPerson = true;
                    break;
                }
            }
            if (addKnownPerson) {
                for (int person : party) {
                    union(disjointSet[0], find(person));
                }
            }
        }

        int answer = parties.size();

        for (ArrayList<Integer> party : parties) {
            boolean join = true;
            for (int person : party) {
                if (find(disjointSet[0]) == find(person)) {
                    join = false;
                    break;
                }
            }

            if (!join) {
                answer--;
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
            return find(disjointSet[x]);
        }
    }
}