package lesson_11;

import java.util.*;

public class ArraysCalculator {
    public static Set<String> getUniqueWords(String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }
    public static Map<String, Integer> getWordCount(String[] words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }
}
