package lesson_11;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        String[] words = {"Hi", "Hello", "Home", "Hello", "Hi", "Hi", "Hello", "Hello", "Hello", "Home"};
        System.out.println("Задание 1: \n" +
                ArraysCalculator.getUniqueWords(words) +
                "\n" +
                ArraysCalculator.getWordCount(words)
        );

        //Задание 2
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.addPhoneNumber("Иванов", "123456789");
        phoneDictionary.addPhoneNumber("Иванов", "987654321");
        phoneDictionary.addPhoneNumber("Петров", "555555555");
        phoneDictionary.addPhoneNumber("Сидоров", "111111111");
        System.out.println("Задание 2: \n" +
                phoneDictionary.getPhoneNumbers("Иванов")
        );
    }
}
