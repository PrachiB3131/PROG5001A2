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
        head = new ImageIcon("Images/Head.png").getImage();
        body = new ImageIcon("Images/Body.png").getImage();
        Dimension dimension = new Dimension(100, 100);
        setPreferredSize(dimension);
    }
} 