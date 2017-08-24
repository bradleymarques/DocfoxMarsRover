package marsrover;

import java.io.File;
import java.util.Scanner;
//import javax.swing.JOptionPane;

/**
 * Solution to the Next45 Mars Rover Challenge version 1.1 - Optimize the commands
 * Main class. Used to analyse the text file and pass the information into a rover object
 * to complete tasks.
 * @author Evan
 */
public class MarsRover {
    public static void main(String[] args) {
        //Create a new instance of a Rover:
        
        Rover rover = new Rover();
        
        //Read and process info in from text file:
        try {
            String line;
            
            //Get the file name usising the console, use a scanner:
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the textfile to be used. \nMake sure the file extension is provided:");
            String fileName = input.nextLine();
            //Ensure the file name is valid:
            while(!validateFileName(fileName)){
                System.out.println("\nEnter the name of the textfile to be used. \nPlease ensure the file extension is included with the file name:");
                fileName = input.nextLine();
            }
            File file = new File(fileName);

            //Use scanner to get the lines from the file:
            Scanner sc = new Scanner(file);
            int lineCount=0;
            while (sc.hasNextLine()) {
                lineCount++;
                line = sc.nextLine();
                processLine(line, lineCount, rover);
            }
            sc.close();
            //Check the route is valid
            if(rover.isValidRoute()){
                //Move the rover
                rover.move();
                //Print out the final information
               System.out.println("\nFinal Rover Position:\n"
                        + "Horozontal: "+rover.getPosX()+"\n"
                        + "Vertical: "+rover.getPosY()+"\n"
                        + "Direction: "+rover.getDirection());
            }
        } catch (Exception e) {e.printStackTrace();}
    }   
        
    /**
     * Ensure the file name is valid by checking if the file extension is included
     * @param fileName Take in the file name to validate
     * @return The valid file name with the right extension
     */
    private static boolean validateFileName(String fileName) {
        if (fileName.contains(".")){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Process the different tasks related to each line
     * @param line Take in the information from the line
     * @param lineCount Take in the line number
     */
    private static void processLine(String line, int lineCount, Rover rover) {
        switch(lineCount){
            case 1: //Line 1 - Initialize board size
                rover.setMaxBoardX(line.charAt(0)-'0');
                rover.setMaxBoardY(line.charAt(1)-'0');
                break;
            case 2: //Line 2 - Set Default position of the rover
                //Assuming that positions can only be single digits.
                //Assuming that the formatting of the file is exactly like the example.
                rover.setPosX(line.charAt(0)-'0');
                rover.setPosY(line.charAt(1)-'0');
                rover.setDirection(line.charAt(3));
                break;
            case 3: //Line 3 - Optimize move sequence
                rover.setInstructions(line);
                if (rover.isCourseValid()){
                    rover.optimizeCourse();
                }
                else{
                    System.out.println("ERROR: Invalid route entered.");
                    rover.setValidRoute(false);
                }
                break;
            default: //Throw error with an invalid file length
                System.out.println("ERROR: Invalid text file");
                break;
        }
    }

}
