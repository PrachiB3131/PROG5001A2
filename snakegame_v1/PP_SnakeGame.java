/**
 * Class PP_SnakeGame represents the GUI of the game
 *
 * @Prachi(23820430) 
 * @(02/05/2021)
 */
//https://www.w3schools.com/java/java_interface.asp
//https://www.w3schools.com/java/java_inheritance.asp
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

public class PP_SnakeGame extends JFrame implements ActionListener {
    private JLabel GameOver;
    private JButton ClickToPlay;
    private JLabel TopPlayersScore;
    private JLabel NewTopPlayersScore;  
    private JLabel CurrentPlayerScore;
    private JButton Quit;
    private JLabel MySnakeGame; 
    private JLabel SnakeLabel;
    private JLabel Name;

    public PP_SnakeGame(String SnakeGame) {  
        super(SnakeGame);
        boolean flag = false;
        GameOver = new JLabel("GAME OVER");
        ClickToPlay = new JButton("CLICK TO PLAY");   
        TopPlayersScore = new JLabel("TOP PLAYER'S SCORE:"+PP_LoginForm.topScore);  
        SnakeLabel = new JLabel();
        Quit = new JButton("QUIT");
        Quit.setBackground(Color.BLUE);
        MySnakeGame= new JLabel("MY SNAKE GAME ©");
        CurrentPlayerScore = new JLabel("CURRENT PLAYER SCORE:"+(PP_GameBoard.snakebody-4)); 
        Name = new JLabel("PROG5001:2021 PRACHI");

        if(PP_LoginForm.topScore < (PP_GameBoard.snakebody-4)){
            flag = true;
            NewTopPlayersScore = new JLabel("NEW TOP PLAYER'S SCORE:: "+(PP_GameBoard.snakebody-4));  
            PP_LoginForm.writeTopScore((PP_GameBoard.snakebody-4)+"");
        }

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
        if(!flag){
            constraints.gridx = 0;
            constraints.gridy = 0;     
            EPanel.add(TopPlayersScore, constraints);
            TopPlayersScore.setBorder(new LineBorder(Color.blue,1));
        }

        if(flag){
            constraints.gridx = 0;
            constraints.gridy = 0;   
            EPanel.add(NewTopPlayersScore, constraints);
            NewTopPlayersScore.setBorder(new LineBorder(Color.blue,1));
        }

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
        Quit.addActionListener(this);
        EPanel.add(Quit, constraints);

        //Adding all the components to the panel
        add(NPanel);
        add(WPanel);
        add(EPanel);

        //Setting the size and visibility of the JFrame
        setPreferredSize(new Dimension(1500, 1500));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent e){
        JFrame newgame = new JFrame();
        newgame.add(new PP_GameBoard());
        newgame.setResizable(false);
        newgame.pack();
        newgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newgame.setTitle("Snake");
        newgame.setVisible(true);
        newgame.setLocationRelativeTo(null);
        try
        {
            PP_LoginForm.readTopScoreFromFile("TopPlayerScore.txt");
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }

    }

}