package Domains;

public class Validator {
    public static void validateRestartCommand(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2만 입력해야 합니다.");
        }
    }

    public static void validateInput(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 숫자여야 합니다.");
        }
        if (hasDuplicate(input)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("^[1-9]+$"); // 1-9 사이의 숫자인지 확인
    }

    private static boolean hasDuplicate(String str) {
        return str.chars().distinct().count() != str.length();
    }
}