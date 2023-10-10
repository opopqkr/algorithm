package study.dev.algorithm.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1, 2 케이스 오답
 */
public class 여행경로BFS {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(solution(new String[][]{{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static String[] solution(String[][] tickets) {
        List<Ticket> ticketList = Arrays.stream(tickets).sorted(Comparator.comparing(o -> o[1]))
                .map(_string_ -> new Ticket(_string_[0], _string_[1])).collect(Collectors.toList());

        List<String> route = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        for (Ticket ticket : ticketList) {
            if ("ICN".equals(ticket.departure)) {
                route.add(ticket.departure);
                ticket.visited = true;
                queue.offer(ticket.destination);
                break;
            }
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (Ticket ticket : ticketList) {
                if (current.equals(ticket.departure) && !ticket.visited) {
                    route.add(ticket.departure);
                    ticket.visited = true;
                    queue.offer(ticket.destination);
                    break;
                }
            }

            if (queue.isEmpty()) {
                route.add(current);
            }
        }

        return route.toArray(new String[0]);
    }

    private static class Ticket {
        String departure, destination;
        boolean visited;

        public Ticket(String departure, String destination) {
            this.departure = departure;
            this.destination = destination;
            this.visited = false;
        }
    }
}
