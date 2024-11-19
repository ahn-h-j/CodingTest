class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        int[] binaryMap1;
        int[] binaryMap2;

        for(int index = 0; index < n; index++){
            binaryMap1 = binary(n,arr1[index]);
            binaryMap2 = binary(n,arr2[index]);
            for(int i = 0; i < n; i++){
                if((binaryMap1[i] | binaryMap2[i]) == 1){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[index] = sb.toString();
            sb.delete(0,n);
        }
        return answer;
    }
     public static int[] binary(int n, int num){
        int[] binary = new int[n];
        for(int i = n -1; i >= 0; i--){
            binary[i] = num % 2;
            num /= 2;
        }
        return binary;
    }
}