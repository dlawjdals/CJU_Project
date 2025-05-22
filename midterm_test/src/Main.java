import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static class restaurant {
        String name;
        int people;

        restaurant(String name) {
            this.name = name;
            this.crowdLevel = 0;
        }

        String getCrowdLevelText() {
            return switch (crowdLevel) {
                case 0 -> "여유";
                case 1 -> "보통";
                case 2 -> "혼잡";
                default -> "정보 없음";
            };
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



        }






    }
}