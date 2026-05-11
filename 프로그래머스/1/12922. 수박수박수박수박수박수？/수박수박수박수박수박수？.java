class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int a = n / 2;
        int b = n % 2;
        for(int i = 0; i < a; i++){
            sb.append("수박");
        }
        if(b != 0){
            sb.append("수");
        }
        return sb.toString();
    }
}