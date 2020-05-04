import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {

    private Deck deck;
    private Document doc;


    XMLParser(){
        deck = new Deck();
        loadXmlDocument();
        documentParse();

    }

    public Deck getDeck() {
        return deck;
    }

    protected void loadXmlDocument(){
        try {
            File file = new File("cards.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            this.doc = dBuilder.parse(file);
            this.doc.getDocumentElement().normalize();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void documentParse(){
        System.out.println("Root: " + doc.getDocumentElement().getNodeName());
        NodeList cards = doc.getElementsByTagName("Card");
        System.out.println("Number of cards: " + cards.getLength());
        System.out.println();

        for (int i = 0; i < cards.getLength(); i++){
            Node node = cards.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            Element element = (Element) node;
            String cardName = element.getAttribute("name");

            NodeList attributes = element.getElementsByTagName("Attr");

            Node attStrNode = attributes.item(0);
            Element attrStrElement = (Element) attStrNode;
            int strength = Integer.parseInt(attrStrElement.getTextContent());

            Node attIntNode = attributes.item(1);
            Element attrIntElement = (Element) attIntNode;
            int intelligence = Integer.parseInt(attrIntElement.getTextContent());

            Node attAgilNode = attributes.item(2);
            Element attrAgilElement = (Element) attAgilNode;
            int agility = Integer.parseInt(attrAgilElement.getTextContent());

            Node attCharNode = attributes.item(3);
            Element attrCharElement = (Element) attCharNode;
            int charisma = Integer.parseInt(attrCharElement.getTextContent());

            Card card  = new Card(cardName, strength, intelligence, agility, charisma);
            deck.addCard(card);
        }
    }
}
