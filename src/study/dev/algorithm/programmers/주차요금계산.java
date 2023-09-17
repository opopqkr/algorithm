package study.dev.algorithm.programmers;

import java.util.*;

public class 주차요금계산 {

    public static void main(String[] args) {
        int[] answer1 = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int i : answer1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] answer2 = solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
        for (int i : answer2) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] answer3 = solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});
        for (int i : answer3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, ParkingInfo> carMap = new HashMap<>();
        for (String record : records) {
            String[] temp = record.split(" ");
            String time = temp[0];
            String number = temp[1];

            ParkingInfo parkingInfo = carMap.getOrDefault(number, new ParkingInfo());
            if (temp[2].equals("IN")) {
                parkingInfo.parking(time);
            } else {
                parkingInfo.exit(time);
            }

            carMap.put(number, parkingInfo);
        }

        // 차량 번호 순으로 정렬
        List<String> keySet = new ArrayList<>(carMap.keySet());
        Collections.sort(keySet);

        List<Integer> answer = new ArrayList<>();
        for (String number : keySet) {
            ParkingInfo parkingInfo = carMap.get(number);
            answer.add(parkingInfo.calculateParkingFee(fees));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class ParkingInfo {
        private int parkingTime, totalTime;
        private boolean isCalculate;

        /**
         * 입차
         *
         * @param entryTime - 입차시간
         */
        public void parking(String entryTime) {
            String[] temp = entryTime.split(":");
            this.parkingTime = (Integer.parseInt(temp[0]) * 60) + Integer.parseInt(temp[1]);
            this.isCalculate = false;
        }

        /**
         * 출차
         *
         * @param exitTime - 출차시간
         */
        public void exit(String exitTime) {
            String[] temp = exitTime.split(":");
            this.totalTime += ((Integer.parseInt(temp[0]) * 60) + Integer.parseInt(temp[1])) - this.parkingTime;
            this.isCalculate = true;
        }

        /**
         * 주차 계산
         *
         * @param fees - 요금정보
         * @return parkingFee - 주차요금
         */
        public int calculateParkingFee(int[] fees) {
            if (!this.isCalculate) {
                this.exit("23:59");
            }

            if (this.totalTime <= fees[0]) {
                return fees[1];
            } else {
                this.totalTime -= fees[0];
                return fees[1] + ((int) Math.ceil((double) this.totalTime / fees[2]) * fees[3]);
            }
        }
    }
}
