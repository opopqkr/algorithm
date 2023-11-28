package study.dev.algorithm.programmers;

import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        if (checkCorrect(p)) {
            return p;
        }

        return separation(p);
    }

    private static String separation(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환.
        if (w.isEmpty()) {
            return "";
        }

        // 2. u를 더 이상 분리할 수 없도록 균형잡힌 괄호 문자열로 분리. -> (, )의 카운트가 같으면 됨.
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int leftCount = 0, rightCount = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                u.append(w.substring(0, i + 1));
                v.append(w.substring(i + 1));
                break;
            }
        }

        if (checkCorrect(u.toString())) {
            // 3. 문자열 u가 올바른 괄호 문자열일 경우, v를 1단계부터 재 수행후 u에 붙어 반환
            return u.append(separation(v.toString())).toString();
        } else {
            // 4. 문자열 u가 올바른 괄호 문자열이 아닐 경우
            // 4-1. 빈 문자열에 (를 붙임.
            StringBuilder temp = new StringBuilder();
            temp.append("(");
            // 4-2. v를 1단계부터 재귀 수행.
            temp.append(separation(v.toString()));
            // 4-3. )를 다시 붙임.
            temp.append(")");

            // 4-4. u의 첫 번째와 마지막 문자를 제거 하고, 나머지 문자열의 괄호 방향을 뒤집어서(StringBuilder.reverse() 아님, 각각 뒤집기) 새로 생성한 문자열 뒤에 붙임.
            u.delete(0, 1);
            u.delete(u.length() - 1, u.length());
            temp.append(reverse(u.toString()));
            // 4-5. 생성된 문자열 반환.
            return temp.toString();
        }
    }

    private static boolean checkCorrect(String w) {
        Stack<Character> stack = new Stack<>();

        for (char brace : w.toCharArray()) {
            if (brace == '(') {
                stack.push(brace);
            } else {
                // EmptyStackException 방지.
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static String reverse(String u) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char brace : u.toCharArray()) {
            if (brace == '(') {
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
        }

        return stringBuilder.toString();
    }
}
