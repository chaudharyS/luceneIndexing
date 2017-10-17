/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghazalsearch;

/**
 *
 * @author Poopy_Babez
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class readingXML {
    public String getShayar(File xmlFile){
        String str = null;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            str = (doc.getDocumentElement().getFirstChild().getTextContent());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(readingXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    public String getTitle(File xmlFile){
        String str = null;
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            str = (doc.getDocumentElement().getFirstChild().getNextSibling().getTextContent());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(readingXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    public String getContent(File xmlFile){
        String str = null;
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            str = (doc.getDocumentElement().getLastChild().getTextContent());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(readingXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
}
