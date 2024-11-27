class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int small = 0, big = 0;
        if(a == b){
            answer = a;
        }
        else if(a > b){
            big = a;
            small = b;
        }
        else{
            big = b;
            small = a;
        }
        for(; small <= big; small++){
            answer += small;
        }
        return answer;
    }
}