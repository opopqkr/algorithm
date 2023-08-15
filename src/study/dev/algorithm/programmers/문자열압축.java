package study.dev.algorithm.programmers;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = s.length();
        StringBuilder word = new StringBuilder(s);

        // 기존 문자열의 반까지만 확인
        // 반 이상일 경우 압축 불가
        for (int size = 1; size <= word.length() / 2; size++) {
            // 압축 문자열
            StringBuilder compressWord = new StringBuilder();
            // 비교 기준 문자열
            String base = word.substring(0, size);

            // 1개 이상 부터 압축
            int compressCount = 1;
            for (int i = size; i <= word.length(); i += size) {
                // Math.min 을 사용하는 이유는 문자열 범위(index)를 초과하지 않기 위함.
                int end = Math.min(i + size, word.length());
                // 비교 문자열
                String compare = word.substring(i, end);

                if (base.equals(compare)) {
                    compressCount++;
                } else {
                    // 비교 문자가 다를 경우 압축 문자열에 append
                    if (compressCount >= 2) {
                        compressWord.append(compressCount);
                    }
                    compressWord.append(base);

                    // 비교 기준 문자열을 대체
                    base = compare;
                    compressCount = 1;
                }
            }
            // 남는 문자열 append
            compressWord.append(base);
            answer = Math.min(answer, compressWord.length());
        }

        return answer;
    }
}