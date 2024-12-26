class Solution {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; index < n; index++){
            if (index % 2 == 0){
                stringBuilder.append("수");
            } else{
                stringBuilder.append("박");
            }
        }
        return stringBuilder.toString();
    }
}