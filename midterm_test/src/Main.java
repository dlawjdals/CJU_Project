
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<restaurant> restaurants = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        restaurants.add(new restaurant("1. 아르떼 카페", 10, 13));
        restaurants.add(new restaurant("2. 켐토 카페", 15, 5));
        restaurants.add(new restaurant("3. 중앙도서관 카페", 20, 21));
        restaurants.add(new restaurant("4. 학생회관 식당", 70, 38));
        restaurants.add(new restaurant("5. 비즈니스대 식당", 50, 49));
        restaurants.add(new restaurant("6. 짬뽕의 맛", 30, 5));

        while (true) {
            System.out.println("\n--- 청주대 캠퍼스 식당 혼잡도 시스템---");
            System.out.println("1. 혼잡도 조회");
            System.out.println("2. 인원 수 수동 등록");
            System.out.println("3. 시간 경과 시뮬레이션");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showCrowdStatus();
                case 2 -> registerCrowdStatus();
                case 3 -> simulateFuture();
                case 4 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    static void showCrowdStatus() {
        System.out.println("\n[현재 식당 혼잡도]");
        for (restaurant p : restaurants) {
            p.printStatus();
        }
    }

    static void registerCrowdStatus() {
        showCrowdStatus();
        System.out.print("\n인원을 등록할 장소 번호 입력 (1 ~ " + restaurants.size() + ") > ");

        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= restaurants.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        System.out.print("추가할 인원 수 입력 > ");
        int add = scanner.nextInt();

        if (add < 0) {
            System.out.println("잘못된 인원 수 입니다.");
            return;

        }

        restaurants.get(choice).addPeople(add);
        System.out.println("인원 수 등록이 완료되었습니다!");
    }

    static void simulateFuture() {
        System.out.println("\n[현재 혼잡도 - 업데이트 전]");
        for (restaurant r : restaurants) {
            r.printStatus();
        }

        System.out.println("\n[혼잡도 업데이트 중... 40분 경과]\n");

        // 인원 업데이트
        restaurants.get(0).updatePeople(1);   // 아르떼 카페
        restaurants.get(1).updatePeople(14);  // 켐토 카페
        restaurants.get(2).updatePeople(10);  // 중앙도서관 카페
        restaurants.get(3).updatePeople(15);  // 학생회관 식당
        restaurants.get(4).updatePeople(10);  // 비즈니스대 식당
        restaurants.get(5).updatePeople(75);  // 짬뽕의 맛

        System.out.println("[업데이트 후 혼잡도]");
        for (restaurant r : restaurants) {
            r.printStatus();
        }
    }

}