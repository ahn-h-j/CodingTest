class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for(int index = 0; index < absolutes.length; index++){
            if(signs[index]){
                sum += absolutes[index];
            }else{
                sum -= absolutes[index];
            }
        }
        return sum;
    }
}