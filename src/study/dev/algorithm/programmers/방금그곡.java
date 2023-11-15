package study.dev.algorithm.programmers;

public class 방금그곡 {

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    public static String solution(String m, String[] musicinfos) {
        String findMusicMelody = conversionSound(m);

        MusicInformation answer = null;
        for (String musicInfo : musicinfos) {
            MusicInformation musicInformation = new MusicInformation(musicInfo);

            if (musicInformation.isMatch(findMusicMelody)) {
                if (answer == null) {
                    answer = musicInformation;
                } else {
                    if (answer.playTime < musicInformation.playTime) {
                        answer = musicInformation;
                    }
                }
            }
        }

        return answer == null ? "(None)" : answer.title;
    }

    private static class MusicInformation {

        int playTime;
        String title, melody;

        public MusicInformation(String musicInfo) {
            String[] temp = musicInfo.split(",");

            int startTime = (Integer.parseInt(temp[0].split(":")[0]) * 60) + Integer.parseInt(temp[0].split(":")[1]);
            int endTime = (Integer.parseInt(temp[1].split(":")[0]) * 60) + Integer.parseInt(temp[1].split(":")[1]);

            this.playTime = endTime - startTime;
            this.title = temp[2];
            this.melody = conversionSound(temp[3]);

            while (this.melody.length() <= this.playTime) {
                this.melody += this.melody;
            }

            this.melody = this.melody.substring(0, this.playTime);
        }

        public boolean isMatch(String findMusicMelody) {
            return this.melody.contains(findMusicMelody);
        }
    }

    private static String conversionSound(String melody) {
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        melody = melody.replaceAll("A#", "a");

        return melody;
    }
}
