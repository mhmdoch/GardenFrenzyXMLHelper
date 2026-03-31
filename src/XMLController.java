
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


public class XMLController {


    public void readXML(File file) {
        int scoreValue = 0;
        Document doc = null;

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();


            NodeList nodeList = doc.getElementsByTagName("totalScore");
            Node first = nodeList.item(0);
            scoreValue = Integer.valueOf(first.getTextContent());

        } catch (Exception e) {

        }
        System.out.println(scoreValue);
        // das hier liefert [#document: null]
        // obwohl ich hier die gesamte xml.normalize() erwartet habe
        // aber das erwartet habe ich auch irgendwie bekommen
        // nur liegen die daten nicht mehr so xml artig im speicher
        // sondern als verschachtelte baumstruktur
        // doc = builder.parse(file) macht das


        System.out.println(doc);

    }

}
