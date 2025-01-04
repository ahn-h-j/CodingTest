import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));
    }
    public String solution(String s) {
        String answer = "";
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();

        for(int index = 0; index < s.length(); index++){
            if(s.charAt(index) <= 'z' && s.charAt(index) >= 'a'){
                lower.add(s.charAt(index));
            } else{
                upper.add(s.charAt(index));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Character[] upperArray = upper.toArray(new Character[0]);
        Character[] lowerArray = lower.toArray(new Character[0]);

        Arrays.sort(upperArray, new Comparator<Character>(){
                @Override
                public int compare(Character o1, Character o2) {
                    return o2.compareTo(o1);
                }
            });

        Arrays.sort(lowerArray, new Comparator<Character>(){
                @Override
                public int compare(Character o1, Character o2) {
                    return o2.compareTo(o1);
                }
        });

        for(int i = 0; i < lowerArray.length; i++){
            stringBuilder.append(lowerArray[i]);
        }
        for(int i = 0; i < upperArray.length; i++){
            stringBuilder.append(upperArray[i]);
        }
        return stringBuilder.toString();
    }
}