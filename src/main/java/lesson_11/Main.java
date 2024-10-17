package lesson_11;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        String[] words = {"Hi", "Hello", "Home", "Hello", "Hi", "Hi", "Hello", "Hello", "Hello", "Home"};
        Map<String, Integer> wordCounts = UniqueWordsCalculator.getWordCount(words);
        System.out.println("Задание 1: Уникальные слова и их количество");
        System.out.println(wordCounts.keySet()); // Уникальные слова
        System.out.println(wordCounts); // Количество каждого слова

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
