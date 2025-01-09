import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        for(int alphabet = 'A'; alphabet <= 'Z'; alphabet++){
            dictionary.add(Character.toString(alphabet));
        }

        boolean isExist = true;
        for(int index = 0; index < msg.length(); index++){

            String words = Character.toString(msg.charAt(index));
            int temp = 0;

            while(isExist){
                if(dictionary.contains(words)){
                    isExist = true;
                    temp = dictionary.indexOf(words) + 1;
                    index++;
                }else{
                    isExist = false;
                    dictionary.add(words);
                    index--;
                    break;
                }
                if(index < msg.length()){
                    words += Character.toString(msg.charAt(index));
                } else{
                    break;
                }
            }
            isExist = true;
            answer.add(temp);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}