class Solution {
    public double solution(int[] numbers) {
        int sum = 0;
        for(int a : numbers){
           sum += a;
       }
        return (double)sum / numbers.length;
    }
}