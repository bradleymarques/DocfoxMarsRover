
package marsrover;

/**
 *
 * @author Ev
 */
class Rover {
    
    private int posX;
    private int posY;
    private int maxBoardX;
    private int maxBoardY;
    private String instructions;
    private boolean optimized=false;
    private boolean validRoute=true;
    private char direction;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getMaxBoardX() {
        return maxBoardX;
    }

    public void setMaxBoardX(int maxBoardX) {
        this.maxBoardX = maxBoardX;
    }

    public int getMaxBoardY() {
        return maxBoardY;
    }

    public void setMaxBoardY(int maxBoardY) {
        this.maxBoardY = maxBoardY;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isOptimized() {
        return optimized;
    }

    public void setOptimized(boolean optimized) {
        this.optimized = optimized;
    }

    public boolean isValidRoute() {
        return validRoute;
    }

    public void setValidRoute(boolean validRoute) {
        this.validRoute = validRoute;
    }
     
    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    /**
     * Code used to move the Rovers based on the information saved to each instance
     */
    void move() {
        //Run through all the instructions
        for(int i=0;i<instructions.length();i++){      
            switch(direction){
                case 'N':
                    if(instructions.charAt(i)=='L')
                        direction = 'W';
                    else if(instructions.charAt(i)=='R')
                        direction = 'E';
                    else if(instructions.charAt(i)=='M' && posY<maxBoardY)
                        posY++;
                    break;
                case 'E':
                    if(instructions.charAt(i)=='L')
                        direction = 'N';
                    else if(instructions.charAt(i)=='R')
                        direction = 'S';
                    else if(instructions.charAt(i)=='M' && posX<maxBoardX)
                        posX++;
                    break;
                case 'S':
                    if(instructions.charAt(i)=='L')
                        direction = 'E';
                    else if(instructions.charAt(i)=='R')
                        direction = 'W';
                    else if(instructions.charAt(i)=='M' && posY>0)
                        posY--;
                    break;
                case 'W':
                    if(instructions.charAt(i)=='L')
                        direction = 'S';
                    else if(instructions.charAt(i)=='R')
                        direction = 'N';
                    else if(instructions.charAt(i)=='M' && posX>0)
                        posX--;
                    break;
                default:
                    System.out.println("Invalid Direction: "+direction);
                    break;
            }
        }
    }

    /**
     * Code used to determine whether or not the instructions given to the rover are valid
     * and should be carried out
     * @return true if the course is valid, false if it is not.
     */
    boolean isCourseValid(){
        boolean valid = true;
        String validLetters="MLR";
        for(int i=0;i<instructions.length();i++){
            if(validLetters.indexOf(instructions.charAt(i))==-1){
                valid=false;
            }
        }
        return valid;
    }
    
    /**
     * Optimize the move sequence. i.e. LLL should change to R and RRR should change to L
     */
    void optimizeCourse() {
        //Use built in String methods to remove unnecessary rotations
        instructions=instructions.replace("RRR", "L");
        instructions=instructions.replace("LLL", "R");
    }
    
}
