import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class PP_GameBoard extends JPanel implements ActionListener {

    private final int GAMEBOARD_WIDTH = 600; 
    private final int GAMEBOARD_HEIGHT = 600;
    private final int PREY_SIZE = 10;  
    private final int ALL_PREY = 900; 
    private final int RAND_POSITION = 29; 
    private final int DELAY = 140; 
    private final int x[] = new int[ALL_PREY]; 
    private final int y[] = new int[ALL_PREY]; 
    public static int snakebody;

    private boolean leftMovement = false; 
    private boolean rightMovement = true; 
    private boolean upMovement = false;
    private boolean downMovement = false; 
    private boolean Gameinprogress = true;

    private PP_Prey p_prey ;
    private PP_Snake p_snake; 
    private Timer time; 
    private Image body; 
    private Image img; 
    private Image head; 

    public PP_GameBoard() {

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

        addKeyListener(new KAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT));
        loadingImages();
        initialiseGame();
    }

    /**
     * Method loadingImages
     * Loading the images from their declared image object 
     */
    private void loadingImages() {

        body = p_snake.body;
        img = p_prey.img;
        head = p_snake.head;
    }

    /**
     * Method initialiseGame
     * Initialising the game with the moving snake and randomly located prey
     */
    private void initialiseGame() {

        snakebody = 3;

        for (int n = 0; n < snakebody; n++) {
            x[n] = 50 - n * 10;
            y[n] = 50;
        }

        p_prey.randomposition(RAND_POSITION,PREY_SIZE);
        time = new Timer(DELAY, this);
        time.start();
    }

    // gameboard
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

    }
    // gameboard
    private void doDrawing(Graphics g) {

        if (Gameinprogress) {

            g.drawImage(img,p_prey.preyx,p_prey.preyy, this);

            for (int n = 0; n < snakebody; n++) {
                if (n == 0) {
                    g.drawImage(head, x[n], y[n], this);
                } else {
                    g.drawImage(body, x[n], y[n], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
            setVisible(false);
        }        
    }

    /**
     * Method gameOver
     * It is drawing the "Game Over" String message and calling the PP_SnakeGame class with object "game" 
     * @param g A parameter of graphics
     */
    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Serif", Font.BOLD, 16);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, (GAMEBOARD_WIDTH - metr.stringWidth(msg)) / 2, GAMEBOARD_HEIGHT / 2);

        PP_SnakeGame game = new PP_SnakeGame("Snake");
        game.setVisible(true);
    }

    /**
     * Method movesnake
     * Movement of the snake 
     */
    private void movesnake() {

        for (int n = snakebody; n > 0;  n--) {
            x[n] = x[(n - 1)];
            y[n] = y[(n - 1)];
        }

        if (leftMovement) {
            x[0] -= PREY_SIZE;
        }

        if (rightMovement) {
            x[0] += PREY_SIZE;
        }

        if (upMovement) {
            y[0] -= PREY_SIZE;
        }

        if (downMovement) {
            y[0] += PREY_SIZE;
        }
    }

    /**
     * Method CheckCollision
     * Checking the collision if snake head is collided with its own body or the board wall.
     */
    private void CheckCollision() {

        for (int n = snakebody; n > 0; n--) {

            if ((n > 4) && (x[0] == x[n]) && (y[0] == y[n])) {
                Gameinprogress = false;
            }
        }

        if (y[0] >= GAMEBOARD_HEIGHT) {
            Gameinprogress = false;
        }

        if (y[0] < 0) {
            Gameinprogress = false;
        }

        if (x[0] >= GAMEBOARD_WIDTH) {
            Gameinprogress = false;
        }

        if (x[0] < 0) {
            Gameinprogress = false;
        }

        if (!Gameinprogress) {
            time.stop();
        }
    }

    // gameboard
    @Override
    public void actionPerformed(ActionEvent e) {

        if (Gameinprogress) {

            p_prey.checkPrey(x[0],y[0],RAND_POSITION,PREY_SIZE);
            CheckCollision();
            movesnake();
        }

        repaint();
    }

    private class KAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightMovement)) {
                leftMovement = true;
                upMovement = false;
                downMovement = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftMovement)) {
                rightMovement = true;
                upMovement = false;
                downMovement = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downMovement)) {
                upMovement = true;
                rightMovement = false;
                leftMovement = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upMovement)) {
                downMovement = true;
                rightMovement = false;
                leftMovement = false;
            }
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
}