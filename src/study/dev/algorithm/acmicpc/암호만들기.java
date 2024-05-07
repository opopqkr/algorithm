package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

    /**
     * INPUT
     * <p>
     * 4 6
     * a t c i s w
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] input = new char[C];
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        combination(0, "", input, new boolean[C]);
    }

    private static void combination(int index, String password, char[] input, boolean[] visited) {
        if (password.length() == L) {
            int consonant = 0, vowel = 0;
            for (char word : password.toCharArray()) {
                if (word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u')
                    vowel++;
                else
                    consonant++;
            }

            // 자음이 2개 이상, 모음이 1개 이상인 경우에만 출력
            if (consonant >= 2 && vowel >= 1)
                System.out.println(password);

            return;
        }

        for (int i = index; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, password + input[i], input, visited);
                visited[i] = false;
            }
        }
    }

    private static int L, C;
}
