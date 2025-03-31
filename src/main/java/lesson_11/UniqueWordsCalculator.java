package lesson_11;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordsCalculator {
    public static Map<String, Integer> getWordCount(String[] words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }
}
