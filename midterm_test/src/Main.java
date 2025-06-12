
import java.util.ArrayList;
import java.util.Scanner;

class restaurant {
    String name;
    int max_people;
    int people;

    restaurant(String name, int max_people, int people) {
        this.name = name;
        this.max_people = max_people;
        this.people = people;
    }

    public restaurant(String name) {
    }

    String getCrowdLevelText() {
        double ratio = (double) people / max_people;
        if (people > max_people) {
            int waiting = people - max_people;
            return "매우 혼잡 / 대기 인원: " + waiting + "명";
        } else if (ratio >= 0.7) {
            return "매우 혼잡";
        } else if (ratio >= 0.5) {
            return "약간 혼잡";
        } else {
            return "여유";
        }
    }

    void printStatus() {
        System.out.printf("%s (%d/%d): %s\n", name, people, max_people, getCrowdLevelText());
    }

    void updatePeople(int newPeople) {
        this.people += newPeople;
    }

    void addPeople(int amount) {
        this.people += amount;
    }
}
public class Main {

    static ArrayList<restaurant> restaurants = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        restaurants.add(new restaurant("아르떼 카페", 10, 13));
        restaurants.add(new restaurant("켐토 카페", 15, 5));
        restaurants.add(new restaurant("중앙도서관 카페", 20, 21));
        restaurants.add(new restaurant("학생회관 식당", 70, 38));
        restaurants.add(new restaurant("비즈니스대 식당", 50, 49));
        restaurants.add(new restaurant("짬봉의 맛", 30, 5));

        while (true) {
            System.out.println("\n--- 청주대 캠퍼스 식당 혼잡도 시스템---");
            System.out.println("1. 혼잡도 조회");
            System.out.println("2. 인원 수 수동 등록");
            System.out.println("3. 시간 경과 시뮬레이션");
            System.out.println("4. 종료");
            System.out.println("메뉴 선택");

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

        restaurants.get(level).addPeople(level);
        System.out.println("혼잡도 등록이 완료되었습니다!");

        static void simulateFuture() {
            System.out.println("\n 40분 후 혼잡도 업데이트 중...");

            restaurants.get(0).updatePeople(1);
            restaurants.get(1).updatePeople(14);
            restaurants.get(2).updatePeople(10);
            restaurants.get(3).updatePeople(15);
            restaurants.get(4).updatePeople(10);
            restaurants.get(5).updatePeople(75);

            showCrowdStatus();

        }
    }



}