package colisor;

import java.awt.Graphics;

public class Ball {

    static final int DIAMETER = 50;

    private int x, y;

    Vetor Direction = new Vetor();
    Vetor Velocity = new Vetor();

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void setVelocity(int x, int y) {
        Velocity.setX(x);
        Velocity.setY(y);
    }

    public void paint(Graphics g) {
        g.fillOval(getX(), getY(), DIAMETER, DIAMETER);
    }

    public void movement(Arena rinha) {

        if (getX() >= rinha.getWidth() - DIAMETER) {
            setX(rinha.getWidth() - DIAMETER);
            Direction.setX(Direction.getX() * (-1));
        }

        if (getX() <= 0) {
            setX(0);
            Direction.setX(Direction.getX() * (-1));
        }

        if (getY() >= rinha.getHeight() - DIAMETER) {
            setY(rinha.getHeight() - DIAMETER);
            Direction.setY(Direction.getY() * (-1));
        }

        if (getY() <= 0) {
            setY(0);
            Direction.setY(Direction.getY() * (-1));
        }

        changePosition();
    }

    public void changePosition() {
        setX(getX() + Velocity.getX() * Direction.getX());
        setY(getY() + Velocity.getY() * Direction.getY());
    }
    
    public void setDirection(int a, int b) {
        if (a == 1) {
            Direction.setX(1);
        } else {
            Direction.setX(-1);
        }

        if (b == 1) {
            Direction.setY(1);
        } else {
            Direction.setY(-1);
        }
    }

    int getDIAMETER() {
        return DIAMETER;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
