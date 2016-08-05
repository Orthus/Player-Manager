package player_manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import player_manager.Configuration_Handler;
import player_manager.ManagerUI;

/**
 *
 * @author Orthus
 */
public class XML_Handler {
       
     Configuration_Handler config = new Configuration_Handler();
     String Players_path = config.Players_path;
    
    public String XML_Writer(String ID, String Points){
         int Modify_Points =Integer.parseInt(Points);
         String New_Points;
         try {
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse(Players_path);
             Date date = new Date();
             SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
             String formattedDate = sdf.format(date);
             Element root = doc.getDocumentElement();
             NodeList playerlist = root.getElementsByTagName("player");
             if (playerlist.getLength() > 0){
                 int i = 0;
                 while (i < playerlist.getLength()){
                     String id = playerlist.item(i).getAttributes().getNamedItem("userid").getNodeValue();
                     if (id.equals(ID)){
                          String old_points = playerlist.item(i).getChildNodes().item(11).getTextContent();
                         int points = Integer.parseInt(old_points);
                         int new_points = points + Modify_Points;
                         System.out.println(new_points);
                         playerlist.item(i).getChildNodes().item(11).setTextContent(Integer.toString(new_points));
                         DOMSource source = new DOMSource(doc);
                         TransformerFactory transformerFactory = TransformerFactory.newInstance();
                         Transformer transformer = transformerFactory.newTransformer();
                         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                         StreamResult result = new StreamResult(Players_path);
                         transformer.transform(source, result);
                         New_Points = String.valueOf(new_points);
                         return New_Points;
                     }
                     else {
                         i++;
                     }
                 }
             }
         } catch (ParserConfigurationException | SAXException | IOException ex) {
             Logger.getLogger(XML_Handler.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TransformerException ex) {
             Logger.getLogger(XML_Handler.class.getName()).log(Level.SEVERE, null, ex);
         } 
         New_Points = "error";
         return New_Points;
    }
    
    
    public String XML_Reader(String ID, String First, String Last, String GamerTag) throws TransformerConfigurationException{
            String Old_Points = null;
            
            try {
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse(Players_path);
             Element root = doc.getDocumentElement();
             NodeList playerlist = root.getElementsByTagName("player");
             if (playerlist.getLength() > 0){
                 int i = 0;
                 int key = playerlist.item(i).getChildNodes().getLength();
                 System.out.print(String.valueOf(key));
                 while (i < playerlist.getLength()){
                     String id = playerlist.item(i).getAttributes().getNamedItem("userid").getNodeValue();
                     String first = playerlist.item(i).getChildNodes().item(1).getTextContent();
                     String last = playerlist.item(i).getChildNodes().item(3).getTextContent();
                     String points = playerlist.item(i).getChildNodes().item(11).getTextContent();
                     String tag = playerlist.item(i).getChildNodes().item(13).getTextContent();
                     if (id.equals(ID) || tag.equals(GamerTag) || (first.equals(First) && last.equals(Last))){
                         i = playerlist.getLength() + 1 ;
                         Old_Points = points;
                         ID = id;
                         
                     }
                     else {
                         i++;
                     }
                 }
             }
         } catch (ParserConfigurationException | SAXException | IOException ex) {
             Logger.getLogger(XML_Handler.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    return Old_Points+","+ID;
    }
    
}
