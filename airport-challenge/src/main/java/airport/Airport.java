package airport;

import java.util.ArrayList;

import airplane.Airplane;

import controlTower.ControlTower;
import weather.Weather;

public class Airport
{
  ControlTower controlTower;
  ArrayList<Object> hangar;
  String weather;
	
  public Airport()
  {
    this.controlTower = new ControlTower();
    this.weather = Weather.forecast();
    this.hangar = new ArrayList<Object>();
	}

  public String airplaneLand(Airplane airplane)
  {
    if (controlTower.checkForLand(hangar, airplane, weather)) { return "The airplane cannot land"; }
    airplane.land();
    hangar.add(airplane);
    return "The airplane has succesfully landed";
  }

  public Object airplaneTakeOff(Airplane airplane)
  {
    if (controlTower.checkForTakeOff(hangar, airplane, weather)) { return "The airplane is not in the hangar"; }
    airplane.takeOff();
    hangar.remove(airplane);
    return hangar;
  }
}
