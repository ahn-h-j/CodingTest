class Solution {
    public String solution(String my_string, String letter) {
         StringBuilder sb = new StringBuilder();
        for (char a : my_string.toCharArray() ) {
            if(a != letter.charAt(0)){
                sb.append(a);
            }
        }
        return sb.toString();
    }
}