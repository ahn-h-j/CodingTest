class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for(int outerIndex = 0; outerIndex < arr1.length; outerIndex++){
            for(int innerIndex = 0; innerIndex < arr1[0].length; innerIndex++){
                answer[outerIndex][innerIndex] = arr1[outerIndex][innerIndex] + arr2[outerIndex][innerIndex];
            }
        }
            return answer;
    }
}