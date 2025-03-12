class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for(int i = 0; i < count; i++){
            sum += price * (i + 1);
        }
        long result = money - sum;
        if(result >= 0){
            answer = 0;
        }else{
            answer = Math.abs(result);
        }
        return answer;
    }
}