package by.epam.wf.testtask.util;

import java.util.Arrays;
import java.util.regex.Pattern;


public class StringUtil {


  public static String[] getEntitiesWithoutDigits(String str) {
    String s = replaceByRegex(str, "\\d");
    String[] output = getEntitiesSplitByPattern(s, " ");
    printToConsole(output);
    return output;
  }

  private static String toString(String[] sArray) {
    return Arrays.toString(sArray);
  }

  public static String[] getEntitiesSplitByPattern(String str, String pattern){
    return str.split(pattern);
  }

  public static String replaceByRegex(String str, String regex){
    Pattern pattern = Pattern.compile(regex);
    return pattern.matcher(str).replaceAll("");
  }

  public static void printToConsole(String[] obj){
    System.out.println(toString(obj));
  }
}
