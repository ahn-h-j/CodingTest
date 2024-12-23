class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6));
        System.out.println(solution.solution(626331));
    }
    public int solution(int num) {
        int answer = 0;
        long longNum = num;
        while(true){
            if(longNum == 1){
                break;
            }
            if(answer >= 500){
                answer = -1;
                break;
            }
            if(longNum % 2 == 0){
                longNum /= 2;
            }else{
                longNum *= 3;
                longNum += 1;
                longNum /= 2;
                answer++;
            }
            answer++;
        }

        return answer;
    }
}