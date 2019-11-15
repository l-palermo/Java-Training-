package hangar;

import java.util.ArrayList;

import airplane.Airplane;

public class Hangar
{ 
  int capacity;
  ArrayList<Airplane> hangar;
  public Hangar()
  {
    this.capacity = 5;
    this.hangar = new ArrayList<Airplane>();
  }

  public void addAirplane( Airplane airplane)
  {
    this.hangar.add(airplane);
  }
  public void removeAirplane( Airplane airplane)
  {
    this.hangar.remove(airplane);
  }
  public void capacityOverride(int capacity)
  {
    this.capacity = capacity;
  }
}