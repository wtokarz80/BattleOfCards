import com.jakewharton.fliptables.FlipTable;

public class Card {

    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int charisma;

    public Card(String name, int strength, int intelligence, int agility, int charisma) {
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
        String[] headers = {name, "(-_^)"};
        String[][] data = {
                {"(1) Strength", String.valueOf(strength)},
                {"(2) Intelligence", String.valueOf(intelligence)},
                {"(3) Agility", String.valueOf(agility)},
                {"(4) Charisma", String.valueOf(charisma)}
        };
        return
                FlipTable.of(headers, data);
    }

    public String toStringCard() {
        String output = "";
        output += "-------------------\n";
        output += String.format("(1) STRENGTH: %-5d\n", strength);
        output += String.format("(2) INTELLIGENCE: %-5d\n", intelligence);
        output += String.format("(3) AGILITY: %-5d\n", agility);
        output += String.format("(4) CHARISMA: %-5d\n", charisma);
        output += "-------------------\n";

        return output;
    }
}
