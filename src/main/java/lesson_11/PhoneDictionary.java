package lesson_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneDictionary {
    private HashMap<String, List<String>> dictionary =new HashMap<>();

    public void addPhoneNumber(String lastName, String phoneNumber) {
        if(dictionary.containsKey(lastName)) {
            dictionary.get(lastName).add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            dictionary.put(lastName, phoneNumbers);
        }
    }

    public List<String> getPhoneNumbers(String lastName) {
        return dictionary.get(lastName);
    }
}
