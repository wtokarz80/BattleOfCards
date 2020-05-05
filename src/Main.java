public class Main {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
//        System.out.println(xmlParser.getDeck().getCardList().toString());
        xmlParser.getDeck().shuffle();
//        System.out.println(xmlParser.getDeck().getCardList().toString());
        xmlParser.getDeck().dealCards(6);
        System.out.println(xmlParser.getDeck().getHand());
        System.out.println(xmlParser.getDeck().getCardList().toString());



    }
}
