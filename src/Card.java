public class Card {

    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int charisma;

    public Card(String name, int strength, int intelligence, int agility, int charisma){
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.charisma = charisma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", agility=" + agility +
                ", charisma=" + charisma +
                '}';
    }
}
