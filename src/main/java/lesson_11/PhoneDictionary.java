package lesson_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneDictionary {
    private HashMap<String, List<String>> dictionary =new HashMap<>();

    public void addPhoneNumber(String lastName, String phoneNumber) {
        dictionary.putIfAbsent(lastName, new ArrayList<>());
        dictionary.get(lastName).add(phoneNumber);
    }

    public List<String> getPhoneNumbers(String lastName) {
        return dictionary.get(lastName);
    }
}
