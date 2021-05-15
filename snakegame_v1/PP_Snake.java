/**
 * Class PP_Snake represents the snake object.
 *
 * @author Prachi(23820430)
 * @version (01/05/2021)
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PP_Snake extends JPanel {
    Image head;
    Image body;
    
    public PP_Snake() {
        head= new ImageIcon("Images/Head.png").getImage();
        body= new ImageIcon("Images/Body.png").getImage();
        Dimension dimension = new Dimension(90,90);
        setPreferredSize(dimension);
        
        
    }

    public void paintComponent(Graphics g) {
        g.drawImage(head, 90, 90, null);
        repaint();


        for(int i=1; i<=2; i++)
        {
            g.drawImage(body, 100+(i*35), 196, null);
            repaint();
            //y_axis = y_axis + 30;
        }

        for(int j=1; j<=3; j++)
        { 
            g.drawImage(body,95,105+(j*30), null);
            repaint();
            //x_axis = x_axis + 30;
        }
        repaint();
        g.drawImage(body, 170, 167, null);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Image Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PP_Snake panel = new PP_Snake();

        frame.add(panel);
        frame.setSize(900, 500);
        frame.setVisible(true);
    }
}