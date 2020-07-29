package ru.officelibrary.officelibrary.validator;

public abstract class AbstractValidator {

    private final int minLength = 3;
    private final int maxLength = 40;

    protected static String patternForName = "[a-zA-zА-Яа-я\\-]+";

    public String getPatternForName() {
        return patternForName;
    }

    public void setPatternForName(String patternForName) {
        AbstractValidator.patternForName = patternForName;
    }

    protected boolean checkName(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        } else {
            if (string.length() < minLength || string.length() > maxLength) {
                return false;
            }
            return string.matches(patternForName);
        }
    }

    protected boolean checkPatName(String string) {
        if (string != null && !string.isEmpty()) {
            if (string.length() < minLength || string.length() > maxLength) {
                return false;
            }
            return string.matches(patternForName);
        }
        return true;
    }
}
