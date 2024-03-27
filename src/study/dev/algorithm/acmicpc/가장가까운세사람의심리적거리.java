package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 가장가까운세사람의심리적거리 {

    /**
     * INPUT
     * <p>
     * 3
     * 3
     * ENTJ INTP ESFJ
     * 4
     * ESFP ESFP ESFP ESFP
     * 5
     * INFP INFP ESTP ESTJ ISTJ
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            mbtis = br.readLine().split(" ");

            System.out.println(solution());
        }
    }

    private static int N;

    private static String[] mbtis;

    private static int answer;

    private static int solution() {
        // 비둘기집 원리
        // mbti의 갯수는 16개이며 32개를 초과할 경우 무조건 3개가 중복되기 때문에 0을 리턴해야 함.
        if (N > 32)
            return 0;

        answer = Integer.MAX_VALUE;
        dfs(new ArrayList<>(), new boolean[N]);
        return answer;
    }

    private static void dfs(ArrayList<String> friends, boolean[] check) {
        if (friends.size() == 3) {
            answer = Math.min(answer, count(friends.get(0), friends.get(1), friends.get(2)));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                friends.add(mbtis[i]);
                dfs(friends, check);
                friends.remove(friends.size() - 1);
                check[i] = false;
            }
        }
    }

    private static int count(String mbti1, String mbti2, String mbti3) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i))
                count++;
            if (mbti1.charAt(i) != mbti3.charAt(i))
                count++;
            if (mbti2.charAt(i) != mbti3.charAt(i))
                count++;
        }

        return count;
    }
}
