import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Arena extends JPanel implements ActionListener {
    Random Random;
    Timer Timer;
    private int numBall;
    private ArrayList<Ball> Balls;

    public Arena() {
        Random = new Random();
        Timer = new Timer(10, this);
        Balls = new ArrayList<>();
        numBall = 0;
    }

    public Arena(int n) {
        this();
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
             * relação à coordenada x e abaixo à coordenada y de sua posição.
             */
            x = Random.nextInt(this.getWidth());
            if (x > this.getWidth() - Ball.DIAMETER - 3) {
                x = this.getWidth() - Ball.DIAMETER - 3;
            }

            y = Random.nextInt(this.getHeight());
            if (y > this.getHeight() - Ball.DIAMETER - 3) {
                y = this.getHeight() - Ball.DIAMETER - 3;
            }

            ball.setPosition(x, y);

            x = Random.nextInt(20) + 1;
            y = Random.nextInt(20) + 1;

            ball.setVelocity(x, y);

            Balls.add(ball);
        }
    }

    public void start() {
        Timer.start();
    }

    public void stop() {
        Timer.stop();
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
        long collision, collisionX, collisionY, projXb, projYb, projXB, projYB;
        Ball b;

        for (int k = i + 1; k < Balls.size(); k++) {
            b = Balls.get(k);
            collisionX = B.getPosition().getX() - b.getPosition().getX();
            collisionY = B.getPosition().getY() - b.getPosition().getY();
            collision = collisionX * collisionX + collisionY * collisionY;

            // Se a distância entre as esferas for menor que o diâmetro, então há colisão!
            if (collision <= Ball.DIAMETER * Ball.DIAMETER) {

                projXB = ((B.getVelocity().getX() * collisionX) + (B.getVelocity().getY() * collisionY)) * collisionX
                        / collision;
                projYB = ((B.getVelocity().getX() * collisionX) + (B.getVelocity().getY() * collisionY)) * collisionY
                        / collision;
                projXb = ((b.getVelocity().getX() * collisionX) + (b.getVelocity().getY() * collisionY)) * collisionX
                        / collision;
                projYb = ((b.getVelocity().getX() * collisionX) + (b.getVelocity().getY() * collisionY)) * collisionY
                        / collision;

                B.getVelocity().setX(B.getVelocity().getX() - (projXB - projXb));
                B.getVelocity().setY(B.getVelocity().getY() - (projYB - projYb));
                b.getVelocity().setX(b.getVelocity().getX() - (projXb - projXB));
                b.getVelocity().setY(b.getVelocity().getY() - (projYb - projYB));

                if (collisionX != 0 && collisionY != 0) {
                    B.setPosition(B.getPosition().getX() + collisionX / Math.abs(collisionX),
                            B.getPosition().getY() + collisionY / Math.abs(collisionY));
                    b.setPosition(b.getPosition().getX() - collisionX / Math.abs(collisionX),
                            b.getPosition().getY() - collisionY / Math.abs(collisionY));
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

        x = Random.nextInt(this.getWidth());
        if (x > this.getWidth() - Ball.DIAMETER - 3) {
            x = this.getWidth() - Ball.DIAMETER - 3;
        }

        y = Random.nextInt(this.getHeight());
        if (y > this.getHeight() - Ball.DIAMETER - 3) {
            y = this.getHeight() - Ball.DIAMETER - 3;
        }

        ball.setPosition(x, y);

        x = Random.nextInt(5) + 1;
        y = Random.nextInt(5) + 1;

        ball.setVelocity(x, y);

        Balls.add(ball);

        repaint();
    }

    public void remBall() {
        if (numBall > 0) {
            numBall--;
        }

        Balls.remove(Random.nextInt(Balls.size()));
        repaint();
    }

    public void setNumBall(int n) {
        this.numBall = n;
    }

    public int getNumBall() {
        return numBall;
    }
}
