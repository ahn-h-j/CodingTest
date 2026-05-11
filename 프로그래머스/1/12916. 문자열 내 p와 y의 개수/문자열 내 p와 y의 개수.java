class Solution {
    boolean solution(String s) {
       boolean answer = true;

        int pCount = 0;
        int yCount = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'p' || ch == 'P'){
                pCount++;
            }
            if(ch == 'y' || ch == 'Y'){
                yCount++;
            }
        }
        if(pCount != yCount){
            answer = false;
        }
        return answer;
    }
}