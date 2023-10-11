package study.dev.algorithm.programmers;

public class 큰수만들기GREEDY {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int start = 0;
        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                char charNumber = number.charAt(j);
                if (charNumber > max) {
                    max = charNumber;
                    start = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }

}
