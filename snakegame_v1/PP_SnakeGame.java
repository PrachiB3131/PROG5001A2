/**
 * Class PP_SnakeGame represents the GUI of the game
 *
 * @Prachi(23820430) 
 * @(02/05/2021)
 */
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

public class PP_SnakeGame extends JFrame implements ActionListener {
    private JLabel GameOver;
    private JButton ClickToPlay;
    private JLabel TopPlayersScore;   
    private JLabel CurrentPlayerScore;
    private JButton Quit;
    private Graphics g;
    private JLabel MySnakeGame; 
    private Image Snake;
    private JLabel SnakeLabel;
    private JLabel Name;

    public PP_SnakeGame(String SnakeGame) {  
        super(SnakeGame);

        GameOver = new JLabel("GAME OVER");
        ClickToPlay = new JButton("CLICK TO PLAY");   
        TopPlayersScore = new JLabel("TOP PLAYER'S SCORE");  
        SnakeLabel = new JLabel();
        Quit = new JButton("QUIT");
        Quit.setBackground(Color.BLUE);
        MySnakeGame= new JLabel("MY SNAKE GAME ©");
        CurrentPlayerScore = new JLabel("CURRENT PLAYER SCORE"); 
        Name = new JLabel("PROG5001:2021 PRACHI");

        //NORTH COMPONENTS
        JPanel NPanel = new JPanel(new GridBagLayout());
        NPanel.setBackground(Color.BLUE);
        NPanel.setBounds(10,10,1500,40);
        GridBagConstraints northconstraints1= new GridBagConstraints();
        northconstraints1.anchor = GridBagConstraints.NORTH;
        northconstraints1.insets = new Insets(10, 10, 10, 10);
        NPanel.add(MySnakeGame,northconstraints1);
        MySnakeGame.setForeground(Color.white);

        //WEST COMPONENTS 
        JPanel WPanel = new JPanel(new GridBagLayout());
        WPanel.setBackground(Color.black);
        WPanel.setBounds(10,70,550,700);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //GAMEOVER LABEL
        constraints.gridx = 0;
        constraints.gridy = 0;     
        GameOver.setForeground(Color.white);
        WPanel.add(GameOver,constraints);

        //CLICK TO PLAY BUTTON
        constraints.gridx = 0;
        constraints.gridy = 1; 
        ClickToPlay.addActionListener(this);
        WPanel.add(ClickToPlay, constraints);

        //EAST COMPONENTS
        JPanel EPanel = new JPanel(new GridBagLayout());
        EPanel.setBounds(580,70 ,550,700);
        GridBagConstraints constraint = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //TOP PLAYER'S SCORE LABEL
        constraints.gridx = 0;
        constraints.gridy = 0;     
        EPanel.add(TopPlayersScore, constraints);
        TopPlayersScore.setBorder(new LineBorder(Color.blue,1));

        //CURRENT PLAYER SCORE LABEL
        constraints.gridx = 0;  
        constraints.gridy = 1;
        EPanel.add(CurrentPlayerScore, constraints);
        CurrentPlayerScore.setBorder(new LineBorder(Color.blue,1));

        //NAME LABEL
        constraints.gridx = 0;  
        constraints.gridy = 3;
        EPanel.add(Name, constraints);
        Name.setBorder(new LineBorder(Color.blue,1));

        //SNAKE IMAGE LABEL
        constraints.gridx = 0;  
        constraints.gridy = 2;
        SnakeLabel.setIcon(new ImageIcon("Images/BigSnake.jpg"));
        EPanel.add(SnakeLabel,constraints);

        //QUIT BUTTON
        constraints.gridx = 0;  
        constraints.gridy = 4;
        EPanel.add(Quit, constraints);

        //Adding all the components to the panel
        add(NPanel);
        add(WPanel);
        add(EPanel);

        setPreferredSize(new Dimension(1500, 1500));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

    }

    public void actionPerformed(ActionEvent e){
        JFrame newgame = new JFrame();
        newgame.add(new PP_GameBoard());
        newgame.setResizable(false);
        newgame.pack();
        newgame.setLocationRelativeTo(null);
        newgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newgame.setTitle("Snake");
        newgame.setVisible(true);

    }
}