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

public class PP_Prey extends JPanel {
    Image img;
    public PP_Prey(String image_path, int width, int height) {
        img = new ImageIcon(image_path).getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        repaint();
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Image demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PP_Prey panel = new PP_Prey("Images/smiley.jpg", 67, 64);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

