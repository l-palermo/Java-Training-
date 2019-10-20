package controlTower;

import java.util.ArrayList;

import airplane.Airplane;

public class ControlTower
{
  public boolean checkForLand(ArrayList<Object> hangar, Airplane airplane, String weather)
  {
    if (checkHangarFull(hangar) || checkHangarWithAirplane(hangar, airplane) || 
    checkIfAirplaneIsAtAirport(airplane) || checkWeather(weather))
    {
     return true;
    }
    return false;
  }
  public boolean checkForTakeOff(ArrayList<Object> hangar, Airplane airplane, String weather)
  { 
    if (!checkHangarWithAirplane(hangar, airplane) || !checkIfAirplaneIsAtAirport(airplane) ||
    checkWeather(weather))
    {
      return true;
    }
    return false;
  }

  private boolean checkHangarFull(ArrayList<Object> hangar)
  {
    if (hangar.size() >= 5) { return true; }
    return false;
  }
  private boolean checkHangarWithAirplane(ArrayList<Object> hangar, Airplane airplane)
  {
    if (hangar.contains(airplane)) { return true; }
    return false;
  }
  private boolean checkIfAirplaneIsAtAirport(Airplane airplane)
  {
    if (airplane.atAirport()) { return true; }
    return false;
  }
  private boolean checkWeather(String weather)
  {
    if (weather == "stormy") { return true; }
    return false;
  }
}
