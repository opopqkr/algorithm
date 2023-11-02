package study.dev.algorithm.programmers;

public class 신규아이디추천 {

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        return conversion(new_id);
    }

    private static String conversion(String new_id) {
        // step1
        new_id = new_id.toLowerCase();

        // step2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // step3
        new_id = new_id.replaceAll("\\.+", ".");

        // step4
        new_id = new_id.startsWith(".") ? new_id.substring(1) : new_id;
        new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length() - 1) : new_id;

        // step5
        new_id = new_id.isEmpty() ? "a" : new_id;

        // step6
        new_id = new_id.length() > 15 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length() - 1) : new_id;

        // step7
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
