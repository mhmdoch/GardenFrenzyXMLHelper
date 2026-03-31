import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        XMLController controller = new XMLController();
        File xmlFile = new File("src/savegame.xml");

        controller.readXML(xmlFile);


    }
}