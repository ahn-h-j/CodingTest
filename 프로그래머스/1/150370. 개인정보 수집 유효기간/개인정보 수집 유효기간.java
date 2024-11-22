import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        // key : 약관 종류 / value : today - 유효기간
        Map<String, LocalDate> termsExpiryMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        for (int index = 0; index < terms.length; index++) {
            // today에서 유효기간을 뺀 기간을 구해서 맵에 넣음
            LocalDate date = LocalDate.parse(today, formatter);
            int condition = Integer.parseInt(terms[index].split(" ")[1]);
            LocalDate expireDate = date.minusMonths(condition);

            termsExpiryMap.put(terms[index].split(" ")[0], expireDate);
        }
        for (int index = 0; index < privacies.length; index++) {
            String[] input = privacies[index].split(" ");
            LocalDate privacyDate = LocalDate.parse(input[0], formatter);
            String privacyCondition = input[1];
            LocalDate expiryDate = termsExpiryMap.get(privacyCondition);

            if (expiryDate.compareTo(privacyDate) >= 0) {
                answerList.add(index + 1);
            }
        }

        // List<Integer> -> int[] 변환
        int[] answer = new int[answerList.size()];
        for (int index = 0; index < answerList.size(); index++) {
            answer[index] = answerList.get(index);
        }
        return answer;
    }
}
