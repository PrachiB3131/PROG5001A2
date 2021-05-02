import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;

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
     * by passing the parameter as true or false
     */
    public abstract void setVisible();
    {
        // put your code here
    }

    /**
     *Method setResizable
     *This method is used to resize the board
     * by clicking on the edge of the window and dragging it.
     */
    public void setResizable()
    {
        // put your code here
    }

    /**
     * Method keyPressed
     * user controls the movement of snake by pressing the keyboard arrow keys
     * up, down, right, left
     */
    public void keyPressed(KeyEvent e)
    {
        // put your code here
    }
    /**
     * Method windowClosing
     * it closes the window when the window close button is clicked
     * @param WindowEventE
     */
    public void windowClosing(WindowEvent E)
    {
        // put your code here
    }

}
