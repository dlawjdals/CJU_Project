public class restaurant {
        String name;
        int max_people;
        int people;

        restaurant(String name, int max_people, int people) {
            this.name = name;
            this.max_people = max_people;
            this.people = people;
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
