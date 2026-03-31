
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



        System.out.println(totalScore);


        // unteres gibt folgendes aus :D
        // com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl@4b9af9a9
        NodeList toolObjList = doc.getElementsByTagName("toolObj");
        Node firstToolObjList = toolObjList.item(0);


        System.out.println(firstToolObjList.getTextContent());
    }

}
