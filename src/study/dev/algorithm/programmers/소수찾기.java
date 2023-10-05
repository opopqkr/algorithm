package study.dev.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        Set<Integer> primeNumbers = new HashSet<>();
        boolean[] check = new boolean[numbers.length()];

        return dfs("", numbers, check, primeNumbers).size();
    }

    private static Set<Integer> dfs(String number, String numbers, boolean[] check, Set<Integer> primeNumbers) {
        if (!number.isEmpty() && isPrime(Integer.parseInt(number))) {
            primeNumbers.add(Integer.parseInt(number));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(number + numbers.charAt(i), numbers, check, primeNumbers);
                check[i] = false;
            }
        }

        return primeNumbers;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
