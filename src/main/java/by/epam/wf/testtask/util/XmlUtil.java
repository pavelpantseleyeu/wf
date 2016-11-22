package by.epam.wf.testtask.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;


public class XmlUtil {

  public NodeList getFromXmlFileByQuery(String filePath, String xmlQuery) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
    File file = new File(filePath);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(file);

    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();
    XPathExpression expr = xpath.compile(xmlQuery);
    return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
  }
}
