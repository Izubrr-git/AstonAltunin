package lesson7.animals;

public class Bowl {
    private int food = 0;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public boolean decreaseFood(int decrement) {
        if (food >= decrement) {
            food -= decrement;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) food += amount;
        System.out.println("Добавлено " + amount + " единиц еды. Всего в миске: " + food);
    }

    public int getFood() {
        return food;
    }
}
