package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 전화번호목록 {

    public static void main(String[] args) {
        System.out.println(solutionByHash(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solutionByHash(new String[]{"123", "456", "789"}));
        System.out.println(solutionByForLoop(new String[]{"12", "123", "1235", "567", "88"}));
    }

    public static boolean solutionByHash(String[] phone_book) {
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toCollection(HashSet::new));

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solutionByForLoop(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
