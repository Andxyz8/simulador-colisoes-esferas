import java.awt.Graphics;

public class Ball {
    static final int DIAMETER = 25;

    private Vetor2D Position;
    private Vetor2D Velocity;

    public Ball() {
        Position = new Vetor2D();
        Velocity = new Vetor2D();
    }

    public Ball(long velocityX, long velocityY, long positionY, long positionX) {
        this();
        setPosition(positionX, positionY);
        setVelocity(velocityX, velocityY);
    }

    public void paint(Graphics g) {
        g.fillOval(Math.toIntExact(Position.getX()), Math.toIntExact(Position.getY()), DIAMETER, DIAMETER);
    }

    public void movement(Arena rinha) {
        if (Position.getX() >= rinha.getWidth() - DIAMETER) {
            Position.setX(rinha.getWidth() - DIAMETER);
            Velocity.setX(Velocity.getX() * (-1));
        }

        if (Position.getX() <= 0) {
            Position.setX(0);
            Velocity.setX(Velocity.getX() * (-1));
        }

        if (Position.getY() >= rinha.getHeight() - DIAMETER) {
            Position.setY(rinha.getHeight() - DIAMETER);
            Velocity.setY(Velocity.getY() * (-1));
        }

        if (Position.getY() <= 0) {
            Position.setY(0);
            Velocity.setY(Velocity.getY() * (-1));
        }
        changePosition();
    }

    public void changePosition() {
        Position.setX(Position.getX() + Velocity.getX());
        Position.setY(Position.getY() + Velocity.getY());
    }

    public void setPosition(long x, long y) {
        Position.setX(x);
        Position.setY(y);
    }

    public void setVelocity(long x, long y) {
        Velocity.setX(x);
        Velocity.setY(y);
    }

    public Vetor2D getPosition() {
        return Position;
    }

    public Vetor2D getVelocity() {
        return Velocity;
    }
}
