class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int outerIndex = left; outerIndex <= right; outerIndex++){
            int count = 0;
            for(int innerIndex = 1; innerIndex <= outerIndex; innerIndex++){
                if(outerIndex % innerIndex == 0){
                        count++;
                }
            }
            if(count % 2 == 0){
                answer += outerIndex;
            }else{
                answer -= outerIndex;
            }
        }
        return answer;
    }
}