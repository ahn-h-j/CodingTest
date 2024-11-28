class Solution {
    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);

        convertToLowerCase(sb);
        removeInvalidCharacters(sb);
        replaceMultipleDots(sb);
        trimEdgeDots(sb);
        replaceEmptyWithA(sb);
        truncateTo15Chars(sb);
        padToThreeChars(sb);

        return sb.toString();
    }

    public static void convertToLowerCase(StringBuilder sb) {
        for (int index = 0; index < sb.length(); index++) {
            sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));
        }
    }

    public static void removeInvalidCharacters(StringBuilder sb) {
        for (int index = 0; index < sb.length(); index++) {
            char word = sb.charAt(index);
            if (!(Character.isLowerCase(word) || Character.isDigit(word) ||
                    word == '-' || word == '_' || word == '.')) {
                sb.deleteCharAt(index);
                index--;
            }
        }
    }

    public static void replaceMultipleDots(StringBuilder sb) {
        for (int index = 0; index < sb.length() - 1; index++) {
            if (sb.charAt(index) == '.' && sb.charAt(index + 1) == '.') {
                sb.deleteCharAt(index);
                index--;
            }
        }
    }

    public static void trimEdgeDots(StringBuilder sb) {
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void replaceEmptyWithA(StringBuilder sb) {
        if (sb.length() == 0) {
            sb.append("a");
        }
    }

    public static void truncateTo15Chars(StringBuilder sb) {
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
        }
        trimEdgeDots(sb); // 보장된 끝부분 `.` 처리
    }

    public static void padToThreeChars(StringBuilder sb) {
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
    }
}
