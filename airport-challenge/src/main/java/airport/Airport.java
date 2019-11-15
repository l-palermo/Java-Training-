package airport;

import airplane.Airplane;

import controlTower.ControlTower;
import hangar.Hangar;
import weather.Weather;

public class Airport
{
  ControlTower controlTower;
  Hangar hangar;
  String weather;
	
  public Airport()
  {
    this.controlTower = new ControlTower();
    this.weather = Weather.forecast();
    this.hangar = new Hangar();
	}

  public String airplaneLand(Airplane airplane)
  {
    if (controlTower.checkForLand(hangar, airplane, weather)) { return "The airplane cannot land"; }
    airplane.land();
    hangar.addAirplane(airplane);
    return "The airplane has succesfully landed";
  }

  public Object airplaneTakeOff(Airplane airplane)
  {
    if (controlTower.checkForTakeOff(hangar, airplane, weather)) { return "The airplane cannot take-off"; }
    airplane.takeOff();
    hangar.removeAirplane(airplane);
    return "The airplane has succesfully taken off";
  }
}
