class Solution {
    public String solution(String phone_number) {
        StringBuilder phone = new StringBuilder();
        for(int index = 0; index < phone_number.length() - 4; index++){
            phone.append("*");
        }
        phone.append(phone_number.substring(phone_number.length() - 4));
        return phone.toString();
    }
}