# Airport Challenge

This is a small code challenge I have worked on to better understand the Java syntax and effectively apply principles of OOP design pattern.

## Requirements

**User stories**
```
As an air traffic controller 
So I can get passengers to a destination 
I want to instruct a plane to land at an airport

As an air traffic controller 
So I can get passengers on the way to their destination 
I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport

As an air traffic controller 
To ensure safety 
I want to prevent takeoff when weather is stormy 

As an air traffic controller 
To ensure safety 
I want to prevent landing when weather is stormy 

As an air traffic controller 
To ensure safety 
I want to prevent landing when the airport is full 

As the system designer
So that the software can be used for many different airports
I would like a default airport capacity that can be overridden as appropriate
```

**Edge cases**

- Planes can only take off from airports they are in
- Planes that are already flying cannot take-off and/or be in an airport
- Planes that are landed cannot land again and must be in an airport


## Approach

After having analysed the user's stories I have found 4 main elements that play a role in this application and decided to create 4 classes: 
- **Airport class**, **Airplane class**, **Hangar class**, **ControlTower class**, **Weather class**.

The responsibilities of each class are:
- **Airport class**  - allows the **Airplane** to land or take off. It has two methods **airplaneLand** and **airplaneTakeOff** they both return a confirmation message when the airplane is allowed to land or takeoff and a helpful message when not.
- **Airplane class** - has a property that state the **Airplane** as being or not at the airport.
- **Hangar class** - stores the airplane and starts with a default capacity. It has a method **capacityOverride** to override the capacity as required.
- **ControlTower class** - checks all the condition for which the **Airplane** is allowed or not to land or take off.
- **Weather class** - provides a random weather state. This can be sunny or stormy with a higher percentage or sunny weather.

