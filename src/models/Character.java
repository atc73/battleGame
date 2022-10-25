package models;

public abstract class Character {
    protected int health;
    protected int damage;

    protected int maxHealth;

    protected int healingPower;

    protected int damagePower;

    protected int roleId;

    //Nombre total de races
    public static final int NUMBER_OF_RACES = 3;

    // Gestion de la race
    public static final int ORC_ID = 0;
    public static final int HUMAN_ID = 1;
    public static final int ELF_ID = 2;

    //Nobmre total de rôles
    public static final int NUMBER_OF_ROLES = 2;

    //Gestion des rôles
    public static final String[] ROLES_STRING = new String[]{"Striker", "Healer"};
    public static final int STRIKER_ID = 0;
    public static final int HEALER_ID = 1;



    public abstract void shout();

    public int getHealth() {
        return health;
    }

    public void displayDetails () {
        System.out.print("Je suis un " + getRaceString() + " - ");
        System.out.println("Je suis un " + getRoleString());
        System.out.println("J'ai " + this.getHealth() + " PV");
    }

    public abstract String getRaceString();

    public String getRoleString() {
        return ROLES_STRING[this.getRoleId()];
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

/*    static public int getNumberOfRaces() {
        return NUMBER_OF_RACES;
    }

    static public int getNumberOfRoles() {
        return NUMBER_OF_ROLES;
    }

    static public int getOrcId() {
        return ORC_ID;
    }

    static public int getHumanId() {
        return HUMAN_ID;
    }*/
}
