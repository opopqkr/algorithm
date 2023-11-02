package study.dev.algorithm.programmers;

public class 단체사진찍기 {

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    private static int answer;

    public static int solution(int n, String[] data) {
        answer = 0;

        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        dfs(0, new StringBuilder(), new boolean[friends.length], friends, data);

        return answer;
    }

    private static void dfs(int depth, StringBuilder arrangement, boolean[] check, char[] friends, String[] data) {
        if (depth == friends.length) {
            if (checkCondition(arrangement.toString(), data)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!check[i]) {
                check[i] = true;
                arrangement.append(friends[i]);
                dfs(depth + 1, arrangement, check, friends, data);
                arrangement.deleteCharAt(arrangement.length() - 1);
                check[i] = false;
            }
        }

    }

    private static boolean checkCondition(String arrangement, String[] data) {
        for (String condition : data) {
            int member1Location = arrangement.indexOf(condition.charAt(0));
            int member2Location = arrangement.indexOf(condition.charAt(2));

            char sign = condition.charAt(3);
            int number = Integer.parseInt(String.valueOf(condition.charAt(4))) + 1;

            int interval = Math.abs(member1Location - member2Location);

            if (sign == '>' && interval <= number) return false;
            if (sign == '<' && interval >= number) return false;
            if (sign == '=' && interval != number) return false;
        }

        return true;
    }
}
