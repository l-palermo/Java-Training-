package weather;

import java.util.Random;

public class Weather {
  private static String[] forecast = { "stormy", "clear", "clear" };
  static Random random = new Random();

  public static String forecast() {
    int x = random.ints(0, 3).findFirst().getAsInt();
    return forecast[x];
  }
}
