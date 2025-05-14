import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //청주대에서 내가 불편한 것들.....


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






    }
}