package study.dev.algorithm.programmers;

import java.util.HashSet;

public class 불량사용자 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        HashSet<HashSet<String>> result = new HashSet<>();
        dfs(0, new HashSet<>(), result, user_id, banned_id);
        return result.size();
    }

    private static void dfs(int index, HashSet<String> banCase, HashSet<HashSet<String>> result, String[] user_id, String[] banned_id) {
        if (index == banned_id.length) {
            result.add(banCase);
            return;
        }

        for (String userId : user_id) {
            if (banCase.contains(userId)) {
                continue;
            }

            if (isBan(banned_id[index], userId)) {
                banCase.add(userId);
                dfs(index + 1, new HashSet<>(banCase), result, user_id, banned_id);
                banCase.remove(userId);
            }
        }
    }

    private static boolean isBan(String banId, String userId) {
        if (banId.length() != userId.length()) {
            return false;
        }

        int index = 0;
        for (; index < banId.length(); index++) {
            if (banId.charAt(index) == '*') {
                continue;
            }

            if (banId.charAt(index) != userId.charAt(index)) {
                return false;
            }
        }

        return true;
    }
}
