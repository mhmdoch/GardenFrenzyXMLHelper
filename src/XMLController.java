
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


public class XMLController {


    public void readXML(File file) {

        System.out.println("gaga");

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();


            NodeList nodeList = doc.getElementsByTagName("totalScore");
            Node first = nodeList.item(0);
            System.out.println(first.getTextContent() + "aaa");

        } catch (Exception e) {

        }

        System.out.println("gaga after");
    }

}
