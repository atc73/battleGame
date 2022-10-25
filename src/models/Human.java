package models;

public class Human extends Character implements Healer, Striker{

    public Human(int roleId) {
        maxHealth = 12;
        healingPower = 2;
        damagePower = 2;
        health = maxHealth;
        this.roleId = roleId;
    }

    @Override
    public void shout() {
        System.out.println("OUUUUUU");
    }

    @Override
    public void heal() {
        if(health <= maxHealth - healingPower){
            setHealth(health + healingPower);
        }
    }

    @Override
    public String getRaceString() {
        return "humain";
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.health - damagePower);
    }
}
