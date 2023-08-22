package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        System.out.println(solution("CBD", new String[]{"CED"})); // 반례
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            if (availability(skill, skill_tree)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean availability(String skill, String skill_tree) {
        List<Character> newSkill = new ArrayList<>();

        // skill tree 를 순차적으로 돌면서 skill 에 포함되어 있으면 new skill 에 add.
        for (char skillSequence : skill_tree.toCharArray()) {
            if (skill.contains(String.valueOf(skillSequence))) {
                newSkill.add(skillSequence);
            }
        }

        // 새로 습득한 skill 크기만큼 순차적으로 돌면서 기존 스킬의 순차와 다르면 false return.
        for (int i = 0; i < newSkill.size(); i++) {
            if (newSkill.get(i) != skill.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
