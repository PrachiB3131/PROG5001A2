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
        Dimension dimension = new Dimension(50,50);
        setPreferredSize(dimension);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(head, 20, 20, null);
        repaint();

        int x_axis = 100;
        int y_axis = 150;

        for(int i=0; i<3; i++)
        {
            g.drawImage(body, 100+(i*250), 100, null);
            //repaint();
            //y_axis = y_axis + 30;
        }

        for(int j=0; j<4; j++)
        { 
            g.drawImage(body,900,100+(j*250), null);
            //repaint();
            //x_axis = x_axis + 30;
        }
        repaint();
        g.drawImage(body, 100, 100, null);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Image Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PP_Snake panel = new PP_Snake();

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}  