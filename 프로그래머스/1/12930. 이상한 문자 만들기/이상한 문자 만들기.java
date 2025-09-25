public class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    answer.append(Character.toUpperCase(word.charAt(j)));
                } else {
                    answer.append(Character.toLowerCase(word.charAt(j)));
                }
            }

            if (i < words.length - 1) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}