/**
 * Class PP_Snake represents the snake object.
 *
 * @author Prachi(23820430)
 * @version (01/05/2021)
 */
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
public class PP_Snake  {
    Image head;
    Image body;
    public PP_Snake() {
        head = new ImageIcon("Images/Head.png").getImage();
        body = new ImageIcon("Images/Body.png").getImage();
    }
    } 