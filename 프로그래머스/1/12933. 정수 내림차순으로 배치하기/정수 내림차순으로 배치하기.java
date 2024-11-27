import java.util.Arrays;
import java.util.Collections;
public class Solution {
    public long solution(long n) {
        String nStr = String.valueOf(n);
        Character[] chars = new Character[nStr.length()];
        for (int i = 0; i < nStr.length(); i++) {
            chars[i] = nStr.charAt(i);
        }
        Arrays.sort(chars, Collections.reverseOrder());
        String sortedStr = "";
        for (Character c : chars) {
            sortedStr += c;
        }
        
        // 문자열을 정수로 변환하여 반환
        return Long.parseLong(sortedStr);
    }
}
