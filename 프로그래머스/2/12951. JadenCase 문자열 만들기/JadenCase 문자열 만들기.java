class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("3people unFollowed me"));
        System.out.println(solution.solution("for the last week"));
        //입력값 〉   "  for the what  1what  "
        System.out.println(solution.solution(" for the what 1what  "));
        //"1HELLO 1WORLD"
        System.out.println(solution.solution("1HELLO 1WORLD"));

    }
    public String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for(int index = 0; index < s.length(); index++){
            if(Character.isDigit(s.charAt(index)) && isFirst){
                stringBuilder.append(s.charAt(index));
                isFirst = false;
            } else if(Character.isAlphabetic(s.charAt(index)) && isFirst ){
                stringBuilder.append(Character.toUpperCase(s.charAt(index)));
                isFirst = false;
            } else if (Character.isAlphabetic(s.charAt(index)) && !isFirst) {
                stringBuilder.append(Character.toLowerCase(s.charAt(index)));
            } else{
                stringBuilder.append(s.charAt(index));
                isFirst = true;
            }
        }
        return stringBuilder.toString();
    }
}