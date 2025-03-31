package utility.exceptions;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@"
            + "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
