package weather;

import java.util.Random;

public class Weather {
  private static String[] forecast = { "stormy", "clear", "clear" };
  private static Random random = new Random(25456);

  public static String forecast() {
    int x = random.ints(0, 3).findFirst().getAsInt();
    return forecast[x];
  }
}
