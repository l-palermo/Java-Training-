package controlTower;

import airplane.Airplane;
import hangar.Hangar;

public class ControlTower
{
  public boolean checkForLand(Hangar hangar, Airplane airplane, String weather)
  {
    if(checkHangarFull(hangar) || hangarIncludesAirplane(hangar, airplane) || 
    checkIfAirplaneIsAtAirport(airplane) || checkWeather(weather))
    {
      return true;
    }
    return false;
  }
  public boolean checkForTakeOff(Hangar hangar, Airplane airplane, String weather)
  {
    if(!hangarIncludesAirplane(hangar, airplane) || !checkIfAirplaneIsAtAirport(airplane) ||
    checkWeather(weather))
    {
      return true;
    }
    return false;
  }

  private boolean checkHangarFull(Hangar hangar)
  {
    if(hangar.hangar.size() >= hangar.capacity) { return true; }
    return false;
  }
  private boolean hangarIncludesAirplane(Hangar hangar, Airplane airplane)
  {
    if(hangar.hangar.contains(airplane)) { return true; }
    return false;
  }
  private boolean checkIfAirplaneIsAtAirport(Airplane airplane)
  {
    if(airplane.atAirport()) { return true; }
    return false;
  }
  private boolean checkWeather(String weather)
  {
    if(weather == "stormy") { return true; }
    return false;
  }
}
