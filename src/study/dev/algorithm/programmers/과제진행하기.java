package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class 과제진행하기 {

    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

        for (String answer : solution(plans)) {
            System.out.println(answer);
        }
    }

    public static String[] solution(String[][] plans) {
        ArrayList<Homework> homeworks = new ArrayList<>();
        for (String[] homework : plans) {
            homeworks.add(new Homework(homework[0], homework[1], homework[2]));
        }

        Collections.sort(homeworks);
        ArrayList<String> answer = new ArrayList<>();
        Stack<Homework> stack = new Stack<>();

        for (Homework newHomework : homeworks) {
            if (stack.isEmpty()) {
                stack.push(newHomework);
                continue;
            }

            Homework currentHomework = stack.pop();
            int remainingTime = currentHomework.startTime + currentHomework.playTime - newHomework.startTime;
            if (remainingTime > 0) {
                stack.push(new Homework(currentHomework.name, currentHomework.startTime, remainingTime));
            } else {
                answer.add(currentHomework.name);
                while (!stack.isEmpty()) {
                    Homework leftoverHomework = stack.pop();
                    remainingTime = leftoverHomework.playTime - Math.abs(remainingTime);
                    if (remainingTime > 0) {
                        stack.push(new Homework(leftoverHomework.name, leftoverHomework.startTime, remainingTime));
                        break;
                    } else {
                        answer.add(leftoverHomework.name);
                    }
                }
            }

            stack.push(newHomework);
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[answer.size()]);
    }

    private static class Homework implements Comparable<Homework> {
        String name;
        int startTime;
        int playTime;

        public Homework(String name, String startTime, String playTime) {
            this.name = name;

            String[] splitTimeMinute = startTime.split(":");
            this.startTime = (Integer.parseInt(splitTimeMinute[0]) * 60) + Integer.parseInt(splitTimeMinute[1]);
            this.playTime = Integer.parseInt(playTime);
        }

        public Homework(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Homework o) {
            return this.startTime - o.startTime;
        }
    }
}