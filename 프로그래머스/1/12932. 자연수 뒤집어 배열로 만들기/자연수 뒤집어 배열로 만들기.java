class Solution {
    public int[] solution(long n) {
        int length = (int)(Math.log10(n)+1);
        int[] answer = new int[length];
        long temp;
        for(int i = 0; i < answer.length; i++){
            temp = n % 10;
            answer[i] = (int)temp;
            n /= 10;
        }
        return answer;
    }
}