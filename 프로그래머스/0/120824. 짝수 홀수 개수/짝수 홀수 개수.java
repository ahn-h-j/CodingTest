class Solution {
    public int[] solution(int[] num_list) {
        int even = 0;
        int odd = 0;
        for(int a : num_list){
            if(a % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return new int[]{even,odd};
    }
}