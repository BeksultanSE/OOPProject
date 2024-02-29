package Validator;

import java.util.function.IntPredicate;

public class InputValidator {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        int uppercaseCounter = 0, lowercaseCounter = 0, specialCounter = 0, digitCounter = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            uppercaseCounter += Character.isUpperCase(c) ? 1 : 0;
            lowercaseCounter += Character.isLowerCase(c) ? 1 : 0;
            digitCounter += Character.isDigit(c) ? 1 : 0;
            specialCounter += (c >= 33 && c <= 46) || c == 64 ? 1 : 0;
        }

        IntPredicate hasUppercase = x -> x > 0;
        IntPredicate hasLowercase = x -> x > 0;
        IntPredicate hasSpecial = x -> x > 0;
        IntPredicate hasDigit = x -> x > 0;

        return hasUppercase.test(uppercaseCounter) &&
                hasLowercase.test(lowercaseCounter) &&
                hasSpecial.test(specialCounter) &&
                hasDigit.test(digitCounter);
    }
}