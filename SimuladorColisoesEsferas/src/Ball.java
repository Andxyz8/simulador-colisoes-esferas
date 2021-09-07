import java.awt.Graphics;

public class Ball {
    static final int DIAMETER = 25;

    private long x, y;

    Vetor Velocity = new Vetor();

    public void setPosition(long x, long y) {
        this.setX(x);
        this.setY(y);
    }

    public void setVelocity(int x, int y) {
        Velocity.setX(x);
        Velocity.setY(y);
    }

    public void paint(Graphics g) {
        g.fillOval(Math.toIntExact(Math.round(getX())), Math.toIntExact(Math.round(getY())), DIAMETER, DIAMETER);
    }

    public void movement(Arena rinha) {
        if (getX() >= rinha.getWidth() - DIAMETER) {
            setX(rinha.getWidth() - DIAMETER);
            Velocity.setX(Velocity.getX() * (-1));
        }

        if (getX() <= 0) {
            setX(0);
            Velocity.setX(Velocity.getX() * (-1));
        }

        if (getY() >= rinha.getHeight() - DIAMETER) {
            setY(rinha.getHeight() - DIAMETER);
            Velocity.setY(Velocity.getY() * (-1));
        }

        if (getY() <= 0) {
            setY(0);
            Velocity.setY(Velocity.getY() * (-1));
        }
        changePosition();
    }

    public void changePosition() {
        setX(getX() + Velocity.getX());
        setY(getY() + Velocity.getY());
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
