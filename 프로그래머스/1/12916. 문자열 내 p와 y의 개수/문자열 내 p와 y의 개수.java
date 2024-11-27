class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String ch;
        int pcount = 0;
        int ycount = 0;
        for(int i = 0; i < s.length(); i++){
            ch = Character.toString(s.charAt(i));
            if(ch.equalsIgnoreCase("p")){
                pcount++;
            }else if(ch.equalsIgnoreCase("y")){
                ycount++;
            }
        }
        if(pcount != ycount){
            answer = false;
        }

        return answer;
    }
}