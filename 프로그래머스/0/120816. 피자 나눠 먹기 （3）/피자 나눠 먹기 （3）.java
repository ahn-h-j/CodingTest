class Solution {
    public int solution(int slice, int n) {
        int result = n / slice;
        int remain = n % slice;
        if(remain > 0){
            result++;
        }
        return result;
    }
}