package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 광물캐기 {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 3, 2},
//                new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(solution(new int[]{0, 1, 1},
                new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickCount = Arrays.stream(picks).sum();
        ArrayList<MiningInfo> miningInfos = new ArrayList<>();

        for (int i = 0; i < minerals.length; i += 5) {
            if (pickCount == 0) break;

            int diamondPick = 0, ironPick = 0, stonePick = 0;
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;

                if (minerals[j].equals("diamond")) {
                    diamondPick += 1;
                    ironPick += 5;
                    stonePick += 25;
                }
                if (minerals[j].equals("iron")) {
                    diamondPick += 1;
                    ironPick += 1;
                    stonePick += 5;
                }
                if (minerals[j].equals("stone")) {
                    diamondPick += 1;
                    ironPick += 1;
                    stonePick += 1;
                }
            }
            miningInfos.add(new MiningInfo(diamondPick, ironPick, stonePick));
            pickCount--;
        }

        miningInfos.sort((o1, o2) -> o2.stonePick - o1.stonePick);

        for (MiningInfo mining : miningInfos) {
            int dia = mining.diamondPick;
            int iron = mining.ironPick;
            int stone = mining.stonePick;

            if (picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }

            if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }

            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }

        return answer;
    }

    private static class MiningInfo {
        int diamondPick;
        int ironPick;
        int stonePick;

        public MiningInfo(int diamondPick, int ironPick, int stonePick) {
            this.diamondPick = diamondPick;
            this.ironPick = ironPick;
            this.stonePick = stonePick;
        }
    }

}
