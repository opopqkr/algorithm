package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}}));
    }

    private static ArrayList<HashSet<Integer>> candidateKeys;

    public static int solution(String[][] relation) {
        candidateKeys = new ArrayList<>();

        int totalColumnSize = relation[0].length;
        for (int columnSize = 1; columnSize <= totalColumnSize; columnSize++) {
            findCandidateKeys(0, 0, columnSize, new boolean[totalColumnSize], new HashSet<>(), relation);
        }

        return candidateKeys.size();
    }

    private static void findCandidateKeys(int index, int columnCount, int columnSize, boolean[] checked, HashSet<Integer> attributes, String[][] relation) {
        if (columnCount == columnSize) {
            if (!(isUnique(relation, attributes) && isMinimal(attributes))) {
                return;
            }
            candidateKeys.add(attributes);
            return;
        }

        for (int i = index; i < relation[0].length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                HashSet<Integer> newAttributes = new HashSet<>(attributes);
                newAttributes.add(i);
                findCandidateKeys(i + 1, columnCount + 1, columnSize, checked, newAttributes, relation);
                checked[i] = false;
            }
        }
    }

    private static boolean isUnique(String[][] relation, HashSet<Integer> attributes) {
        ArrayList<String> candidateKey = new ArrayList<>();

        for (String[] tuple : relation) {
            StringBuilder key = new StringBuilder();
            for (int attribute : attributes) {
                key.append(tuple[attribute]);
            }
            if (!candidateKey.contains(key.toString())) {
                candidateKey.add(key.toString());
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isMinimal(HashSet<Integer> attributes) {
        for (HashSet<Integer> key : candidateKeys) {
            if (attributes.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
}
