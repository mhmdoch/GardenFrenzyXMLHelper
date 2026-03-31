
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


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


        // int mapWidth, int mapHeight
        int mapWidth = Integer.parseInt(doc.getDocumentElement().getAttribute("mapWidth"));
        int mapHeight = Integer.parseInt(doc.getDocumentElement().getAttribute("mapHeight"));

        // int totalScore
        NodeList totalScoreNodeList = doc.getElementsByTagName("totalScore");
        Node totalScoreNode = totalScoreNodeList.item(0);
        int totalScore = Integer.valueOf(totalScoreNode.getTextContent());
/*
        // Player player
        NodeList playerNodeList = doc.getElementsByTagName("player");

        int playerPosX = Integer.parseInt(playerNodeList.getAttribute("posX"));
        int playerPosY = Integer.parseInt(playerNodeList.getAttribute("posY"));

/*
    <player posX="16" posY="8">
                <name>Udo</name>
                <speed>30</speed>
                <health>100</health>
                <baseDmg>500</baseDmg>
                </player>
*/

        System.out.println("mapWidth: " + mapWidth);
        System.out.println("mapHeight: " + mapHeight);

        System.out.println("totalScore: " + totalScore);


    }



}
