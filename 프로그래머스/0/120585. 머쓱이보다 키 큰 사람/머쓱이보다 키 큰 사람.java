class Solution {
    public int solution(int[] array, int height) {
        int count = 0;
        for(int a : array){
            if(a > height){
                count++;
            }
        }
        return count;
    }
}