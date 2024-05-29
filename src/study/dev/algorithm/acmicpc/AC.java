package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC {

    /**
     * INPUT
     * <p>
     * 4
     * RDD
     * 4
     * [1,2,3,4]
     * DD
     * 1
     * [42]
     * RRD
     * 6
     * [1,1,2,3,5,8]
     * D
     * 0
     * []
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            String temp = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();
            while (st.hasMoreElements())
                deque.add(Integer.parseInt(st.nextToken()));

            System.out.println(solution(temp.toCharArray(), n, deque));
        }

    }

    private static Deque<Integer> deque;

    private static String solution(char[] functions, int n, Deque<Integer> array) {
        boolean isReverse = false;
        for (char function : functions) {
            if (function == 'R') {
                isReverse = !isReverse;
            } else {
                if (array.isEmpty())
                    return "error";

                if (isReverse)
                    array.pollLast();
                else
                    array.pollFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!array.isEmpty()) {
            if (isReverse)
                sb.append(array.pollLast());
            else
                sb.append(array.pollFirst());

            if (!array.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
