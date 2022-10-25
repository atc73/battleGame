package models;

public class Elf extends Character implements Striker, Healer {


    public Elf(int roleId, String name) {
        maxHealth = 14;
        healingPower = 2;
        damagePower = 2;
        health = maxHealth;
        this.roleId = roleId;
        this.name = name;
    }

    @Override
    public void shout() {
        System.out.println("FIUUUUUUUUUUUU");
    }

    @Override
    public void heal() {
        if(health <= maxHealth - healingPower){
            setHealth(health + healingPower);
        }
    }

    @Override
    public String getRaceString() {
        return "Elf";
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.health - damagePower);
    }
}
