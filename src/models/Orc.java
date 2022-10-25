package models;

public class Orc extends Character implements Healer, Striker {

    public Orc(int roleId) {
        maxHealth = 10;
        healingPower = 3;
        damagePower = 3;
        health = maxHealth;
        this.roleId = roleId;
    }

    @Override
    public void shout() {
        System.out.println("RIIIIIIIIII");
    }

    @Override
    public String getRaceString() {
        return "orque";
    }


    @Override
    public void heal() {
        if(health <= maxHealth - healingPower){
            setHealth(health + healingPower);
        }
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.health - damagePower);
    }

}
