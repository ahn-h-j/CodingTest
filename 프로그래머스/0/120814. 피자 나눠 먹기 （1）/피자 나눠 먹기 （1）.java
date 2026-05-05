class Solution {
    public int solution(int n) {
        int remain = n % 7;
        int result = n / 7;
        if(remain > 0){
            result += 1;
        }
        return result;
    }
}