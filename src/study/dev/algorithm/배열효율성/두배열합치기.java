package study.dev.algorithm.배열효율성;

import java.util.Scanner;

public class 두배열합치기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] inputs1 = new int[n];
        for (int i = 0; i < n; i++) {
            inputs1[i] = in.nextInt();
        }

        int m = in.nextInt();

        int[] inputs2 = new int[m];
        for (int i = 0; i < m; i++) {
            inputs2[i] = in.nextInt();
        }

        for (int i : solution1(inputs1, inputs2)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution1(int[] inputs1, int[] inputs2) {
        int[] answer = new int[inputs1.length + inputs2.length];

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < answer.length; i++) {
            if (inputs1[index1] < inputs2[index2]) {
                answer[i] = inputs1[index1];
                if (index1 != inputs1.length - 1) {
                    index1++;
                }
            } else {
                answer[i] = inputs2[index2];
                if (index2 != inputs2.length - 1) {
                    index2++;
                }
            }
        }

        return answer;
    }

}
