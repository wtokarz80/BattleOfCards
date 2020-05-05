import java.util.Iterator;
import java.util.List;

public class Table {
    private List<Card> cardList;

    public Table() {
        Player player1 = Ui.createPlayer(true);
        Player player2 = Ui.createPlayer(false);         //gracze siadają do stołu

        XMLParser xmlParser = new XMLParser();
        Deck newDeck = xmlParser.getDeck();                 //krupier wyciąga karty na stół

        newDeck.shuffle();                                  //krupier tasuje karty

        Hand player1Hand = new Hand();                      //gracze wyciagają ręce
        Hand player2Hand = new Hand();



    for(int s = 0; s<3; s++) {                           //krupier rozdaje karty raz jednemu raz drugiemu
        dealOneCard(newDeck, player1Hand);
        dealOneCard(newDeck, player2Hand);
}

        player1.setHand(player1Hand);
        player2.setHand(player2Hand);
        System.out.println(player1.getHand().toString());
        System.out.println(player1.showCurrentCard());
        System.out.println("I want to play by: " + player1.chooseStatistic());
        System.out.println();

        System.out.println(player2.getHand().toString());
        System.out.println(player2.showCurrentCard());
        System.out.println("I want to play by: " + player2.chooseStatistic());



    }

    public Hand dealOneCard(Deck deck, Hand hand){
            hand.addCard(deck.getCardByIndex(0));
            deck.removeCard(0);
        return hand;
    }

}
