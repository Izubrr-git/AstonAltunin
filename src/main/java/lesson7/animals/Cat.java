package lesson7.animals;

public class Cat extends AbstractAnimal {
    private static int catCount = 0;
    private boolean saturation = true;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSaturated() {
        return saturation;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            saturation = true;
            System.out.println(name + " поел " + amount + " единиц еды и наелся.");
        } else {
            System.out.println(name + " не смог поесть. В миске недостаточно еды.");
        }
    }

    @Override
    public void swim (int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}
