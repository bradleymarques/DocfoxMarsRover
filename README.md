# DocfoxMarsRover
A Java implementation of the Mars Rover challenge.

-------------------------------------------------------------------
- Next45 Mars Rover Challenge version 1.1 - Optimize the commands -
-------------------------------------------------------------------
The solution to this Mars Rover Challenge was designed and implemented by Evan Rubin. 
The implementation was written in Java using the Netbeans 8.2 IDE, Java version 1.8.0_111
and the Runtime: Java(TM) SE Runtime Environment 1.8.0_111-b14

The folder structure contains the source code, this README File, a compiled jar of the 
application and a sample text file to be used as instructions to the Mars Rover.

In order to use this application please ensure your computer meets the following
specifications:
• The computer running this application is a Windows, Linux or Apple Machine
• The computer running this application has Java 1.8 or above

In order to successfully run this program; 
1. Create an instruction file to be used.
2. Ensure the instructions to be used are in the same folder as MarsRover.jar
3. Run the file MarsRover.jar
4. Follow the prompt instructions to get the rover's final location

--------------------------------------
- Explanation of the solution chosen -
--------------------------------------

This solution was created using 2 classes:
MarsRover.java
Rover.java

----------------------------------------------------------------------------------------------------------------------------

MarsRover.java is effectively the "main" java class. All this class does is:
• Prompt the user for the name of the text file containing the commands (ensuring the file extension is provided)
• Create a rover object with all the information acquired from the text file
• Run through the lines of this text file
• Execute the instructions saved to the rover

This class was kept very simple. This is due to the fact the main class should not
contain complexity regarding the rover, the complexity is confined to the rover
and thus any actions taking place that directly affect the rover were kept
within the rover class. The main class was designed in such a way that it would be easy to
create multiple different rover instances and allow different instructions to be added to
each instance with minimal code changes.

This calss contains two helper functions:
1. validateFileName()
2. processLine()

validateFileName will simply check if the file name entered contains a file extension and returns a true if it does and a false
if it doesn't. This is part of error checking - it will ensure only files of the right type are entered. This function can
easily be removed if other file types are required.

processLine will take in the line read from the text file and determine what to do with the information and where
to add the information to the rover object created.

----------------------------------------------------------------------------------------------------------------------------

Rover.java is a class used to define the properties and actions which a rover
has or can conduct. This class contains the following private variables with
getters and setters for each:
    private int posX; //Stores the current horizontal position of the rover
    private int posY; //Stores the current vertical position of the rover
    private int maxBoardX; //Stores the Maximum horizontal position the rover can be in
    private int maxBoardY; //Stores the Maximum vertical position the rover can be in
    private String instructions; //Stores the instructions to move the rover
    private boolean optimized=false; //Stores whether the instructions are optimized or not
    private boolean validRoute=true; //Stores whether the route given is valid
    private char direction; //Stores the current direction the rover is facing

This class also contains three functions:
	public void move()
	public boolean isCourseValid()
	public void optimizeCourse()

The move function will check the current instruction given to the rover and execute it
ultimately moving the rover.

the isCourseValid function will determine whether the instructions are valid, this checks
to see if the only letters within the instructions are either: 'M', 'L' or 'R' 

The optimizeCourse function optimizes the instructions - changes three left turns into a 
right turn and vice versa.

All the main functions in both classes have been commented describing what each part of the
functions task is to help understand the thought process behind the design.

-----------------------------
- Ensuring code correctness -
-----------------------------

The code was designed in such a way that every vital step of the process had some form of 
error checking. The code would not progress further if a previous section could not be completed.
The error checking used was a combination of try catches for reading from text files and various
if statements and case switches to check that the right conditions have been met.

The outputs of the code were tested with various different instructions - even those containing 
invalid options for the rover.

Cases where the rover would progress outside of the designated field size would not move the rover.
The rover, however, would still carry on receiving instructions until it could start moving again.

--------------------
- Assumptions Made -
--------------------
• The text file giving instructions is formatted as described in the brief
• The maximum board size is 9x9 blocks (if it were more than single digits it was unclear how the instructions would look)
• The letters in the instruction file are all assumed to be in capital letters
