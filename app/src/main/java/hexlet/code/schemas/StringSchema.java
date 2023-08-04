package hexlet.code.schemas;

public class StringSchema {

    private boolean isRequiredApplied;
    private boolean isMinLengthApplied;
    private boolean isContainsApplied;
    private int minLengthOfString;
    private String contentCheck;

    public StringSchema() {
        isRequiredApplied = false;
        isMinLengthApplied = false;
        isContainsApplied = false;
    }

    public void required() {
        isRequiredApplied = true;
    }

    public void minLength(int number) {
        isMinLengthApplied = true;
        minLengthOfString = number;
    }

    public void contains(String string) {
        isContainsApplied = true;
        contentCheck = string;
    }

    public boolean isValid(String content) {
        return isRequiredPassed(content) && isMinLengthPassed(content) && isContentsPassed(content);
    }

    private boolean isRequiredPassed(String content) {

        if (isRequiredApplied) {
            if (content == null) {
                return false;
            } else {
                return !content.equals("");
            }
        }

        return true;
    }

    private boolean isMinLengthPassed(String content) {

        if (isMinLengthApplied) {
            if (content == null) {
                return false;
            } else {
                return content.length() >= minLengthOfString;
            }
        }

        return true;
    }

    private boolean isContentsPassed(String content) {

        if (isContainsApplied) {
            if (content == null) {
                return false;
            } else {
                return content.contains(contentCheck);
            }
        }

        return true;
    }

}
