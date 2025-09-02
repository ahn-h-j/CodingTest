
public class Solution {
    public String solution(String s, int n) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char target = charArray[i];
            if(target == ' '){
            }else if(target + n > 122){
                charArray[i] = (char) (target + n - 26);
            }else if(target + n > 90 && target < 97){
                charArray[i] = (char) (target + n - 26);
            }
            else{
                charArray[i] = (char) (target + n);
            }
        }
        return new String(charArray);
    }
}

