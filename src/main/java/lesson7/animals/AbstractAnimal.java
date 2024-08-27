package lesson7.animals;

public abstract class AbstractAnimal {
    private static int animalCount = 0;
    public String name;
    protected int runLimit;
    protected int swimLimit;

    public AbstractAnimal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " " + "пробежал " + distance + " метров");
        } else {
            System.out.println(name + " " + "не может пробежать " + distance + " метров. Максимум: " + runLimit + " метров");
        }
    }

    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println(name + " не может проплыть " + distance + " метров. Максимум: " + swimLimit + " метров");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}