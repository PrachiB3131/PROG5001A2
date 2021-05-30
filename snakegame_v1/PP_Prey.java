/**
 * Class PP_Prey represents the prey object.
 *
 * @Prachi(23820430) 
 * @(02/05/2021)
 */
//https://stackoverflow.com/questions/57777780/how-to-get-math-random-with-a-unit-step
import java.awt.Image;
import javax.swing.ImageIcon;
import java.lang.Math;

public class PP_Prey  {
    public Image img;
    public int prey_on_xaxis;
    public int prey_on_yaxis;
    public PP_Prey() {
        img = new ImageIcon("Images/Prey.png").getImage();
    }

    /**
     * Method checkPrey
     * It checks the collision of the head of the snake with prey
     * 
     */
    public void checkPreyCollision(int x, int y , int RANDOM_POSITION, int PREY_SIZE)
    {
        if ((x == prey_on_xaxis) && (y == prey_on_yaxis)) {

            PP_GameBoard.snakebody++;
            randomposition(RANDOM_POSITION,PREY_SIZE);
        } 
    }

    /**
     * Method randomposition
     *
     * It allocates the random position to prey
     */
    public void randomposition(int RANDOM_POSITION, int PREY_SIZE)
    {
        int r = (int) (Math.random() * RANDOM_POSITION);
        prey_on_xaxis= ((r * PREY_SIZE));

        r = (int) (Math.random() * RANDOM_POSITION);
        prey_on_yaxis = ((r * PREY_SIZE));    

    }
}

