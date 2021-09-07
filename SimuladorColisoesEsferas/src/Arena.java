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
        // long dist;
        long cx, cy, c, pxb, pyb, pxB, pyB;

        for (Ball b : Balls) {
            if (i != j) {
                cx = b.getX() - B.getX();
                cy = b.getY() - B.getY();
                c = cx * cx + cy * cy;
                // dist = (long) Math.sqrt(Math.pow(b.getX() - B.getX(), 2) + Math.pow(b.getY()
                // - B.getY(), 2));
                // B.getY(), 2));

                // Se a distância entre as esferas menor que o diâmetro, então há colisão!
                if (c <= Ball.DIAMETER * Ball.DIAMETER) {

                    pxb = ((b.Velocity.getX() * cx) + (b.Velocity.getY() * cy)) * cx / c;
                    pyb = ((b.Velocity.getX() * cx) + (b.Velocity.getY() * cy)) * cy / c;
                    pxB = ((B.Velocity.getX() * cx) + (B.Velocity.getY() * cy)) * cx / c;
                    pyB = ((B.Velocity.getX() * cx) + (B.Velocity.getY() * cy)) * cy / c;

                    System.out.println("Pos b x: " + b.getX() + "\tPos b y: " + b.getY());
                    System.out.println("Pos B x: " + B.getX() + "\tPos B y: " + B.getY());

                    System.out.println("Dir b x: " + b.Direction.getX() + "\tDir b y: " + b.Direction.getY());
                    System.out.println("Dir B x: " + B.Direction.getX() + "\tDir B y: " + B.Direction.getY());

                    System.out.println("Vel b x: " + b.Velocity.getX() + "\tVel b y: " + b.Velocity.getY());
                    System.out.println("Vel B x: " + B.Velocity.getX() + "\tVel B y: " + B.Velocity.getY());

                    System.out.println("\n\npxb - pxB: " + (pxb - pxB) + "\tpyb - pyB: " + (pyb - pyB));
                    System.out.println("pxB - pxb: " + (pxB - pxb) + "\tpyB - pyb: " + (pyB - pyb));

                    timer.stop();

                    b.Velocity.setX((pxb - pxB));
                    b.Velocity.setY((pyb - pyB));
                    B.Velocity.setX((pxB - pxb));
                    B.Velocity.setY((pyB - pyb));

                    if ((pxb - pxB) > 0) {
                        b.Direction.setX(1);
                    } else {
                        b.Direction.setX(-1);
                    }

                    if ((pyb - pyB) > 0) {
                        b.Direction.setY(1);
                    } else {
                        b.Direction.setY(-1);
                    }

                    if ((pxB - pxb) > 0) {
                        B.Direction.setX(1);
                    } else {
                        B.Direction.setX(-1);
                    }

                    if ((pyB - pyb) > 0) {
                        B.Direction.setY(1);
                    } else {
                        B.Direction.setY(-1);
                    }

                    // b.Direction.setX((b.Direction.getX() * -1));
                    // b.Direction.setY((b.Direction.getY() * -1));
                    // B.Direction.setX((B.Direction.getX() * -1));
                    // B.Direction.setY((B.Direction.getY() * -1));

                    b.changePosition();
                    B.changePosition();
                    timer.stop();
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

        ball.setDirection(x, y);

        Balls.add(ball);

        repaint();
    }

    public void remBall() {
        if (numBall > 0) {
            numBall--;
        }

        Balls.remove(ran.nextInt(Balls.toArray().length));
        repaint();
    }

    public void setNumBall(int n) {
        this.numBall = n;
    }

    public int getNumBall() {
        return numBall;
    }
}
