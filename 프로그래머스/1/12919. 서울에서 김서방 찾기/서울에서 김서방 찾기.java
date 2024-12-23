
class Solution {
    public String solution(String[] seoul) {
        for(int index = 0; index < seoul.length; index++){
            if(seoul[index].equals("Kim")){
                return "김서방은 " + index + "에 있다"; 
            }
        }
        return " ";
    }
}