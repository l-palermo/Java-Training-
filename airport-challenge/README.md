# Airport Challenge

This is a small code challenge I have worked on to better understand the Java syntax and effectively apply principles of OOP design pattern.

## Requirements



## Approach
 
I have decided to first create 2 classes - Airport and Airplane.
- Airport class has the functionalities of allowing the Airplane to land or take off and it has a property, hangar that stores the aeroplanes laned at the specific airport.
- The Airplane class saves its state of being or not at the airport.
Once I have TDD these two classes I created another class, Control Tower, to check all the condition for the airport to allow the airplane to land or take off.
- Control Tower class has the responsibility of checking whether the airplane has already landed, or taken off depending by the method, it has to check if there is space in the hangar and check the weather. 
So I then created a weather class that return random weather. To test this class I had to fix the rand seed. 
