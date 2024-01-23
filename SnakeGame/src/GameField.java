import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int DOTSIZE = 16;

    private final int ALLDOTS = 400;
    private Image dot;
    private Image apple;
    private int applex;
    private int appley;
    private int[] x = new int[ALLDOTS];
    private int[] y = new int[ALLDOTS];

    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
   public GameField(){
     setBackground(Color.BLACK);
     loadImages();
     initGame();
     addKeyListener(new fieldKeyListener());
     setFocusable(true);
   }
   public void loadImages(){
       ImageIcon icon = new ImageIcon("dot.png");
       apple = icon.getImage();
       ImageIcon icon1 = new ImageIcon("snake.png");
       dot = icon1.getImage();
   }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(apple,applex,appley,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
        }else{
            String qwe ="GAME OVER";
            g.setColor(Color.white);
            g.drawString(qwe,125,SIZE/2);
        }
    }

    public void initGame(){
       dots = 3;
       for(int i = 0;i<dots;i++){
           x[i] = 48 - i+DOTSIZE;
           y[i] = 48;
       }
       timer = new Timer(250,this);
       timer.start();
       createApple();
   }
   public void createApple(){
       applex = new Random().nextInt(20)*DOTSIZE;
       appley = new Random().nextInt(20)*DOTSIZE;
   }

   public void move(){
       for (int i = dots; i > 0; i--) {
           x[i] = x[i-1];
           y[i] = y[i-1];
       }
       if(left){
           x[0] -= DOTSIZE;
       }
       if(right){
           x[0] += DOTSIZE;
       }
       if(up){
           y[0] -= DOTSIZE;
       }
       if(down){
           y[0] += DOTSIZE;
       }
   }
   public void checkApple(){
       if(x[0] == applex && y[0] ==appley){
           dots++;
           createApple();

       }
   }
   public void checkCollision(){
       for (int i = dots; i > 0 ; i--) {
           if(i>4 && x[0] == x[i] && y[0] == y[i]){
            inGame = false;
           }

       }
       if(x[0] > SIZE){
           inGame = false;
       }
       if(x[0] < 0){
           inGame = false;
       }
       if(y[0] > SIZE){
           inGame = false;
       }
       if(y[0] < 0){
           inGame = false;
       }

   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollision();
            move();

        }
        repaint();
    }

    class fieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && ! right){
                left =true;
                down = false;
                up=false;
            }
            if(key == KeyEvent.VK_RIGHT && ! left){
                down =false;
                right = true;
                up=false;
            }
            if(key == KeyEvent.VK_UP && ! down){
                left =false;
                right = false;
                up=true;
            }
            if(key == KeyEvent.VK_DOWN && ! up){
                left =false;
                right = false;
                down=true;
            }
        }
    }
}
