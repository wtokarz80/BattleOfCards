public class Main {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        System.out.println(xmlParser.getDeck().getCardList().toString());
    }

}
