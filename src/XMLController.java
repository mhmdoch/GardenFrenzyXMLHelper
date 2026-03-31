
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class XMLController {


    public void readXML(File file) {
        Document doc = null;

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(file);
        } catch (Exception e) {

        }

        // normalize() removes whitespaces etc.
        doc.getDocumentElement().normalize();


        // int mapWidth, int mapHeight, int totalScore
        int mapWidth = Integer.parseInt(doc.getDocumentElement().getAttribute("mapWidth"));
        int mapHeight = Integer.parseInt(doc.getDocumentElement().getAttribute("mapHeight"));
        int totalScore = Integer.parseInt(doc.getElementsByTagName("totalScore").item(0).getTextContent());


        // Player player
        NodeList playerNodeList = doc.getElementsByTagName("player");
        // playerNodeList wird durch (Element) in playerElement zu einem Element
        Element playerElement = (Element) playerNodeList.item(0);

        // int playerPosX, int playerPosY, String playerName
        // int playerSpeed, int playerHealth, int playerBaseDmg
        int playerPosX = Integer.parseInt(playerElement.getAttribute("posX"));
        int playerPosY = Integer.parseInt(playerElement.getAttribute("posY"));
        String playerName = playerElement.getElementsByTagName("name").item(0).getTextContent();
        int playerSpeed = Integer.parseInt(playerElement.getElementsByTagName("speed").item(0).getTextContent());
        int playerHealth = Integer.parseInt(playerElement.getElementsByTagName("health").item(0).getTextContent());
        int playerBaseDmg = Integer.parseInt(playerElement.getElementsByTagName("baseDmg").item(0).getTextContent());


        System.out.println("------------------------------");
        System.out.println("mapWidth: " + mapWidth);
        System.out.println("mapHeight: " + mapHeight);
        System.out.println("totalScore: " + totalScore);
        System.out.println("------------------------------");
        System.out.println("Player:");
        System.out.println("posX: " + playerPosX);
        System.out.println("posY: " + playerPosY);
        System.out.println("name: " + playerName);
        System.out.println("speed: " + playerSpeed);
        System.out.println("health: " + playerHealth);
        System.out.println("baseDmg: " + playerBaseDmg);
        System.out.println("------------------------------");

        Node toolBoxNode = doc.getElementsByTagName("toolList").item(0);
        NodeList toolBoxNodeList = toolBoxNode.getChildNodes();
        int n = toolBoxNodeList.getLength();
        Node toolBoxCurrent;
        for (int i=0; i<n; i++) {
            toolBoxCurrent = toolBoxNodeList.item(i);
            if(toolBoxCurrent.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(
                        toolBoxCurrent.getNodeName() + ": " + toolBoxCurrent.getTextContent());
            }
        }





    }



}
