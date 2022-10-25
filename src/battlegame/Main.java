package battlegame;

import models.Character;
import models.Elf;
import models.Human;
import models.Orc;

public class Main {

    private int numberOfFights;

    public static void main(String[] args) {
        game(10);

    }
    public static Character[] generateRandomCharacters (int characterNumber) {
            Character[] characters = new Character[characterNumber];


            for(int i = 0; i < characters.length; i++) {
                int randomRaceId = (int) (Math.random() * Character.NUMBER_OF_RACES);
                int randomRoleId = (int) (Math.random() * Character.NUMBER_OF_ROLES);

                Character character;
                String name = "Fighter " + i + " : ";
                switch(randomRaceId) {
                    case Character.ORC_ID:
                        character = new Orc(randomRoleId, name);
                        break;
                    case Character.HUMAN_ID:
                        character = new Human(randomRoleId, name);
                        break;
                    case Character.ELF_ID:
                        character = new Elf(randomRoleId, name);
                        break;
                    default:
                        character = new Elf(randomRoleId, name);
                }

                characters[i] = character;
            }
            return characters;
    }

    public static void game(int numberOfFights){
        Character[] arena = generateRandomCharacters(10);
        for (int i = 0; i < numberOfFights; i++) {
            int randomFighterIndex1 = (int) (Math.random() * arena.length);
            int randomFighterIndex2;
            do {
                randomFighterIndex2 = (int) (Math.random() * arena.length);
            } while (randomFighterIndex1 == randomFighterIndex2);

            Character fighter1 = arena[randomFighterIndex1];
            Character fighter2 = arena[randomFighterIndex2];

            System.out.println("\n Combat : " + (i + 1));
            fighter1.shout();
            fighter1.displayDetails();
            fighter2.shout();
            fighter2.displayDetails();
            System.out.println("COMBAT EN COURS");
            fight(fighter1, fighter2);

            fighter1.displayDetails();
            fighter2.displayDetails();
        }
    }

    public static void fight(Character fighter1, Character fighter2) {
            Character[] fighters = new Character[]{fighter1, fighter2};

            for(int i = 0; i < fighters.length; i++) {
                Character f1 = fighters[i];
                Character f2;
                if(i == 0) {
                    f2 = fighters[i + 1];
                } else {
                    f2 = fighters[i - 1];
                }

                if(f1.getRoleId() == Character.STRIKER_ID ) {
                    if(f1 instanceof Orc) {
                        ((Orc) f1).attack(f2);
                    }
                    if(f1 instanceof Human) {
                        ((Human) f1).attack(f2);
                    }
                    if(f1 instanceof Elf) {
                        ((Elf) f1).attack(f2);
                    }
                } else if(f1.getRoleId() == Character.HEALER_ID) {
                    if(f1 instanceof Orc) {
                        ((Orc) f1).heal();
                    }
                    if(f1 instanceof Human) {
                        ((Human) f1).heal();
                    }
                    if(f1 instanceof Elf) {
                        ((Elf) f1).heal();
                    }
                }
            }
    }

}
