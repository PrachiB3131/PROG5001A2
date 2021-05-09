/**
 * Class PP_SnakeGame represents the GUI of the game
 *
 * @Prachi(23820430) 
 * @(02/05/2021)
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

public class PP_SnakeGame extends JFrame {
    private JLabel GameOver;
    private JButton ClickToPlay;
    private JLabel TopPlayersScore;   
    private JLabel CurrentPlayerScore;
    private Image Snake;
    private JLabel SnakeLabel;
    private JLabel Name;
    private JButton Quit;
    private Graphics g;
    private JLabel MySnakeGame; 

    public PP_SnakeGame(String SnakeGame) {  
        super(SnakeGame);

        GameOver = new JLabel("GAME OVER");
        ClickToPlay = new JButton("CLICK TO PLAY");   
        TopPlayersScore = new JLabel("TOP PLAYER'S SCORE");   
        CurrentPlayerScore = new JLabel("CURRENT PLAYER SCORE"); 
        Name = new JLabel("PROG5001:2021 PRACHI");
        SnakeLabel = new JLabel();
        Quit = new JButton("QUIT");
        Quit.setBackground(Color.BLUE);
        MySnakeGame= new JLabel("MY SNAKE GAME (C)");

        //NORTH COMPONENTS
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.BLUE);
        topPanel.setBounds(10,10,1500,40);
        GridBagConstraints constraints1= new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.NORTH;
        constraints1.insets = new Insets(10, 10, 10, 10);
        topPanel.add(MySnakeGame,constraints1);
        MySnakeGame.setForeground(Color.white);

        //WEST COMPONENTS 
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.black);
        leftPanel.setBounds(10,70,550,700);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //GAMEOVER LABEL
        constraints.gridx = 0;
        constraints.gridy = 0;     
        GameOver.setForeground(Color.white);
        leftPanel.add(GameOver,constraints);

        //CLICK TO PLAY BUTTON
        constraints.gridx = 0;
        constraints.gridy = 1;  
        leftPanel.add(ClickToPlay, constraints);

        //EAST COMPONENTS
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBounds(580,70 ,550,700);
        GridBagConstraints constraint = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //TOP PLAYER'S SCORE LABEL
        constraints.gridx = 0;
        constraints.gridy = 0;     
        rightPanel.add(TopPlayersScore, constraints);
        TopPlayersScore.setBorder(new LineBorder(Color.blue,1));

        //CURRENT PLAYER SCORE LABEL
        constraints.gridx = 0;  
        constraints.gridy = 1;
        rightPanel.add(CurrentPlayerScore, constraints);
        CurrentPlayerScore.setBorder(new LineBorder(Color.blue,1));

        //NAME LABEL
        constraints.gridx = 0;  
        constraints.gridy = 3;
        rightPanel.add(Name, constraints);
        Name.setBorder(new LineBorder(Color.blue,1));

        //SNAKE IMAGE LABEL
        constraints.gridx = 0;  
        constraints.gridy = 2;
        SnakeLabel.setIcon(new ImageIcon("Images/BigSnake.jpg"));
        rightPanel.add(SnakeLabel,constraints);

        //QUIT BUTTON
        constraints.gridx = 0;  
        constraints.gridy = 4;
        rightPanel.add(Quit, constraints);

        //Adding all the components to the panel
        add(topPanel);
        add(leftPanel);
        add(rightPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        
    }

    public static void main(String[] args) {        
        //        EventQueue.invokeLater(() -> {
        //create the game with a game title as follow: The Snake Game (C) Your_Name
        JFrame sgame = new PP_SnakeGame("snake");
        sgame.setVisible(true);
        //        });
    }
}