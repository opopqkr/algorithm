package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 파일명정렬 {
    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})).forEach(i -> System.out.print(i + ", "));
        System.out.println();

        Arrays.stream(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})).forEach(i -> System.out.print(i + ", "));
        System.out.println();
    }

    public static String[] solution(String[] files) {
        List<File> answer = Arrays.stream(files).map(File::new).sorted((o1, o2) -> {
            if (o1.head.equalsIgnoreCase(o2.head)) {
                return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
            }
            return o1.head.compareToIgnoreCase(o2.head);
        }).collect(Collectors.toList());

        return answer.stream().map(File::getFileName).toArray(String[]::new);
    }

    private static class File {
        String head = "", number = "", tail = "";

        public File(String fileName) {
            int i = 0;
            for (; i < fileName.length(); i++) {
                if (!Character.isDigit(fileName.charAt(i))) {
                    this.head += fileName.charAt(i);
                } else {
                    break;
                }
            }

            for (; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    this.number += fileName.charAt(i);
                } else {
                    break;
                }
            }

            for (; i < fileName.length(); i++) {
                this.tail += fileName.charAt(i);
            }
        }

        public String getFileName() {
            return this.head + this.number + this.tail;
        }
    }
}
