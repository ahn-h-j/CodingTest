import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,3,2,1};
        System.out.println(Arrays.toString(solution.solution(arr)));
    }
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        int answerIndex = 0;
        
        if(arr.length <= 1){
            return new int[]{-1};
        }

        for(int index = 0; index < arr.length; index++){
            if(arr[index] < min){
                min = arr[index];
            }
        }
        for(int num : arr){
            if(num != min){
                answer[answerIndex++] = num;
            }
        }

        return answer;
    }
}