public class more_problem1 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int currentTime = 0;
        int attackIndex = 0;
        int healCount = 0;
        while(attackIndex < attacks.length){
            currentTime++;
            if(attacks[attackIndex][0] == currentTime){
                currentHealth -= attacks[attackIndex][1];
                healCount = 0;
                attackIndex++;
                if(currentHealth<=0){
                    return -1;
                }
                continue;
            }
            currentHealth += bandage[1];
            healCount++;
            if(healCount >= bandage[0] ){
                currentHealth += bandage[2];
            }
            if(currentHealth >= health){
                currentHealth = health;
            }
        }
        return currentHealth;
    }
}
