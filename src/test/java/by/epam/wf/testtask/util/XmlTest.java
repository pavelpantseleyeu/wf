package by.epam.wf.testtask.util;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class XmlTest {

  private static final String filePath = "src/test/resources/source.xml";

  @Test
  public void vehiclesTest() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
    String xmlQuery = "/warehouse/vehicles/product/text()";
    List expected = Arrays.asList("TATA", "TUK-TUK", "MACHINDRA");
    List actual = new ArrayList();
    NodeList nl = new XmlUtil().getFromXmlFileByQuery(filePath, xmlQuery);
    Assert.assertEquals(3, nl.getLength());
    for (int i = 0; i < nl.getLength(); i++) {
      Node nNode = nl.item(i);
      actual.add(nNode.getTextContent());
    }
    Assert.assertEquals(expected, actual);
  }

  @Test
  @Ignore
  public void productWithMaxPriceTest() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
    String xmlQuery = "math:max(math:max(//product/self::product/@price) div math:min(//self::product/@quantity))";
    List expected = Arrays.asList("18000");
    List actual = new ArrayList();
    NodeList nl = new XmlUtil().getFromXmlFileByQuery(filePath, xmlQuery);
    Assert.assertEquals(1, nl.getLength());
    for (int i = 0; i < nl.getLength(); i++) {
      Node nNode = nl.item(i);
      actual.add(nNode.getTextContent());
    }
    Assert.assertEquals(expected, actual);
  }
}
