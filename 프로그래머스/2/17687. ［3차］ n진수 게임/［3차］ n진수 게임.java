import java.io.PrintStream;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        String result = calBase(n, t, m);
        System.out.println(result);
        for(int i = p - 1; i < result.length(); i+=m){
            if(answer.length() == t){
                break;
            }
            answer.append(result.charAt(i));
        }
        return String.valueOf(answer);
    }
    public String calBase(int n, int t, int m){
        StringBuilder result = new StringBuilder();
        int len = t * m;
        int num = 0;

        while(len >= 0){
            StringBuilder tempResult = new StringBuilder();
            tempResult.append(Integer.toString(num++, n).toUpperCase()); // n진수 변환 (대문자 변환)
            len -= tempResult.length();
            result.append(tempResult);
        }
        return String.valueOf(result);
    }
}