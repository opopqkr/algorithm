package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 트리인가 {

    /**
     * INPUT
     * <p>
     * 6 8  5 3  5 2  6 4
     * 5 6  0 0
     * 8 1  7 3  6 2  8 9  7 5
     * 7 4  7 8  7 6  0 0
     * 3 8  6 8  6 4
     * 5 3  5 6  5 2  0 0
     * -1 -1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean stop = false;
        int k = 1;

        // 간선 정보
        // 자식 노드가 키, 부모 노드는 ArrayList.
        HashMap<Integer, ArrayList<Integer>> vertex = new HashMap<>();
        while (!stop) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreElements()) {
                // u = 부모 노드, v = 자식 노드
                int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

                if (u == -1 && v == -1) {
                    stop = true;
                    break;
                }

                if (u == 0 && v == 0) {
                    System.out.println(isTree(vertex) ?
                            "Case " + k + " is a tree." :
                            "Case " + k + " is not a tree.");
                    vertex = new HashMap<>();
                    k++;
                    continue;
                }

                ArrayList<Integer> parents = vertex.getOrDefault(v, new ArrayList<>());
                parents.add(u);
                vertex.put(v, parents);
            }
        }
    }

    private static boolean isTree(HashMap<Integer, ArrayList<Integer>> vertex) {
        // 간선이 없는 경우도 트리.
        if (vertex.isEmpty()) {
            return true;
        }

        // 중복을 제거한 부모 노드들.
        HashSet<Integer> deduplicationParents = new HashSet<>();

        for (ArrayList<Integer> parents : vertex.values()) {
            // 부모 노드가 2개 이상이면 트리가 아님.
            if (parents.size() > 1) {
                return false;
            }
            deduplicationParents.addAll(parents);
        }

        int rootCount = 0;
        for (int parent : deduplicationParents) {
            // 자식 노드들 중, 부모 노드를 포함하지 않은 경우는 루트 노드.
            if (!vertex.containsKey(parent)) {
                rootCount++;
            }
        }

        // 루트 노드가 한개여야 트리.
        return rootCount == 1;
    }
}