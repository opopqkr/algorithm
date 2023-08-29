package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

    public static void main(String[] args) {
        String[] log = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        for (String chat : log) {
            System.out.println(chat);
        }
    }

    public static String[] solution(String[] record) {
        ArrayList<String> logs = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();

        StringBuilder stringBuilder;
        for (String chat : record) {
            stringBuilder = new StringBuilder();
            String behavior = chat.split(" ")[0];
            String uuid = chat.split(" ")[1];

            switch (behavior) {
                case "Enter":
                    userInfo.put(uuid, chat.split(" ")[2]);
                    logs.add(stringBuilder.append(uuid).append("님이 들어왔습니다.").toString());
                    break;
                case "Leave":
                    logs.add(stringBuilder.append(uuid).append("님이 나갔습니다.").toString());
                    break;
                case "Change":
                    userInfo.put(uuid, chat.split(" ")[2]);
                    break;
                default:
                    break;
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            stringBuilder = new StringBuilder(logs.get(i));
            int index = stringBuilder.indexOf("님");
            answer[i] = stringBuilder.replace(0, index, userInfo.get(stringBuilder.substring(0, index))).toString();
        }

        return answer;
    }
}
