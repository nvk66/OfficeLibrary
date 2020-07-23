package ru.officelibrary.officelibrary.validator;

public abstract class AbstractValidator {
    protected static String patternForName = "[a-zA-zА-Яа-я\\-]{3,40}";

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
            if (string.length() < 2 || string.length() > 40) {
                return false;
            }
            return string.matches(patternForName);
        }
    }

    protected boolean checkPatName(String string) {
        if (string != null && !string.isEmpty()) {
            return string.matches(patternForName);
        }
        return true;
    }
}
