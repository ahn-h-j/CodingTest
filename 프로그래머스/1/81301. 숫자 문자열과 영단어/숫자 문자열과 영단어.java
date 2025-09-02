class Solution {
        public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < words.length; i++) {
            if(s.contains(words[i])){
                s = s.replaceFirst(words[i], numbers[i]);
                i = -1;
            }
        }
        return Integer.parseInt(s);
    }
}