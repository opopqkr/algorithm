package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 호텔대실 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"14:10", "19:20"}, {"14:20", "15:20"}, {"16:40", "18:20"}, {"15:00", "17:00"}, {"18:20", "21:20"}}));
        System.out.println(solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }

    public static int solution(String[][] book_time) {
        List<Book> books = Arrays.stream(book_time).map(Book::new)
                .sorted(Comparator.comparingInt(o -> o.startTime))
                .collect(Collectors.toList());

        List<Book> rooms = new ArrayList<>();

        for (Book currentBook : books) {
            boolean checkOut = false;

            int roomNumber = 0;
            for (; roomNumber < rooms.size(); roomNumber++) {
                if (rooms.get(roomNumber).endTime <= currentBook.startTime) {
                    checkOut = true;
                    break;
                }
            }

            if (checkOut) {
                rooms.remove(roomNumber);
            }

            rooms.add(currentBook);
        }

        return rooms.size();
    }

    private static class Book {
        int startTime, endTime;

        public Book(String[] bookInfo) {
            String[] startInfo = bookInfo[0].split(":");
            this.startTime = (Integer.parseInt(startInfo[0]) * 60) + Integer.parseInt(startInfo[1]);

            String[] endInfo = bookInfo[1].split(":");
            this.endTime = (Integer.parseInt(endInfo[0])) * 60 + Integer.parseInt(endInfo[1]) + 10;
        }
    }
}
