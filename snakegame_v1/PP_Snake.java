/**
 * Write a description of class Snake here.
 *
 * @author Prachi(23820430)
 * @version (01/05/2021)
 */
abstract class PP_Snake
{
    /**
     * Constructor for objects of class Snake
     */
    public PP_Snake() {
        // initialise instance variables        
    }

    /**
     * Method move
     * controls the movement of snake (up,down, right, left)
     * user controls this movement by pressing keyboard keys
     */
    public abstract void move();
    {
        // put your code here
    }
    /**
     * Method CheckPrey
     * snake finds prey to eat it
     * it checks  x and y coordinates of the apple till they matches the
     * x and y coordinates of the snake head
     */
    public void CheckPrey()
    {
        // put your code here
    }
    /**
     * Method checkCollision
     * it checks if the snake collides with the wall or itself 
     */
    public void checkCollision()
    {
        // put your code here
    }


}
