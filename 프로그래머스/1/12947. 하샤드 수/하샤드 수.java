class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String intToString = "" + x;
        int sum = 0;
        for(int i = 0; i < intToString.length(); i++){
            sum += intToString.charAt(i) - '0';
        }
        if((x % sum) != 0){
            answer = false;
        }
        return answer;
    }
}