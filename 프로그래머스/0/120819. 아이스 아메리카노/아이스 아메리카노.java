class Solution {
    public int[] solution(int money) {
      int amount = money / 5500;    
        int remain = money - 5500 * amount;
        return new int[]{amount, remain};
    }
}