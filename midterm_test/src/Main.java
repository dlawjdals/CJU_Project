
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static class restaurant {
        String name;
        int max_people;
        int people;

        restaurant(String name) {
            this.name = name;
            this.people = 0;
            this.max_people = 0;
        }

        String getCrowdLevelText() {
            double usage = (double) people / max_people;

            if (usage < 0.3) return "여유";
            else if (usage >= 0.5 && usage < 0.7) return "약간 혼잡";
            else if (usage >= 0.7 && max_people < people) return "매우 혼잡";
            else return "매우 혼잡 / 대기 인원: " + (max_people - people) + "명";
        }
    }

    static ArrayList<restaurant> restaurants = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        restaurants.add(new restaurant("아르떼 카페"));
        restaurants.add(new restaurant("학생회관 식당"));
        restaurants.add(new restaurant("비즈니스대 식당"));
        restaurants.add(new restaurant("켐토 카페"));

        while (true) {
            System.out.println("\n--- 청주대 캠퍼스 식당 혼잡도 시스템---");
            System.out.println("1. 혼잡도 조회");
            System.out.println("2. 혼잡도 등록");
            System.out.println("3. 종료");
            System.out.println("메뉴 선택");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showCrowdStatus();
                case 2 -> registerCrowdStatus();
                case 3 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    static void showCrowdStatus() {
        System.out.println("\n[현재 식당 혼잡도]");
        for (int i = 0; i < restaurants.size(); i++) {
            restaurant dp = restaurants.get(i);
            System.out.printf("%d. %s - %s\n", i + 1, dp.name, dp.getCrowdLevelText());
        }
    }

    static void registerCrowdStatus() {
        showCrowdStatus();
        System.out.println("혼잡도를 등록할 식당 번호 선택 > ");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= restaurants.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        System.out.println("혼잡도 입력 (0: 여유, 1: 보통, 2: 혼잡)");
        int level = scanner.nextInt();

        if (level < 0 || level > 2) {
            System.out.println("잘못된 혼잡도입니다.");
            return;

        }

        restaurants.get(choice).people += level;
        System.out.println("혼잡도 등록이 완료되었습니다!");
    }



}