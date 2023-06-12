package study.dev.algorithm.문자열;

import java.util.Scanner;

public class 가장짧은문자거리 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputs = in.next();
        char t = in.next().charAt(0);
        solution1(inputs, t);
        System.out.println();
        for (int i : solution2(inputs, t)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 내 풀이 (강의 힌트를 얻음)
     *
     * @param inputs
     * @param t
     * @return
     */
    private static void solution1(String inputs, char t) {
        int len = inputs.length();

        /** 임의의 높은 값으로 배열 setting */
        int temp = 1000;

        /** 첫 번째 인덱스 부터 */
        int[] answerArray = new int[len];
        for (int i = 0; i < inputs.length(); i++) {
            temp++;
            /** target 문자와 동일하기 전까지는 임의의 높은 값으로 세팅, 같아지면 temp 를 0으로 초기화.
             * 초기화 후 temp 를 1씩 증가시켜주며 배열을 세팅하고, 다음에 같아지기 전까지 계속해서 증가.
             * 다음에 같아지면 다시 0으로 초기화하는 작업 반복. */
            if (inputs.charAt(i) == t) {
                temp = 0;
            }
            answerArray[i] = temp;
        }

        /** 마지막 인덱스 부터, temp 를 다시 임의의 높은 값으로 설정. */
        temp = 1000;
        for (int i = inputs.length() - 1; i >= 0; i--) {
            temp++;
            /** 위의 작업과 방법은 동일하나, 마지막 인덱스 부터 시작. */
            if (inputs.charAt(i) == t) {
                temp = 0;
            }
            /** 추가적으로, 처음에 세팅한 배열과 값을 비교하여 더 작은 값으로 변경. */
            if (answerArray[i] > temp) {
                answerArray[i] = temp;
            }
        }

        for (int i : answerArray) {
            System.out.print(i + " ");
        }
    }

    /**
     * 강의 풀이
     *
     * @param inputs
     * @param t
     */
    private static int[] solution2(String inputs, char t) {
        int[] answer = new int[inputs.length()];

        int temp = 1000;
        for (int i = 0; i < answer.length; i++) {
            if (inputs.charAt(i) == t) {
                temp = 0;
            } else {
                temp++;
            }
            answer[i] = temp;
        }

        temp = 1000;
        for (int i = answer.length - 1; i >= 0; i--) {
            if (inputs.charAt(i) == t) {
                temp = 0;
            } else {
                temp++;
                /** Math 함수 사용. */
                answer[i] = Math.min(answer[i], temp);
            }
        }
        return answer;
    }
}
