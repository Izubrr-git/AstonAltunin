package lesson6_1;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Attraction> attractions;

    public Park() {
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, double price) {
        attractions.add(new Park.Attraction(name, price));
    }

    public List<String> getAttractionNames() {
        List<String> names = new ArrayList<>();
        for (Attraction attraction : attractions) {
            names.add(attraction.getName());
        }
        return names;
    }

    public double getAttractionPrice(String name) {
        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(name)) {
                return attraction.getPrice();
            }
        }
        return -1; // Возвращаем -1, если аттракцион не найден
    }

    private static class Attraction {
        private String name;
        private double price;

        public Attraction(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
