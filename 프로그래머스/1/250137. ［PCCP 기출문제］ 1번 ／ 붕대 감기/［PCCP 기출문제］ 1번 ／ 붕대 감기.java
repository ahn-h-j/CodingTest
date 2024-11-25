class Solution {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int castTime = bandage[0];
        int HealPerSecond = bandage[1];
        int extraHeal = bandage[2];
        
        int healthMax = health;
        int previousAttack = 0;

        for(int i = 0; i < attacks.length; i++){
            int currentAttack = attacks[i][0];
            int attackGap = currentAttack - previousAttack - 1;

            if(attackGap > 0){
                health += HealPerSecond * attackGap;
                health += (attackGap / castTime) * extraHeal;
                if(health > healthMax){
                    health = healthMax;
                }
            }
            health -= attacks[i][1];
            if(health <= 0) return -1;

            previousAttack = currentAttack;

        }
        return health;
    }
}