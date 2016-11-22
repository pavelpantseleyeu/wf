package by.epam.wf.testtask.util;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class StringUtilTest {

  @Test
  public void parseStringTest() {
    String given = "Person1 met person2 in the 1969y";
    String[] expected = new String[] {"Person", "met", "person", "in", "the", "y"};
    String[] actual = StringUtil.getEntitiesWithoutDigits(given);
    assertArrayEquals(actual, expected);
  }
}