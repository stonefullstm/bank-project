package br.com.banco.utils;

public class BinaryUtils {

  public static int boolToInt(Boolean b) {
    return b ? 1 : 0;
  }

  public static int binaryStringToInt(String b) {
    return Integer.parseInt(b, 2);
  }
}
