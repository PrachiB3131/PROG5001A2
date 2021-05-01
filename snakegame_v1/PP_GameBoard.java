import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

abstract public class PP_GameBoard extends JPanel {    
    int xcells = 30;    
    int ycells = 30;
    int szcell = 10;        

    public PP_GameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black);
        setFocusable(true);        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    /**
     * Method setVisible
     * For setting the visibility as true or false
     *
     */
    public abstract void setVisible();
    {
        // put your code here
    }

    /**
     *Method setBackgroud
     *This method is used to set the background of the board
     * 
     */
    public void setBackground()
    {
        // put your code here
    }

    /**
     * Method setPreferredSize
     * To set the size of the board
     * 
     */
    public void setPreferredSize()
    {
        // put your code here
    }

    /**
     * Method keyPress
     * user controls the movement of snake by pressing the keyboard keys
     * up, down, right, left
     */
    public void keyPress()
    {
        // put your code here
    }
}
