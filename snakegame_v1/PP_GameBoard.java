 /**
 * Class PP_GameBoard represents the code for GameBoard 
 *
 * @Prachi(23820430) 
 * @(02/05/2021)
 */
//https://zetcode.com/javagames/snake/
//https://www.whitman.edu/mathematics/java_tutorial/ui/drawing/loadingImages.html
//https://www.w3schools.com/java/java_inheritance.asp
//https://www.w3schools.com/java/java_interface.asp
//https://www.w3schools.com/java/java_abstract.asp
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;

public class PP_GameBoard extends JPanel implements ActionListener, KeyListener {
    private final int GAMEBOARD_WIDTH = 500; //Board Height in pixels
    private final int GAMEBOARD_HEIGHT = 500; //Board Width in pixels
    private final int PREY_SIZE = 10; //Pixel size for each prey and  each snake body  
    private final int ALL_PREY = 2500; //Total pixels available for prey and snake
    private final int RANDOM_POSITION = 30; //Constant value taken for calculating the random positions of prey
    private final int SPEED = 140;//Controls the speed of the game
    private final int x[] = new int[ALL_PREY];//Array for position of snake on x-axis
    private final int y[] = new int[ALL_PREY];//Array for position of snake on y-axis 
    public static int snakebody;//Body part of the snake

    private boolean leftMovement = false;//Boolean value for left movement of snake 
    private boolean rightMovement = true;//Boolean value for right movement of snake 
    private boolean upMovement = false;//Boolean value for up movement of snake 
    private boolean downMovement = false;//Boolean value for down movement of snake 
    private boolean Gameinprogress = true;//Boolean value to determine if the game is in progress or not 

    private PP_Prey p_prey ;//Object of PP_Prey class
    private PP_Snake p_snake;//Object of PP_Snake class 
    private Timer time;//Object of Timer class
    private Image body;//Object of image type for the body of snake from PP_Snake class 
    private Image img;//Object of image type for the prey image from PP_Prey class 
    private Image head;//Object of image type for the head of snake from PP_Snake class
    
    //Constructor
    public PP_GameBoard() {
        super();
        addKeyListener(this);
         p_snake = new PP_Snake();
         p_prey = new PP_Prey();

        initialiseBoard();
    }

    // gameboard
    /**
     * Method initialiseBoard
     * Initialising the board
     */
    private void initialiseBoard() {

        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT));
        AddingImages();
        initialiseGame();
    }

    /**
     * Method AddingImages
     * Adding the images from their declared image object from the prey and snake class
     */
    private void AddingImages() {

        body = p_snake.body;
        img = p_prey.img;
        head = p_snake.head;
    }

    /**
     * Method initialiseGame
     * Initialising the game by storing the snake body in the defined array and randomly located prey
     */
    private void initialiseGame() {

        snakebody = 4;

        for (int n = 0; n < snakebody; n++) {
            x[n] = 50 - n * 10;
            y[n] = 50;
        }

        p_prey.randomposition(RANDOM_POSITION,PREY_SIZE);
        time = new Timer(SPEED, this);
        time.start();
    }

     
    /**
     * Method paintComponent
     * To draw the graphics on the gameboard
     * @param g A parameter
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

    }
    // gameboard
    /**
     * Method doDrawing
     * To draw the images on the gameboard
     * @param g A parameter
     */
    private void doDrawing(Graphics g) {

        if (Gameinprogress) {
            //for drawing the  prey image
            g.drawImage(img,p_prey.prey_on_xaxis,p_prey.prey_on_yaxis, this);
            // For drawing the snake image
            for (int n = 0; n < snakebody; n++) {
                if (n == 0) {
                    g.drawImage(head, x[n], y[n], this);
                } else {
                    g.drawImage(body, x[n], y[n], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver();
            setVisible(false);
        }        
    }

    /**
     * Method gameOver
     * It is calling the PP_SnakeGame class with declared object "game" 
     * @param g A parameter of graphics
     */
    private void gameOver() {

        PP_SnakeGame game = new PP_SnakeGame("Snake");
        game.setVisible(true);

    }

    /**
     * Method movesnake
     * Movement of the snake 
     */
    private void movingofsnake() {
        //Changing the position of snakebody in the array when snake moves
        for (int n = snakebody; n > 0;  n--) {
            x[n] = x[(n - 1)];
            y[n] = y[(n - 1)];
        }
        //For the movement of snake in left direction
        if (leftMovement) {
            x[0] -= PREY_SIZE;
        }
        //For the movement of snake in right direction
        if (rightMovement) {
            x[0] += PREY_SIZE;
        }
        //For the movement of snake in up direction
        if (upMovement) {
            y[0] -= PREY_SIZE;
        }
        //For the movement of snake in down direction
        if (downMovement) {
            y[0] += PREY_SIZE;
        }
    }

    /**
     * Method CheckCollision
     * Checking the collision if snake head is collided with its own body or the board wall.
     */
    private void CheckCollision() {
        //Collision of snake head with any of its body part
        for (int n = snakebody; n > 0; n--) {

            if ((n > 5) && (x[0] == x[n]) && (y[0] == y[n])) {
                Gameinprogress = false;
            }
        }
        //Collision of snake head with the top wall of Gameboard 
        if (y[0] >= GAMEBOARD_HEIGHT) {
            Gameinprogress = false;
        }
        //Collision of snake head with the lower wall of Gameboard
        if (y[0] < 0) {
            Gameinprogress = false;
        }
        //Collision of snake head with the right wall of Gameboard
        if (x[0] >= GAMEBOARD_WIDTH) {
            Gameinprogress = false;
        }
        //Collision of snake head with the left wall of Gameboard
        if (x[0] < 0) {
            Gameinprogress = false;
        }

        if (!Gameinprogress) {
            time.stop();
        }
    }

    // gameboard
    /**
     * Method actionPerformed
     *
     * @param e A parameter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (Gameinprogress) {
            p_prey.checkPreyCollision(x[0],y[0],RANDOM_POSITION,PREY_SIZE);
            CheckCollision();
            movingofsnake();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    /**
     * Method keyPressed
     * Added the key events to move the snake in all the directions
     * @param e A parameter
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        //Key event for left movement of snake with left arrow key
        if ((key == KeyEvent.VK_LEFT) && (!rightMovement)) {
            leftMovement = true;
            upMovement = false;
            downMovement = false;
        }
        //Key event for right movement of snake with right arrow key
        if ((key == KeyEvent.VK_RIGHT) && (!leftMovement)) {
            rightMovement = true;
            upMovement = false;
            downMovement = false;
        }
        //Key event for down movement of snake with down arrow key
        if ((key == KeyEvent.VK_UP) && (!downMovement)) {
            upMovement = true;
            rightMovement = false;
            leftMovement = false;
        }
        //Key event for up movement of snake with up arrow key
        if ((key == KeyEvent.VK_DOWN) && (!upMovement)) {
            downMovement = true;
            rightMovement = false;
            leftMovement = false;
        }
        //Added the Space key event to play and pause the game
        if (key == KeyEvent.VK_SPACE ){
            Gameinprogress = !Gameinprogress;
        }
        
        if (key == KeyEvent.VK_SPACE && !Gameinprogress) {
            time.stop();
        }
        else if (key == KeyEvent.VK_SPACE && Gameinprogress ){
            time.start();
        }
    }

}