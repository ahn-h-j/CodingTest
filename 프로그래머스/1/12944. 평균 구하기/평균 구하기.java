class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double accumulate = 0.0;
        for(double num : arr){
            accumulate += num;
            answer = accumulate / arr.length;
        }
            
        return answer;
    }
}