import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Arena extends JPanel implements ActionListener {
    Random ran = new Random();
    Timer timer = new Timer(10, this);
    private int numBall;
    private ArrayList<Ball> Balls = new ArrayList<>();

    public Arena() {
    }

    public Arena(int n) {
        numBall = n;
    }

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

            /*
             * Faz com que a esfera não seja criada para fora dos limites da arena com
             * relação à coordenada x de sua posição.
             */
            x = ran.nextInt(this.getWidth());
            if (x > this.getWidth() - Ball.DIAMETER - 3) {
                x = this.getWidth() - Ball.DIAMETER - 3;
            }

            /*
             * Faz com que a esfera não seja criada para fora dos limites da arena com
             * relação à coordenada y de sua posição.
             */
            y = ran.nextInt(this.getHeight());
            if (y > this.getHeight() - Ball.DIAMETER - 3) {
                y = this.getHeight() - Ball.DIAMETER - 3;
            }

            ball.setPosition(x, y);

            x = ran.nextInt(20) + 1;
            y = ran.nextInt(20) + 1;

            ball.setVelocity(x, y);

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
        Ball b;
        long cx, cy, c, pxb, pyb, pxB, pyB;

        for (int k = i + 1; k < Balls.size(); k++) {
            b = Balls.get(k);
            cx = B.getX() - b.getX();
            cy = B.getY() - b.getY();
            c = cx * cx + cy * cy;

            // Se a distância entre as esferas for menor que o diâmetro, então há colisão!
            if (c <= Ball.DIAMETER * Ball.DIAMETER) {

                pxb = ((b.Velocity.getX() * cx) + (b.Velocity.getY() * cy)) * cx / c;
                pyb = ((b.Velocity.getX() * cx) + (b.Velocity.getY() * cy)) * cy / c;
                pxB = ((B.Velocity.getX() * cx) + (B.Velocity.getY() * cy)) * cx / c;
                pyB = ((B.Velocity.getX() * cx) + (B.Velocity.getY() * cy)) * cy / c;

                B.Velocity.setX(B.Velocity.getX() - (pxB - pxb));
                B.Velocity.setY(B.Velocity.getY() - (pyB - pyb));
                b.Velocity.setX(b.Velocity.getX() - (pxb - pxB));
                b.Velocity.setY(b.Velocity.getY() - (pyb - pyB));

                if (cx != 0 && cy != 0) {
                    B.setPosition(B.getX() + cx / Math.abs(cx), B.getY() + cy / Math.abs(cy));
                    b.setPosition(b.getX() - cx / Math.abs(cx), b.getY() - cy / Math.abs(cy));
                }

                b.changePosition();
                B.changePosition();
            }
        }
    }

    public void addBall() {
        numBall++;
        int x, y;
        Ball ball = new Ball();

        x = ran.nextInt(this.getWidth());
        if (x > this.getWidth() - Ball.DIAMETER - 3) {
            x = this.getWidth() - Ball.DIAMETER - 3;
        }

        y = ran.nextInt(this.getHeight());
        if (y > this.getHeight() - Ball.DIAMETER - 3) {
            y = this.getHeight() - Ball.DIAMETER - 3;
        }

        ball.setPosition(x, y);

        x = ran.nextInt(5) + 1;
        y = ran.nextInt(5) + 1;

        ball.setVelocity(x, y);

        Balls.add(ball);

        repaint();
    }

    public void remBall() {
        if (numBall > 0) {
            numBall--;
        }

        Balls.remove(ran.nextInt(Balls.size()));
        repaint();
    }

    public void setNumBall(int n) {
        this.numBall = n;
    }

    public int getNumBall() {
        return numBall;
    }
}
