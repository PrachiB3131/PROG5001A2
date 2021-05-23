/**
 * Class PP_Prey represents the prey object.
 *
 * @Prachi(23820430) 
 * @(02/05/2021)
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.EventQueue;

public class PP_Prey extends JFrame {
    public Image img;
    public int preyx;
    public int preyy;
    public PP_Prey() {
        img = new ImageIcon("Images/Prey.png").getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(9, 9);
        setPreferredSize(size);
    }

    /**
     * Method checkPrey
     * 
     */
    public void checkPrey(int x, int y , int RAND_POSITION, int PREY_SIZE)
    {
        if ((x == preyx) && (y == preyy)) {

            PP_GameBoard.snakebody++;
            randomposition(RAND_POSITION,PREY_SIZE);
        } 
    }

    /**
     * Method randomposition
     *
     * It allocates the random position to prey
     */
    public void randomposition(int RAND_POSITION, int PREY_SIZE)
    {
        int r = (int) (Math.random() * RAND_POSITION);
        preyx= ((r * PREY_SIZE));

        r = (int) (Math.random() * RAND_POSITION);
        preyy = ((r * PREY_SIZE));    

    }

}
