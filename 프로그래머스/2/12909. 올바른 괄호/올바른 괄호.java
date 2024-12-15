import java.util.Stack;

class Solution {
     boolean solution(String s){
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int index = 0; index < s.length(); index++){
            char input = s.charAt(index);
            if(input == '('){
                stack.push(input);
            } else {
                if(!stack.isEmpty() && stack.pop() == '('){
                }else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return answer;
    }
}