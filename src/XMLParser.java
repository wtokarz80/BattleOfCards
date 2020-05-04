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
//            System.out.println(cardName);

            NodeList attributes = element.getElementsByTagName("Attr");
            int strength = 0;
            int intelligence = 0;
            int agility = 0;
            int charisma = 0;
            for(int j = 0; j < attributes.getLength(); j++){
                if (j == 0){
                    Node attNode = attributes.item(j);
                    Element attrElement = (Element) attNode;
                    strength = Integer.parseInt(attrElement.getTextContent());
//                    System.out.println(strength);
                } else if(j == 1){
                    Node attNode = attributes.item(j);
                    Element attrElement = (Element) attNode;
                    intelligence = Integer.parseInt( attrElement.getTextContent());
//                    System.out.println(intelligence);
                } else if (j == 2){
                    Node attNode = attributes.item(j);
                    Element attrElement = (Element) attNode;
                    agility = Integer.parseInt(attrElement.getTextContent());
//                    System.out.println(agility);
                } else if (j == 3) {
                    Node attNode = attributes.item(j);
                    Element attrElement = (Element) attNode;
                    charisma = Integer.parseInt(attrElement.getTextContent());
//                    System.out.println(charisma);
                }
            }
            Card card  = new Card(cardName, strength, intelligence, agility, charisma);
            deck.addCard(card);
        }
    }

}
