package colisor;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Arena extends JPanel implements ActionListener {

    Random ran = new Random();
    private int numBall;
    Timer timer = new Timer(10, this);
    private ArrayList<Ball> Balls = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Balls.stream().forEach((ball) -> {
            ball.paint(g);
        });
    }

    public void createBalls() {
        int x, y;
        for (int i = 0; i < numBall; i++) {
            Ball ball = new Ball();

            x = ran.nextInt(this.getWidth());
            if (x > this.getWidth() - ball.DIAMETER - 3) {
                x = this.getWidth() - ball.DIAMETER - 3;
            }

            y = ran.nextInt(this.getHeight());
            if (y > this.getHeight() - ball.DIAMETER - 3) {
                y = this.getHeight() - ball.DIAMETER - 3;
            }

            ball.setPosition(x, y);

            x = ran.nextInt(2) + 1;
            y = ran.nextInt(2) + 1;

            ball.setVelocity(x, y);

            ball.setDirection(x, y);
            Balls.add(ball);
        }
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    private void move() {
        int i = 0;
        for (Ball ball : Balls) {
            collisionBetweenBalls(ball, i);
            ball.movement(this);
            i++;
        }
    }

    private void collisionBetweenBalls(Ball B, int i) {
        int j = 0;
        double dist;
        double cx, cy, c, pxb, pyb, pxB, pyB;

        for (Ball b : Balls) {
            if (i != j) {
                dist = Math.sqrt(Math.pow(b.getX() - B.getX(), 2) + Math.pow(b.getY() - B.getY(), 2));

                if (dist <= B.getDIAMETER()) {
                    
                    /*cx = b.getX() - B.getX();
                    cy = b.getY() - B.getY();
                    c = cx * cx + cy * cy;

                    pxb = ((b.Velocity.getX() * cx) + (b.Velocity.getY() * cy)) * cx / c;
                    pyb = ((b.Velocity.getX() * cx) + (b.Velocity.getY() * cy)) * cy / c;
                    pxB = ((B.Velocity.getX() * cx) + (B.Velocity.getY() * cy)) * cx / c;
                    pyB = ((B.Velocity.getX() * cx) + (B.Velocity.getY() * cy)) * cy / c;

                    b.Velocity.setX((int) (pxb - pxB));
                    b.Velocity.setY((int) (pyb - pyB));
                    B.Velocity.setX((int) (pxB - pxb));
                    B.Velocity.setY((int) (pxB - pxb));
                    
                    if((pxb - pxB) > 0){
                        b.Direction.setX(1);
                    } else{
                        b.Direction.setX(-1);
                    }
                    
                    if((pyb - pyB) > 0){
                        b.Direction.setY(1);
                    } else{
                        b.Direction.setY(-1);
                    }
                    
                    if((pxB - pxb) > 0){
                        B.Direction.setX(1);
                    } else{
                        B.Direction.setX(-1);
                    }
                    
                    if((pyB - pyb) > 0){
                        B.Direction.setY(1);
                    } else{
                        B.Direction.setY(-1);
                    }
                    
                    System.out.println("bvX: " + b.Velocity.getX() + "pxb - pxB = " + (pxb - pxB));
                    System.out.println("bvY: " + b.Velocity.getY() + "pyb - pyB = " + (pyb - pyB));
                    System.out.println("BvX: " + b.Velocity.getX() + "pxB - pxb = " + (pxB - pxb));
                    System.out.println("BvY: " + b.Velocity.getY() + "pyB - pyb = " + (pyB - pyb));*/

                    b.Direction.setX((b.Direction.getX()*-1));
                    b.Direction.setY((b.Direction.getY()*-1));
                    B.Direction.setX((B.Direction.getX()*-1));
                    B.Direction.setY((B.Direction.getY()*-1));
                    
                    
                    b.changePosition();
                    B.changePosition();
                    //timer.stop();
                }
            }
            j++;
        }
    }

    public void addBall() {
        numBall++;
        int x, y;
        Ball ball = new Ball();

        x = ran.nextInt(this.getWidth());
        if (x > this.getWidth() - ball.DIAMETER - 3) {
            x = this.getWidth() - ball.DIAMETER - 3;
        }

        y = ran.nextInt(this.getHeight());
        if (y > this.getHeight() - ball.DIAMETER - 3) {
            y = this.getHeight() - ball.DIAMETER - 3;
        }

        ball.setPosition(x, y);

        x = ran.nextInt(2) + 1;
        y = ran.nextInt(2) + 1;

        ball.setVelocity(x, y);

        ball.setDirection(x, y);

        Balls.add(ball);
    }

    public void remBall() {
        if (numBall > 0) {
            numBall--;
        }

        Balls.remove(ran.nextInt(Balls.toArray().length));
    }

    public void setNumBall(int n) {
        this.numBall = n;
    }

    public int getNumBall() {
        return numBall;
    }

}
